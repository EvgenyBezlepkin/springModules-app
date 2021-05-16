package configuration.xml_conf;

public class StandardOutMessageRenderer implements MessageRenderer{

    private MessageProvider mp;

    @Override
    public void render() {
        if (mp == null) {
            throw new RuntimeException("Message provider is disable");
        }
        System.out.println(mp.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider mp) {
        this.mp = mp;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return mp;
    }
}
