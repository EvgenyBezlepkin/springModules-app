package injection;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class InjectXml {

    private String s;
    private int i;
    private InjectedClass ic;
    private Map<String, Object> map;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public InjectedClass getIc() {
        return ic;
    }

    public void setIc(InjectedClass ic) {
        this.ic = ic;
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

    @Override
    public String toString() {
        return "InjectXml{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", ic=" + ic +
                '}';
    }

    public void printMap() {
        map.entrySet().stream().forEach((e) -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:applicationContext_2.xml");
        ctx.refresh();
        InjectXml sv = ctx.getBean("injectXml", InjectXml.class);
        System.out.println(sv);
        sv.printMap();
        ctx.close();
    }

}
