package jugru.transactional_ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;


@SpringBootApplication
public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext cac = SpringApplication.run(App.class, args)) {

            FirstServiceImpl firstService = cac.getBean("firstServiceImpl", FirstServiceImpl.class);
            firstService.insert();
            System.out.println(Arrays.toString(cac.getBeanDefinitionNames()));
        }

    }
}
