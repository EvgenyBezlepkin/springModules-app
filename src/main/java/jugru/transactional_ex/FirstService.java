package jugru.transactional_ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FirstService {

    @Autowired
    private FirstRepo firstRepo;

    @Transactional
    public void insertTr() {
        firstRepo.save(new Data("a"));
    }

    @Transactional
    public void insertTrWithEx() {
        firstRepo.save(new Data("a"));
        throw new RuntimeException("break");
    }

    public void insertNonTrWithEx() {
        firstRepo.save(new Data("a"));
        throw new RuntimeException("break");
    }

    // внешний транзакционный метод вызывает внутренний транзакционный метод с REQUIRES_NEW
    // это значит что при вызове внутреннего метода открывается новая транзакция
    // если падает внутренний метод но внешний завершается нормально
    // то пройдет транзакция внешнего метода
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertTrRequiresNew() {
        firstRepo.save(new Data("innerMethod"));
        throw new RuntimeException("break with requires new");
    }

    // внешний транзакционный метод вызывает внутренний транзакционный метод с REQUIRED
    // это значит что при вызове внутреннего метода продолжится существующая транзакция
    // если падает внутренний метод но внешний завершается нормально
    // то не пройдет вся транзакция
    // Transaction silently rolled back because it has been marked as rollback-only
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertTrRequires() {
        firstRepo.save(new Data("innerMethod"));
        throw new RuntimeException("break with requires new");
    }
}
