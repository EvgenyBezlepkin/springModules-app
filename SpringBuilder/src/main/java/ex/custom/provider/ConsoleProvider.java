package ex.custom.provider;

public class ConsoleProvider implements DataProvider{
    @Override
    public void getMessage() {
        System.out.println("Hello world");
    }
}
