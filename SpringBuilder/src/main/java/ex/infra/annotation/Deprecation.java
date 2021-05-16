package ex.infra.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Класс с этой аннотацией будет обернут в прокси на последнем этапе конфигурирования объекта
 * Логика работы в классе DeprecationHandlerProxyConfigurator
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Deprecation {
}
