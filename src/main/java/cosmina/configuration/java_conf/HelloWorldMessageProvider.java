package cosmina.configuration.java_conf;

import org.springframework.stereotype.Component;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World";
    }
}
