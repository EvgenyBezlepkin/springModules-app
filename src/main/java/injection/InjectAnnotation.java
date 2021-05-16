package injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;


@Component
public class InjectAnnotation {

    @Value("#{injectConfig.s}")
    private String s;
    @Value("#{injectConfig.i + 1}")
    private int i;
    @Autowired @Qualifier("injectedClass")
    private InjectedClass ic;
    @Value("#{injectConfig.map}")
    private Map<String, Object> map;

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

    public InjectedClass getIc() {
        return ic;
    }

    public void setIc(InjectedClass ic) {
        this.ic = ic;
    }

    @Override
    public String toString() {
        return "InjectAnnotation{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", ic=" + ic +
                '}';
    }

    public void print() {
        map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
        acac.scan("injection");
        acac.refresh();

        InjectAnnotation ia = acac.getBean("injectAnnotation", InjectAnnotation.class);
        System.out.println(ia);
        ia.print();

        acac.close();
    }

}
