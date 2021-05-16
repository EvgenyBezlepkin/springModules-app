package ex;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class AppConfig {

    // если существует свой листенер, то листенер стартера не загрузится


//    @Bean
//    public ApplicationListener<ContextRefreshedEvent> myListener() {
//        return applicationEvent -> System.out.println("my listener");
//    }


}
