package aop.programmatically.pointcut_ex;

public class SecondAgent implements Agent{

    public void speak(String s) {
        System.out.println("from SecondAgent it speak : " + s);
    }

    public void speak() {
        System.out.println("method speak without args from SecondAgent");
    }

}
