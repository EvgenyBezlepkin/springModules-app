package annotations.example.lang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class Lang {

    @Autowired
    private MessageSource ms;

    @Value("message")
    private String s;

    public void getMessage() {
        System.out.println(ms.getMessage("message", new Object[]{"Test"}, Locale.ENGLISH));
        System.out.println(ms.getMessage("message", new Object[]{"Test"}, Locale.FRENCH));
    }
}
