package aop.programmatically.pointcut_ex;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class Main_JdkRegexpMethodPointcut {

    public static void main(String[] args) {

        // 1 Пример pointcut по регулярному выражению
        Agent a = new FirstAgent();
        Agent b = new SecondAgent();

        // 2 определяем pointcut и advice (здесь - MethodInterceptor в классе SimpleAdvice)
        JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();
        pc.setPattern(".*speak.*");

        // 3 определяем aspect (здесь - Advisor), который принимает pointcut и advice
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

        // 4 создаем фабрику прокси и устанавлием цель и advisor
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(b);
        pf.addAdvisor(advisor);
        SecondAgent proxy = (SecondAgent)pf.getProxy();

        proxy.speak();
        proxy.speak("hello");

    }
}
