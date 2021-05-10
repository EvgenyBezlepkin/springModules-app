package annotations.example;

import annotations.example.config.Config;
import annotations.example.renderer.MessageRenderer;
import annotations.example.renderer.MessageRendererList;
import annotations.example.test.Test;
import annotations.example.test.TestB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();

        // на конфигурации находится аннотация @ComponentScan
        c.register(Config.class);
        c.refresh();

        MessageRenderer mr = c.getBean(MessageRenderer.class);
        System.out.println("From messageRenderer");
        mr.render();

        // для аннотации @Order
        MessageRendererList mrl = c.getBean(MessageRendererList.class);
        System.out.println("From messageRendererList");
        mrl.render();

        // для аннотации @Import
        Test t = c.getBean(Test.class);
        System.out.println(t.getS());

        c.close();
    }
}
