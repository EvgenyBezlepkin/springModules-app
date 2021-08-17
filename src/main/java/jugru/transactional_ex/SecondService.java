package jugru.transactional_ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SecondService {

    @Autowired
    private FirstService firstService;
    @Autowired
    private FirstRepo firstRepo;

    public void invokeInsertTrWithEx() {
        firstService.insertTrWithEx();
    }

    public void invokeInsertTr() {
        firstService.insertTr();
    }

    @Transactional
    public void invokeInsertWithRequiresNew() {
        firstRepo.save(new Data("outerMethod"));
        try {
            firstService.insertTrRequiresNew();
        } catch (RuntimeException e) {

        }
    }

    @Transactional
    public void invokeInsertWithRequired() {
        firstRepo.save(new Data("outerMethod"));
        try {
            firstService.insertTrRequires();
        } catch (RuntimeException e) {

        }
    }

}
