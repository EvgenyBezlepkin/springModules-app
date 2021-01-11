package ex.infra;

import ex.infra.annotation.Singleton;
import ex.infra.config.AppConfig;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppContext {

    private ObjectFactory factory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();
    private AppConfig config;


    AppConfig getConfig() {
        return config;
    }

    void setFactory(ObjectFactory factory) {
        this.factory = factory;
    }

    public AppContext(AppConfig config) {
        this.config = config;
    }


    public <T> T getObject(Class<T> type) throws Exception {
        Class<? extends T> impl = type;

        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }
        if (type.isInterface()) {
            impl = config.getImplClass(type);
        }
        T object = factory.createObject(impl);

        if (impl.isAnnotationPresent(Singleton.class)) {
            cache.put(type, object);
        }
        return object;
    }

}
