package injection;

import org.springframework.stereotype.Component;

@Component("injectedClass")
public class InjectedClass {
    private String s = "world";

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "InjectedClass{" +
                "s='" + s + '\'' +
                '}';
    }
}
