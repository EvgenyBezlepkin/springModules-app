package ex.infra;

import org.reflections.Reflections;

public interface AppConfig {

    <T> Class <? extends T> getImplClass(Class<T> type);

    Reflections getScanner();
}
