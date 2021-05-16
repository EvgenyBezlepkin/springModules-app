package aop.programmatically.advice_ex;

import org.springframework.aop.framework.ProxyFactory;

public class Main {

    public static void main(String[] args) {

        // 1 Создаем экземпляр целевого класса (target)
        Agent target = new Agent();

        // 2 Класс ProxyFactory принимает цель, совет, советников и тд. для создания аспекта
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentInterceptor());
        pf.setTarget(target);

        // 3 создаем прокси
        Agent proxy = (Agent) pf.getProxy();

        // вызов целевого класса
        target.speak("target");
        // вызов прокси
        proxy.speak("proxy");

    }
}
