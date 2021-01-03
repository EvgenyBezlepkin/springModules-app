package starter;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(StarterProperties.class)
public class StarterConfiguration {

    @Bean
    //@ConditionalOnStarter(enable = true)
    public CustomListener getCustomListener() {
        return new CustomListener();
    }

}
