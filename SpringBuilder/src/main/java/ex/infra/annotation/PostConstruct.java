package ex.infra.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * двухфазный конструктор
 * настраивает объект после ObjectConfigurator и до ProxyConfigurator
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PostConstruct {
}
