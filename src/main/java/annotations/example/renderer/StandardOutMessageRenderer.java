package annotations.example.renderer;

import annotations.example.provider.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("active")

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
