package ex.infra;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppContext {

    private ObjectFactory factory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();

    public <T> T getObject(Class<T> type) {
        return (T) new Object();
    }

}
