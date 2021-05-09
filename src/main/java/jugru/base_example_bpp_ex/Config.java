package jugru.base_example_bpp_ex;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class Config {

    @Bean
    Quoter quoter() {
        return new QuoterImpl();
    }
}
