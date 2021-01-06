package ex.infra;


import de.codecentric.boot.admin.server.web.PathUtils;
import ex.custom.provider.Console2Provider;
import ex.custom.provider.DataProvider;
import ex.infra.annotations.InjectProperty;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ObjectFactory {

    private JavaConfig config;
    private static final ObjectFactory instance = new ObjectFactory();
    private final Map<Class, Class> map;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    {
        map = new HashMap<Class, Class>();
        map.put(DataProvider.class, Console2Provider.class);
    }

    @SneakyThrows
    private ObjectFactory() {
        config = new JavaConfig("ex", map);
        Iterator<Class<? extends ObjectConfigurator>> iterator = config.getScanner().getSubTypesOf(ObjectConfigurator.class).iterator();
        if (iterator.hasNext()) {
            configurators.add(iterator.next().getDeclaredConstructor().newInstance());
        }
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

        configurators.iterator().next().configure(t);

        return t;
    }
}
