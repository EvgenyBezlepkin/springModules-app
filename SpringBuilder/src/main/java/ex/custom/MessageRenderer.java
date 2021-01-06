package ex.custom;

import ex.infra.ObjectFactory;
import ex.custom.provider.DataProvider;

public class MessageRenderer {

    private final DataProvider provider = ObjectFactory.getInstance().createObject(DataProvider.class);

    public void render() {
        provider.getMessage();
    }
}
