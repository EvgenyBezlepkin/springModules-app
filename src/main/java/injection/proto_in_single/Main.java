package injection.proto_in_single;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("injection.proto_in_single");
        ctx.refresh();

        for (int i = 0; i < 500; i++) {
            ctx.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(300);
        }

    }
}
