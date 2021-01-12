package ex.infra.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * классы с этой аннотацией по умолчанию кешируются во время настройки и при повторном вызове отдается объект из кеша
 * Аннотация создает не ленивый Singleton
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Singleton {
}
