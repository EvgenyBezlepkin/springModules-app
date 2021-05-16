package ex.infra.configurator;

import ex.infra.annotation.Deprecation;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecationHandlerProxyConfigurator implements ProxyConfigurator{
    @Override
    public Object replaceProxy(Object t, Class impl) throws Exception {
        if (impl.isAnnotationPresent(Deprecation.class)) {

            if (impl.getInterfaces().length == 0) {
                return Enhancer.create(impl, (InvocationHandler) (o, method, objects) -> {
                    System.out.println("we use proxy class");
                    return method.invoke(t);
                });
            }


            return Proxy.newProxyInstance(impl.getClassLoader(), impl.getInterfaces(),
                    (o, method, objects) -> {
                        System.out.println("we use proxy class");
                        return method.invoke(t);
                    });
        }
        return t;
    }



}
