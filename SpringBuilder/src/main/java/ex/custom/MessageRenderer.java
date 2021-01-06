package ex.custom;

import ex.custom.lang.Language;
import ex.custom.lang.RusLanguage;
import ex.infra.ObjectFactory;
import ex.custom.provider.DataProvider;

public class MessageRenderer {

    private final Language lang = ObjectFactory.getInstance().createObject(RusLanguage.class);
    private final DataProvider provider = ObjectFactory.getInstance().createObject(DataProvider.class);

    public void render() {
        lang.getLang();
        provider.getMessage();
    }
}
