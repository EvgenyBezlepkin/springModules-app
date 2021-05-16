package jugru.application_listener_ex;

import jugru.custom_annotation.RundomInt;
import jugru.proxy_example.profiling.Profiling;
import javax.annotation.PostConstruct;


@Profiling
public class QuoterImpl implements Quoter {

    @RundomInt(min = 2, max = 7)
    private int i;
    private String message;

    // конструктор - первая фаза инициализации бина
    public QuoterImpl() {
        System.out.println("Phase 1");
    }

    // инит-метод - вторая фаза инициализации бина
    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
    }

    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    // листенер - третья фаза инициализации бина
    @PostRefresh
    @Override
    public void sayQuoter() {
        System.out.println("Message : " + message + " : " + i);
    }
}
