package com.example.luv2code.terminator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingHandlerPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<>();

    private ProfilingController profilingController = new ProfilingController();

    public ProfilingHandlerPostProcessor() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(profilingController, new ObjectName("profiling" , "name", "controller1"));

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Transactional.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {

                if (profilingController.isEnabled()) {
                    System.out.println("start profiling");
                    long before = System.nanoTime();
                    Object obj = method.invoke(bean, args);
                    long after = System.nanoTime();
                    System.out.println(after - before);

                    return null;
                } else {
                    return method.invoke(bean, args);
                }
            });
        }
        return bean;
    }
}
