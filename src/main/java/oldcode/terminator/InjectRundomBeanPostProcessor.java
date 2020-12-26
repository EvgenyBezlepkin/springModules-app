package oldcode.terminator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;


import java.lang.reflect.Field;
import java.util.Random;

public class InjectRundomBeanPostProcessor implements BeanPostProcessor {

    // BeanFactoryPostProcessor - позволяет настраивать бин дефинишн до создания бина


    // BeanPostProcessor прогоняет все бины через два нижеукзанных метода для кастомизации инициализации
    // между ними вызывает init-метод - @PostConstruct
    // на этапе before прокси не создаются, чтобы была гарантия, что мы рботаем с оригинальным классом
    // это делается на этапе after

    // трехфазовый конструктор - конструктор ява, @PostConstructor, @PostInitialize

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRundomInt annotation = field.getAnnotation(InjectRundomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, min + random.nextInt(max-min));
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
