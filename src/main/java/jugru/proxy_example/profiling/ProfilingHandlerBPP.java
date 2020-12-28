package jugru.proxy_example.profiling;

import jugru.proxy_example.jmx_console.ProfilingController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingHandlerBPP implements BeanPostProcessor {

    // карта для сохранения бинов аннотированных @Profile
    private Map<String, Class> map = new HashMap<>();

    // класс MBean для отображенгия булеановского сеттера в jvisualvm
    private ProfilingController profilingController = new ProfilingController();

    // регистрируем MBean
    public ProfilingHandlerBPP() {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            platformMBeanServer.registerMBean(profilingController, new ObjectName("profiling", "name", "controller"));
        } catch (InstanceAlreadyExistsException | MalformedObjectNameException | NotCompliantMBeanException | MBeanRegistrationException e) {
            e.printStackTrace();
        }
    }

    // сохраняем бин аннотированный @Profile в карту
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    // создаем прокси-объекты с доп логикой для классов аннотированных @Profile
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class beanClass = map.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(
                    beanClass.getClassLoader(),
                    beanClass.getInterfaces(),
                    (o, method, objects) -> {
                        if (profilingController.isEnable()) {
                            System.out.println("Profiling");
                            long before = System.nanoTime();
                            Object invoke = method.invoke(bean, objects);
                            long after = System.nanoTime();
                            System.out.println("End : " + (after - before));
                            return invoke;
                        } else {
                            return method.invoke(bean, objects);
                        }
                    }
            );
        }

        return bean;
    }
}
