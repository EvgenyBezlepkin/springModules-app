package cosmina.configuration.annotation_conf;

public interface MessageRenderer {

    void render();
    void setMessageProvider(MessageProvider mp);
    MessageProvider getMessageProvider();

}
