package ex.infra.configurator;

import ex.infra.AppContext;

public interface ProxyConfigurator {

    Object replaceProxy(Object o, Class impl) throws Exception;
}
