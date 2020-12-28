package jugru.application_listener_ex;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_7.xml");

        // лучше искать бин по интерфейсу а не по классу
        Quoter q = ctx.getBean(Quoter.class);
        ctx.close();

    }
}
