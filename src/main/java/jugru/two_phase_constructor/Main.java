package jugru.two_phase_constructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_5.xml");

        // лучше искать бин по интерфейсу а не по классу
        Quoter q = ctx.getBean("quoterImpl", Quoter.class);
        q.sayQuoter();
        ctx.close();

    }
}
