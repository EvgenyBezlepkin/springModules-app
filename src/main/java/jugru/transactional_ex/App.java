package jugru.transactional_ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;


@SpringBootApplication
public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext cac = SpringApplication.run(App.class, args)) {

            System.out.println(Arrays.toString(cac.getBeanDefinitionNames()));

            //invokeTransactionalMethod(cac);
            //invokeTransactionalMethodWithException(cac);
            //invokeNonTransactionalMethodWithException(cac);

            // если не транзакционные методы вызывают транзакционные то транзакция отрабатывает
            //Spring создает proxy для классов, где есть аннотациея @Transactional.

            //serviceNonTrInvokeServiceTr(cac);
            //serviceNonTrInvokeServiceTrWithEx(cac);

            //invokeMethodInClassTr(cac);

            //invokeTrMethodWhichInvokeTrRequiresNewMethod(cac);

            //invokeTrMethodWhichInvokeTrRequiredMethod(cac);

            // NB!
            //inOneClassFromNonTrMethodInvokesTrMethod(cac);
        }

    }

    public static void invokeTransactionalMethod(ConfigurableApplicationContext cac) {
        FirstService firstService = cac.getBean("firstService", FirstService.class);
        firstService.insertTr();
    }

    public static void invokeTransactionalMethodWithException(ConfigurableApplicationContext cac) {
        FirstService firstService = cac.getBean("firstService", FirstService.class);
        firstService.insertTrWithEx();
    }

    public static void invokeNonTransactionalMethodWithException(ConfigurableApplicationContext cac) {
        FirstService firstService = cac.getBean("firstService", FirstService.class);
        firstService.insertNonTrWithEx();
    }

    public static void serviceNonTrInvokeServiceTr(ConfigurableApplicationContext cac) {
        cac.getBean("secondService", SecondService.class).invokeInsertTr();
    }

    public static void serviceNonTrInvokeServiceTrWithEx(ConfigurableApplicationContext cac) {
        cac.getBean("secondService", SecondService.class).invokeInsertTrWithEx();
    }

    public static void invokeMethodInClassTr(ConfigurableApplicationContext cac) {
        cac.getBean("thirdService", ThirdService.class).insert();
    }

    public static void invokeTrMethodWhichInvokeTrRequiresNewMethod(ConfigurableApplicationContext cac) {
        cac.getBean("secondService", SecondService.class).invokeInsertWithRequiresNew();
    }

    public static void invokeTrMethodWhichInvokeTrRequiredMethod(ConfigurableApplicationContext cac) {
        cac.getBean("secondService", SecondService.class).invokeInsertWithRequired();
    }

    public static void inOneClassFromNonTrMethodInvokesTrMethod(ConfigurableApplicationContext cac) {
        FirstService firstService = cac.getBean("firstService", FirstService.class);
        firstService.inOneClassFromNonTrMethodInvokesTrMethod();
    }

}
