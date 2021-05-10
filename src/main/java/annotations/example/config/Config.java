package annotations.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// местонахождение импортируемой конфигурации
import jugru.Config2;


@Configuration
@ComponentScan(basePackages = "annotations.example")
@Import(Config2.class)
public class Config {

}
