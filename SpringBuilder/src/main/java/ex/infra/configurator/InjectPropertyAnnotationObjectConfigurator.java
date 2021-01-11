package ex.infra.configurator;

import ex.infra.annotation.InjectProperty;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;


public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator{

    private final Properties p;


    public InjectPropertyAnnotationObjectConfigurator() throws IOException {
        String resource = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        p = new Properties();
        p.load(new FileReader(resource));
    }


    @Override
    public void configure(Object o) throws IllegalAccessException {
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
