package ex.custom.lang;

import ex.infra.annotation.Deprecation;
import ex.infra.annotation.InjectProperty;
import ex.infra.annotation.Singleton;


@Singleton
@Deprecation
public class RusLanguage implements Language{

    // инжекция свойства по совпадающему значению application.property
    // если имя свойства не задано в аннотации ищем значение по имени поля
    @InjectProperty()
    private String langMes;

    @Override
    public void getLang() {
        System.out.println("Inject message = " + langMes);
    }
}
