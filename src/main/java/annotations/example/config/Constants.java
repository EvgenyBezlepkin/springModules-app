package annotations.example.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("active")
public class Constants {

    private String s = "Hello world";

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
