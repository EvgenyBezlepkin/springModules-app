package injection.proto_in_single;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    // первый вариант
    // инъекция прототипа в синглтон с помощью проксирования, каждый раз получаем новый бин
    //@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Scope("prototype")
    public Color color() {
        Random random = new Random();
        return new Color(   random.nextInt(255),
                            random.nextInt(255),
                            random.nextInt(255));
    }


    // второй вариант
    // ручная имплементация первого варинта,
    // если бин - синглтон, будет возвращаться он же,
    // если бин прототип - будет возвращаться новый бин
    @Bean
    public ColorFrame frame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }
}
