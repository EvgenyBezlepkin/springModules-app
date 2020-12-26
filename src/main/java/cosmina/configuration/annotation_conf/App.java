package cosmina.configuration.annotation_conf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
        acac.scan("cosmina.configuration.annotation_conf");
        acac.refresh();
        MessageRenderer mr = acac.getBean("renderer", MessageRenderer.class);
        mr.render();
        acac.close();
    }
}
