package annotations.example.provider;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class HyPeoplesMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "HyPeoples";
    }
}
