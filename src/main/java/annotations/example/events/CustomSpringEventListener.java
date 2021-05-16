package annotations.example.events;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

    // способ через имплементацию
    @Override
    public void onApplicationEvent(CustomSpringEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage());
    }

    // способ через аннотацию
    @EventListener
    // @Async
    public void onApplicationEventAnnotation(CustomSpringEvent event) {
        System.out.println("Received spring custom event from annotated method - " + event.getMessage());
    }
}
