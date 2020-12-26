package injection;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleValueXml {

    private String s;
    private int i;

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
        return "SimpleValueXML{" +
                "s='" + s + '\'' +
                ", i=" + i +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:applicationContext_2.xml");
        ctx.refresh();
        SimpleValueXml sv = ctx.getBean("simpleValueXml", SimpleValueXml.class);
        System.out.println(sv);
        ctx.close();
    }

}
