package starter;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

// проверка наличия профайлов
public class CheckingProfileAppInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        if (applicationContext.getEnvironment().getActiveProfiles().length == 0) {
            throw new RuntimeException("set profile");
        }
    }
}
