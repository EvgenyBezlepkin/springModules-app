package starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

// здесь можно задать свойства для application.yml
@ConfigurationProperties(prefix = "starter")
public class StarterProperties {

    private List<String> destinations;

    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }
}
