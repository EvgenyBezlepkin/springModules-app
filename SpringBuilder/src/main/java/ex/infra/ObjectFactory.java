package ex.infra;


import ex.custom.provider.Console2Provider;
import ex.custom.provider.DataProvider;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {

    private final JavaConfig config;
    private static final ObjectFactory instance = new ObjectFactory();
    private final Map<Class, Class> map;

    {
        map = new HashMap<Class, Class>();
        map.put(DataProvider.class, Console2Provider.class);
    }

    private ObjectFactory() {
        config = new JavaConfig("ex", map);
    }

    public static ObjectFactory getInstance() {
        return instance;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> impl = type;
        if (type.isInterface()) {
            impl = config.getImplClass(type);
        }
        T t = impl.getDeclaredConstructor().newInstance();
        //
        return t;
    }
}
