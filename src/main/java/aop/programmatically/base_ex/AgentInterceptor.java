package aop.programmatically.base_ex;

import aop.auxillary.AopExample;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

// предшествующий совет
// окружающий совет
public class AgentInterceptor implements MethodBeforeAdvice, MethodInterceptor {

    // MethodInterceptor - Окружающий
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (mi.getMethod().isAnnotationPresent(AopExample.class)) {
            // перехватывает аргумент метода и меняет его на полученное из аннотации значение
            String s = mi.getMethod().getAnnotation(AopExample.class).s();
            System.out.println("argument is intercepted : " + mi.getArguments()[0] + " ");
            return mi.getMethod().invoke(mi.getThis(), s);
        }
        return null;
    }

    // MethodBeforeAdvice - Предшествующий
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        

    }
}
