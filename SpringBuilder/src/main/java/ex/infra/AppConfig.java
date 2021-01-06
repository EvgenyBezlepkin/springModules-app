package ex.infra;

public interface AppConfig {

    <T> Class <? extends T> getImplClass(Class<T> type);
}
