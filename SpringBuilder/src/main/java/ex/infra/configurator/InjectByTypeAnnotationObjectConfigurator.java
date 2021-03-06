package ex.infra.configurator;

import ex.infra.AppContext;
import ex.infra.ObjectFactory;
import ex.infra.annotation.InjectByType;
import lombok.SneakyThrows;
import java.lang.reflect.Field;


public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator{


    @Override
    public void configure(Object o, AppContext context) throws Exception {
        for( Field field : o.getClass().getDeclaredFields()) {
            InjectByType annotation = field.getAnnotation(InjectByType.class);
            if (annotation != null) {
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(o, object);
            }
        }
    }
}
