package annotations.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// местонахождение импортируемой конфигурации
import jugru.Config2;
import org.springframework.context.support.ResourceBundleMessageSource;


@Configuration
@ComponentScan(basePackages = "annotations.example")
@Import(Config2.class)
public class Config {


    // конфигурационный бин для локализации
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource s = new ResourceBundleMessageSource();
        s.setBasename("messages");
        s.setDefaultEncoding("UTF-8");
        return s;
    }

}
