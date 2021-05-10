package annotations.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
        c.scan("annotations.example");
        c.refresh();

        MessageRenderer mr = c.getBean(MessageRenderer.class);
        mr.render();
        c.close();
    }
}
