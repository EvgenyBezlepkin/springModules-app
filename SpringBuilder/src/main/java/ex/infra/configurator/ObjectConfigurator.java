package ex.infra.configurator;

import ex.infra.AppContext;

public interface ObjectConfigurator {
    void configure(Object o, AppContext context) throws Exception;
}
