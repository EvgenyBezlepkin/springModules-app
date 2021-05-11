package aop.programmatically.base_ex;

import org.springframework.aop.framework.ProxyFactory;

public class Main {

    public static void main(String[] args) {

        // 1 Создаем экземпляр целевого класса (target)
        Agent target = new Agent();

        // 2 Factory for AOP proxies for programmatic use, rather than via a bean factory.
        // This class provides a simple way of obtaining and configuring AOP proxies in code.
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentInterceptor());
        pf.setTarget(target);

        Agent proxy = (Agent) pf.getProxy();

        target.speak();
        proxy.speak();

    }
}
