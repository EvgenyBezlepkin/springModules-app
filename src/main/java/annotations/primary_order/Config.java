package annotations.primary_order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
public class Config {

    // если существует две и более имплементаций инжектируемого интерфейса
    // Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException:
    // No qualifying bean of type 'Quoter' available: expected single matching bean but found 2:

    @Bean
    // The @Order annotation defines the sorting order of an annotated component or bean.
    @Order(1)
    // we use @Primary to give higher preference to a bean when there are multiple beans of the same type.
    @Primary
    Quoter quoter1() {
        return new QuoterImpl1();
    }

    @Bean
    @Order(2)
    Quoter quoter2() {
        return new QuoterImpl2();
    }
}
