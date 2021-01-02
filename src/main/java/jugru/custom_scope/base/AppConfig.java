package jugru.custom_scope.base;

import jugru.custom_scope.scope.CustomScopeRegistryBFPP;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    @Scope("periodical")
    public Color color() {
        Random random = new Random();
        return new Color(   random.nextInt(255),
                            random.nextInt(255),
                            random.nextInt(255));
    }


}
