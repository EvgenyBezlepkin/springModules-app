package annotations.example;

import annotations.example.config.Config;
import annotations.example.lang.MessageSource_and_PropertySource;
import annotations.example.renderer.MessageRenderer;
import annotations.example.renderer.MessageRendererList;
import annotations.example.test.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();

        // задаем профайлы
            c.getEnvironment().setActiveProfiles("active");
            // в случае ниже активны два бина из Config2 (чтобы не произошло конфликта TestB помечаен @Primary)
            //c.getEnvironment().setActiveProfiles("active", "test");
        // на конфигурации находится аннотация @ComponentScan
        c.register(Config.class);
        // обновляем контекст
        c.refresh();

        MessageRenderer mr = c.getBean(MessageRenderer.class);
        System.out.print("From messageRenderer : ");
        mr.render();

        // для аннотации @Order
        MessageRendererList mrl = c.getBean(MessageRendererList.class);
        System.out.print("From messageRendererList : ");
        mrl.render();

        // для аннотации @Import и @Propfile
        Test t = c.getBean(Test.class);
        System.out.println(t.getS());

        // для локализации
        MessageSource_and_PropertySource l = c.getBean(MessageSource_and_PropertySource.class);
        l.getMessage();

        c.close();
    }
}
