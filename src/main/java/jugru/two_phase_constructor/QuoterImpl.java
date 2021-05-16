package jugru.two_phase_constructor;

import jugru.custom_annotation.RundomInt;

import javax.annotation.PostConstruct;

public class QuoterImpl implements Quoter {

    @RundomInt(min = 2, max = 7)
    private int i;
    private String message;

    // проставит дефолтные значения
    public QuoterImpl() {
        System.out.println("Phase 1");
        System.out.println("i : " + i);
    }

    // проставит значения и зависимости из общих аннотаций
    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
        System.out.println("i : " + i);
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


    @Override
    public void sayQuoter() {
        System.out.println("Message : " + message + " : " + i);
    }
}
