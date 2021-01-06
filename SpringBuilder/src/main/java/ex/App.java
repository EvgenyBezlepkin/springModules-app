package ex;

import ex.custom.MessageRenderer;
import ex.infra.ObjectFactory;


public class App {

    public static void main(String[] args) {

        MessageRenderer object = ObjectFactory.getInstance().createObject(MessageRenderer.class);
        object.render();

    }

}
