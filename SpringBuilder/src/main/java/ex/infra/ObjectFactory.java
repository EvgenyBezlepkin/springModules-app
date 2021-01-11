package ex.infra;


import ex.custom.provider.Console2Provider;
import ex.custom.provider.DataProvider;
import ex.infra.config.JavaConfig;
import ex.infra.configurator.ObjectConfigurator;


import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ObjectFactory {

    private JavaConfig config;
    private static final ObjectFactory instance = new ObjectFactory();
    private final Map<Class, Class> map;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    {
        map = new HashMap<Class, Class>();
        map.put(DataProvider.class, Console2Provider.class);
    }


    private ObjectFactory() {
        config = new JavaConfig("ex", map);
        for (Class<? extends ObjectConfigurator> c : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            try {
                configurators.add(c.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ObjectFactory getInstance() {
        return instance;
    }


    public <T> T createObject(Class<T> type) throws Exception {
        Class<? extends T> impl = type;
        if (type.isInterface()) {
            impl = config.getImplClass(type);
        }
        T t = impl.getDeclaredConstructor().newInstance();

        configurators.forEach(x -> {
            try {
                x.configure(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return t;
    }
}
