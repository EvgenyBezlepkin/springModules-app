package cosmina.configuration.xml_conf;

public class HelloWorldMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello World";
    }
}
