package ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;
import starter.StarterConfiguration;

import java.util.Arrays;
import java.util.stream.Stream;


@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan

// для загрузки инфраструктурного бина можно прописать импорт на него, но для этого необходимо знать конфигурационный класс стартера
//@Import(StarterConfiguration.class)

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);

        Stream.of(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);

        //DispatcherServlet ds = ctx.getBean("dispatcherServlet", DispatcherServlet.class);

        ctx.close();
    }
}
