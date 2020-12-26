package cosmina.configuration.boot_conf;

public interface MessageRenderer {

    void render();
    void setMessageProvider(MessageProvider mp);
    MessageProvider getMessageProvider();

}
