package starter;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StarterConfiguration {

    @Bean
    public CustomListener getCustomListener() {
        return new CustomListener();
    }
}
