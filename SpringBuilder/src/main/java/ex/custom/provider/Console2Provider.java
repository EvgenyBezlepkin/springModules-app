package ex.custom.provider;

public class Console2Provider implements DataProvider{
    @Override
    public void getMessage() {
        System.out.println("Hello world, from Console2Provider");
    }
}
