package cosmina.configuration.java_conf;

public interface MessageRenderer {

    void render();
    void setMessageProvider(MessageProvider mp);
    MessageProvider getMessageProvider();

}
