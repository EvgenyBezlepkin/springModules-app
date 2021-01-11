package ex.infra.configurator;

import ex.infra.ObjectFactory;
import ex.infra.annotation.InjectByType;
import lombok.SneakyThrows;
import java.lang.reflect.Field;


public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator{


    @Override
    public void configure(Object o) throws Exception {
        for( Field field : o.getClass().getDeclaredFields()) {
            InjectByType annotation = field.getAnnotation(InjectByType.class);
            if (annotation != null) {
                field.setAccessible(true);
                Object object = ObjectFactory.getInstance().createObject(field.getType());
                field.set(o, object);
            }
        }
    }
}
