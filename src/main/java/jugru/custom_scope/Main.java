package jugru.custom_scope;

import jugru.custom_scope.base.ColorFrame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("jugru.custom_scope");
        ctx.refresh();

        for (int i = 0; i < 500; i++) {
            ctx.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(300);
        }

    }
}
