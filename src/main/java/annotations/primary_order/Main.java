package annotations.primary_order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("annotations.injection_order");
        context.refresh();

        Quoter bean = context.getBean(Quoter.class);
        bean.sayQuoter();

        Quoters bean1 = context.getBean(Quoters.class);
        bean1.say();

        context.close();
    }
}
