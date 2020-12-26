package cosmina.configuration.annotation_conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    @Autowired
    private MessageProvider mp;

    @Override
    public void render() {
        if (mp == null) {
            throw new RuntimeException("Message provider is disable");
        }
        System.out.println(mp.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider mp) {
        this.mp = mp;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return mp;
    }
}
