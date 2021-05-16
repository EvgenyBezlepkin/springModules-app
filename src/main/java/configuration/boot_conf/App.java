package configuration.boot_conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootConfiguration
@EnableAutoConfiguration
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(App.class, args);
        MessageRenderer mr = cac.getBean("standardOutMessageRenderer", StandardOutMessageRenderer.class);
        mr.render();
        cac.close();

    }
}
