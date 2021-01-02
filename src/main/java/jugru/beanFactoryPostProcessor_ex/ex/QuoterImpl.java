package jugru.beanFactoryPostProcessor_ex.ex;

import jugru.beanFactoryPostProcessor_ex.annotation.DeprecatedClass;
import jugru.custom_annotation.RundomInt;


@DeprecatedClass(newImpl = NewQuoterImpl.class)
public class QuoterImpl implements Quoter {

    @RundomInt(min = 2, max = 7)
    private int i;
    private String message;


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
