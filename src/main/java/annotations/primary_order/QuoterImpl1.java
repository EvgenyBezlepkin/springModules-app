package annotations.primary_order;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


// @Primary может быть указана рядом с аннотациями @Bean или @Component
//@Component
//@Primary
public class QuoterImpl1 implements Quoter, ApplicationContextAware{

    private int i = 1;
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext.getId());
        System.out.println(applicationContext.getDisplayName());
    }
}
