package annotations.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
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
