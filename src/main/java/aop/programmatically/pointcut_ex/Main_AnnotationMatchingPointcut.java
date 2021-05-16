package aop.programmatically.pointcut_ex;

import aop.auxillary.ForPointCut;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class Main_AnnotationMatchingPointcut {

    public static void main(String[] args) {

        // 1 Пример pointcut по аннотации
        Agent a = new FirstAgent();
        Agent b = new SecondAgent();

        // 2 определяем какую аннотацию искать
        AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forMethodAnnotation(ForPointCut.class);

        // 3 определяем aspect (здесь - Advisor), который принимает pointcut и advice
        // определяем pointcut и advice (здесь - MethodInterceptor в классе SimpleAdvice)
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

        // 4 создаем фабрику прокси и устанавлием цель и advisor
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(a);
        pf.addAdvisor(advisor);
        FirstAgent proxy = (FirstAgent)pf.getProxy();

        proxy.speak();
        proxy.speak("hello");

    }
}
