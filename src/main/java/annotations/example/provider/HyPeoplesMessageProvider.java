package annotations.example.provider;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile("active")
@Order(2)
public class HyPeoplesMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "HyPeoples";
    }
}
