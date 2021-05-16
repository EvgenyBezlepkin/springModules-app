package aop.programmatically.pointcut_ex;

import aop.auxillary.AopExample;
import aop.auxillary.ForPointCut;

public class FirstAgent implements Agent{

    public void speak(String s) {
        System.out.println("from FirstAgent it speak : " + s);
    }

    @ForPointCut
    public void speak() {
        System.out.println("method speak without args from FirstAgent");
    }

}
