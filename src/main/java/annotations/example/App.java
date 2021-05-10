package annotations.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
        c.scan("annotations.example");
        c.refresh();

        MessageRenderer mr = c.getBean(MessageRenderer.class);
        System.out.println("From messageRenderer");
        mr.render();

        MessageRendererList mrl = c.getBean(MessageRendererList.class);
        System.out.println("From messageRendererList");
        mrl.render();

        c.close();
    }
}
