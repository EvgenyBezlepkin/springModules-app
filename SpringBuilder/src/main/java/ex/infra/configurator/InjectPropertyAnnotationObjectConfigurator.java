package ex.infra.configurator;

import ex.infra.annotation.InjectProperty;
import lombok.SneakyThrows;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Properties;


public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator{

    private final Properties p;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator() {
        String resource = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        p = new Properties();
        p.load(new FileReader(resource));
    }

    @SneakyThrows
    @Override
    public void configure(Object o) {
        Class<?> impl = o.getClass();
        // не захватывает наследованные поля
        for( Field field : impl.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);

            String value;
            if (annotation != null) {
                value = annotation.value().isEmpty() ? p.getProperty(field.getName()) : p.getProperty(annotation.value());
                field.setAccessible(true);
                field.set(o, value);
            }
        }
    }
}
