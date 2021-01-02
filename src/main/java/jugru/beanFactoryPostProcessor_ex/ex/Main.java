package jugru.beanFactoryPostProcessor_ex.ex;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_8.xml");

        Quoter q = ctx.getBean(Quoter.class);
        q.sayQuoter();
        ctx.close();

    }
}
