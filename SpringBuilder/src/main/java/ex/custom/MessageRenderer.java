package ex.custom;


import ex.custom.lang.Language;
import ex.custom.lang.RusLanguage;
import ex.infra.ObjectFactory;
import ex.custom.provider.DataProvider;
import ex.infra.annotation.Deprecation;
import ex.infra.annotation.InjectByType;


// основной класс пользовательского приложения
// инжекция имплементации Language (в этом классе происходит инжекция примитива по аннотации
// инжекция имплементации DataProvider
//@Deprecation
public class MessageRenderer {

    @InjectByType
    private Language lang;
    @InjectByType
    private DataProvider provider;

    public void render() {
        provider.getMessage();
        lang.getLang();

    }
}
