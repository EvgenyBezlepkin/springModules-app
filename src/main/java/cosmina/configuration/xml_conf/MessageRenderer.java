package cosmina.configuration.xml_conf;

public interface MessageRenderer {

    void render();
    void setMessageProvider(MessageProvider mp);
    MessageProvider getMessageProvider();

}
