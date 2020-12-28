package jugru.proxy_example.base;

import jugru.custom_annotation.RundomInt;
import jugru.proxy_example.profiling.Profiling;

@Profiling
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

    @Profiling
    @Override
    public void sayQuoter() {
        System.out.println("Message : " + message + " : " + i);
    }
}
