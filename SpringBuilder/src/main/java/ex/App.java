package ex;

import ex.custom.MessageRenderer;
import ex.infra.AppContext;
import ex.infra.Application;
import ex.infra.ObjectFactory;

import java.util.HashMap;
import java.util.Map;


public class App {

    public static void main(String[] args) throws Exception {

        AppContext ctx = Application.run("ex", new HashMap<>());
        ctx.getObject(MessageRenderer.class).render();

    }

}
