package annotations.example;

import org.springframework.stereotype.Component;

@Component
public class Constants {

    private String s = "Hello world";

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
