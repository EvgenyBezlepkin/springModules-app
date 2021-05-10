package jugru;

import annotations.example.test.TestB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config2 {

    @Bean
    public TestB testB() {
        return new TestB();
    }
}
