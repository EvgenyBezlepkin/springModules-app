package annotations.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;


@Component


public class StandardOutMessageRenderer implements MessageRenderer {

    @Autowired
    @Qualifier("helloWorldMessageProvider")
    private MessageProvider mp;

    @Override
    public void render() {
        if (mp == null) {
            throw new RuntimeException("Message provider is disable");
        }
        // лист создается спрингом с учетом аннотаций @Order
        System.out.println(mp.getMessage());
    }

    public MessageProvider getMp() {
        return mp;
    }

    public void setMp(MessageProvider mp) {
        this.mp = mp;
    }
}
