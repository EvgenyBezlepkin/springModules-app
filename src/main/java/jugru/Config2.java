package jugru;

import annotations.example.test.TestA;
import annotations.example.test.TestB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


@Configuration

public class Config2 {

    @Profile("test")
    @Bean
    @Primary
    public TestB testB() {
        return new TestB();
    }

    @Profile("active")
    @Bean
    public TestA testA() {
        return new TestA();
    }
}
