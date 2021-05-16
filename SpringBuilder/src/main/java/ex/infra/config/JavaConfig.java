package ex.infra.config;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements AppConfig{


    private final Reflections scanner;
    private final Map<Class, Class> ifc2impl;

    public JavaConfig(String packageScan, Map<Class, Class> map) {
        scanner = new Reflections(packageScan);
        ifc2impl = map;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> type) {
        return ifc2impl.computeIfAbsent(type, x -> {
            Set<Class<? extends T>> subTypesOf = scanner.getSubTypesOf(type);
            if (subTypesOf.size() != 1) {
                throw new RuntimeException("Exists zero or more than one impl");
            }
            return subTypesOf.iterator().next();
        });
    }

    @Override
    public Reflections getScanner() {
        return scanner;
    }
}
