package injection;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// значения для внедрения
@Component("injectConfig")
public class InjectConfig {

    private String s = "hello";
    private int i = 10;

    Map<String, Object> map = new HashMap<>();

    {
        map.put("firstKey", "firstValue");
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
