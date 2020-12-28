package jugru.proxy_example.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_6.xml");

        Quoter q = ctx.getBean(Quoter.class);

        // jvisualvm должен подключиться к java-процессу поэтому лучше запустить бесконечный цикл
        //while (true) {
            q.sayQuoter();
        //}

        //ctx.close();
    }
}
