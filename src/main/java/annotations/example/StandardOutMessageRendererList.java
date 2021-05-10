package annotations.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;


@Component

// Spring guarantees that the defined beans will be initialized before attempting an initialization of the current bean.
@DependsOn({"helloWorldMessageProvider", "hyPeoplesMessageProvider"})
public class StandardOutMessageRendererList implements MessageRendererList {

    @Autowired
    private List<MessageProvider> mp;

    @Override
    public void render() {
        if (mp == null) {
            throw new RuntimeException("Message provider is disable");
        }
        // лист создается спрингом с учетом аннотаций @Order
        System.out.println(mp.get(1).getMessage());
    }

    public List<MessageProvider> getMp() {
        return mp;
    }

    public void setMp(List<MessageProvider> mp) {
        this.mp = mp;
    }
}
