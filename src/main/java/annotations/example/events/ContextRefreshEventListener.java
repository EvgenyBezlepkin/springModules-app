package annotations.example.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


// пример прослушивания определенного события ContextRefreshedEvent (имплементация  ApplicationListener<ContextRefreshedEvent>)
@Component
public class ContextRefreshEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("-------- слушаем рефреш эвент ----------");
    }
}
