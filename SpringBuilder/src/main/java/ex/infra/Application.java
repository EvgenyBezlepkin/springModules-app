package ex.infra;

import ex.infra.config.AppConfig;
import ex.infra.config.JavaConfig;

import java.util.Map;

public class Application {

    public static AppContext run(String packageToScan, Map<Class, Class> map) {
        AppConfig config = new JavaConfig(packageToScan, map);
        AppContext context = new AppContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setFactory(objectFactory);
        return context;
        // make @Prototype, singleton and lazy singleton
    }
}
