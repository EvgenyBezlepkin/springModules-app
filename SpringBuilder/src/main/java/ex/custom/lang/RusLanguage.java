package ex.custom.lang;

import ex.infra.annotations.InjectProperty;

public class RusLanguage implements Language{

    // если имя свойства не задано в аннотации ищем значение по имени поля в файле application.property
    @InjectProperty()
    private String langMes;

    @Override
    public void getLang() {
        System.out.println("Inject message = " + langMes);
    }
}
