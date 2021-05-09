package jugru.base_example_bpp_ex;

import jugru.custom_annotation.RundomIntAnnotationBPP;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

    // добавление BPP через XML и через аннотации

// конфигурация через XML
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_4.xml");
//        Quoter q = ctx.getBean(Quoter.class);
//        q.sayQuoter();
//        ctx.close();

// конфигурация через аннотации
            // (из контекста получаем BeanFactory (ConfigurableListableBeanFactory)
            // добавляем пользовательский BPP
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
        acac.scan("jugru.base_example_bpp_ex");
        ConfigurableListableBeanFactory beanFactory = acac.getBeanFactory();
        beanFactory.addBeanPostProcessor(new RundomIntAnnotationBPP());
        acac.refresh();

        // добавляем аннотацию @Component на реализации
        // или добавляем через @Bean в конфигурационном классе
        Quoter bean = acac.getBean(Quoter.class);
        bean.sayQuoter();
        acac.close();
    }
}
