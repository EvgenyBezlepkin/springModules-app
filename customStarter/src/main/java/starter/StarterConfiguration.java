package starter;


import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(StarterProperties.class)
public class StarterConfiguration {

    @Bean
    // пользовательский кондишн, который создает / не создает бин в зависимости от какой-то логики
    @ConditionalOnStarter
    // бин создается при наличии этого свойства в аппликейшн проекта
    @ConditionalOnProperty("starter.destinations")
    // бин создается если в проекте нет соответствующего бина (смотрим по интерфейсу)
    //@ConditionalOnMissingBean(ApplicationListener.class)
    public CustomListener getCustomListener() {
        return new CustomListener();
    }

}
