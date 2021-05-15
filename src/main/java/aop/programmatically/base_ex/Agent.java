package aop.programmatically.base_ex;

import aop.auxillary.AopExample;

public class Agent {

    @AopExample(s = "new proxy")
    public void speak(String s) {
        System.out.println("it speak : " + s);
    }
}
