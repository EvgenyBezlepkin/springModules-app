package aop.programmatically.pointcut_ex;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class Main_AspectJExpressionPointcut {

    public static void main(String[] args) {

        // 1 Пример pointcut через AspectJ
        Agent a = new FirstAgent();
        Agent b = new SecondAgent();

        // 2 определяем pointcut и advice (здесь - MethodInterceptor в классе SimpleAdvice)
        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution( * speak* (..))");

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
