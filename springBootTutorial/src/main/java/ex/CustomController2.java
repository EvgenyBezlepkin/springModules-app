package ex;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile(ProfilesConst.SECOND)
@RestController
public class CustomController2 implements MyController{

    @GetMapping("/")
    @Override
    public String method() {
        return "CustomController2";
    }
}
