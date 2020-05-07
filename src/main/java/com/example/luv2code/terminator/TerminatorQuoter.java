package com.example.luv2code.terminator;

import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

@Transactional
@Profiling
public class TerminatorQuoter implements Quoter {

    @InjectRundomInt(min=4, max=7)
    private int repeat;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @PostConstruct
    public void init(){
        System.out.println("phase 2");
    }

    // 3ья фаза изготовления объекта
    @Override
    //@PostProxy
    public void sayQuote() {
        System.out.println("phase 1");
        for (int i = 0; i < repeat; i++) {
            System.out.println("Message = " + message);
        }

    }

}
