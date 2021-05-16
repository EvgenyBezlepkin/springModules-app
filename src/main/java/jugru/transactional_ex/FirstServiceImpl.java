package jugru.transactional_ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class FirstServiceImpl implements FirstService{

    @Autowired
    private FirstRepo firstRepo;

    public void insert() {
        firstRepo.save(new First("a"));
    }
}
