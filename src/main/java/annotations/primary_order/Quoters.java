package annotations.primary_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Quoters {

    @Autowired
    private List<Quoter> quoterList;


    public void say() {
        quoterList.get(0).sayQuoter();
        quoterList.get(1).sayQuoter();
    }
}
