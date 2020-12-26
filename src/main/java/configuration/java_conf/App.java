package configuration.java_conf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(HWConfiguration.class);

        MessageRenderer mr = acac.getBean("renderer", MessageRenderer.class);
        mr.render();
        acac.close();
    }
}
