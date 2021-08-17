package jugru.transactional_ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ThirdService {

    @Autowired
    private FirstRepo firstRepo;

    public void insert() {
        firstRepo.save(new Data("a"));
    }

}
