package cosmina.configuration.boot_conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(App.class, args);
        MessageRenderer mr = cac.getBean("standardOutMessageRenderer", StandardOutMessageRenderer.class);
        mr.render();
        cac.close();

    }
}
