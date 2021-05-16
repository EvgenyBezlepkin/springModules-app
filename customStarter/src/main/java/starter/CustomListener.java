package starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


// слушаем событие обновления контекта (т.е. контекст готов)
public class CustomListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private StarterProperties starterProperties;

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Context is ready");
        starterProperties.getDestinations().forEach(System.out::println);
    }

    public StarterProperties getStarterProperties() {
        return starterProperties;
    }

    public void setStarterProperties(StarterProperties starterProperties) {
        this.starterProperties = starterProperties;
    }
}
