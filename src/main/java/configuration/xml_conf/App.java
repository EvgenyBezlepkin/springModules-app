package configuration.xml_conf;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:applicationContext_1.xml");
        ctx.refresh();
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
        ctx.close();
    }
}
