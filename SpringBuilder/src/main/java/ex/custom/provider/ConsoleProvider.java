package ex.custom.provider;

import ex.infra.annotation.PostConstruct;

public class ConsoleProvider implements DataProvider{
    @Override
    public void getMessage() {
        System.out.println("Hello world");
    }

    @PostConstruct
    public void init() {
        System.out.println("init-method");
    }
}
