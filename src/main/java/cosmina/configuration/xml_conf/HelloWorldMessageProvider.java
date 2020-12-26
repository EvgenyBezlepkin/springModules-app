package cosmina.configuration.xml_conf;

public class HelloWorldMessageProvider implements MessageProvider{

    private String message;

    public HelloWorldMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
