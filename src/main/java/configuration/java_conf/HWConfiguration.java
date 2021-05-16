package configuration.java_conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "cosmina.configuration.java_conf")
@Configuration
public class HWConfiguration {

    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer renderer() {
        MessageRenderer mr = new StandardOutMessageRenderer();
        mr.setMessageProvider(provider());
        return mr;
    }

}
