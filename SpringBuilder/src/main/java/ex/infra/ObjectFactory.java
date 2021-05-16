package ex.infra;


import ex.infra.annotation.Deprecation;
import ex.infra.annotation.PostConstruct;
import ex.infra.config.AppConfig;
import ex.infra.configurator.ObjectConfigurator;
import ex.infra.configurator.ProxyConfigurator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;


public class ObjectFactory {


    private final AppContext context;
    private final List<ObjectConfigurator> configurators = new ArrayList<>();
    private final List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();

    public ObjectFactory(AppContext context) {
        this.context = context;
        AppConfig config = context.getConfig();
        for (Class<? extends ObjectConfigurator> c : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            try {
                configurators.add(c.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Class<? extends ProxyConfigurator> c : config.getScanner().getSubTypesOf(ProxyConfigurator.class)) {
            try {
                proxyConfigurators.add(c.getDeclaredConstructor().newInstance());
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

        for (Method method : impl.getMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }

        for (ProxyConfigurator x : proxyConfigurators) {
            try {
                return (T) x.replaceProxy(t, impl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return t;
    }
}
