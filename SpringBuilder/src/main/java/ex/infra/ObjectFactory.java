package ex.infra;


import ex.infra.config.AppConfig;
import ex.infra.configurator.ObjectConfigurator;


import java.util.*;

public class ObjectFactory {

    private final AppConfig config;
    private AppContext context;
    private final List<ObjectConfigurator> configurators = new ArrayList<>();


    public ObjectFactory(AppContext context) {
        this.context = context;
        config = context.getConfig();
        for (Class<? extends ObjectConfigurator> c : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            try {
                configurators.add(c.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public <T> T createObject(Class<T> impl) throws Exception {

        T t = impl.getDeclaredConstructor().newInstance();

        configurators.forEach(x -> {
            try {
                x.configure(t, context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return t;
    }
}
