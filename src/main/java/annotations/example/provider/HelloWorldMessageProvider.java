package annotations.example.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Profile("active")
@Primary
@Order(1)
@DependsOn("constants")
public class HelloWorldMessageProvider implements MessageProvider {

    @Value("#{constants.s}")
    private String s;


    @Override
    public String getMessage() {
        return s;
    }
}
