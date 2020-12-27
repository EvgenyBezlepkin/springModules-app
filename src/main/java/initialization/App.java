package initialization;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class App implements InitializingBean, DisposableBean , BeanNameAware, ApplicationContextAware, BeanClassLoaderAware {

    private String s;
    private int i;
    private String name;


    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }


    @PostConstruct
    public void initialize() {
        System.out.print("PostConstruct : ");
        if (s == null) {
            System.out.println("value doesn't set");
        }
    }

    @Override   // InitializingBean
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet from InitializingBean");
    }

    // init method calling in xml
    public void init() {
        System.out.println("init method");
        s = "second";
    }

    @PreDestroy
    public void dest() {
        System.out.println("PreDestyroy");
    }

    @Override   // DisposableBean
    public void destroy() throws Exception {
        System.out.println("destroy from DisposableBean");
    }

    // destroy method calling in xml
    public void destroyXml() {
        System.out.println("destroy");
    }

    @Override   // BeanNameAware
    public void setBeanName(String s) {
        name = s;
        System.out.println("bean name : " + s);
    }

    @Override   // BeanClassLoaderAware
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    @Override   // ApplicationContextAware
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public String toString() {
        return "App{" +
                "s='" + s + '\'' +
                ", i=" + i +
                '}';
    }

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("applicationContext_3.xml");
        ctx.refresh();
        App app = ctx.getBean("app", App.class);
        System.out.println(app);

        ctx.close();
    }



}
