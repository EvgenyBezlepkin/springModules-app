package starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


// пользовательская аннотация дожна ссылаться на класс который наследует от Condition
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnStarterConditional.class)
public @interface ConditionalOnStarter {
}
