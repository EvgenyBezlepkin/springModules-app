package annotations.example.lang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
// аннотация загружает внешний ресурс, котрый доступен через аннотацию @Value, либо через Environment
@PropertySource("classpath:application.properties")
public class MessageSource_and_PropertySource {

    // для локализации
    @Autowired
    private MessageSource ms;

    // способ получения внешнего ресурса через Environment
    @Autowired
    private Environment env;

    // способ получения внешнего ресурса через @Value
    @Value("${testProp}")
    private String s;


    public void getMessage() {
        System.out.println("------------------------------");
        System.out.println(ms.getMessage("message", new Object[]{"Test"}, Locale.ENGLISH));
        System.out.println(ms.getMessage("message", new Object[]{"Test"}, Locale.FRENCH));
        System.out.println("------------------------------");
        System.out.print("propertySource test : ");
        System.out.println(s);
        System.out.print("environment test : ");
        System.out.println(env.getProperty("testProp"));
        System.out.println("------------------------------");
    }
}
