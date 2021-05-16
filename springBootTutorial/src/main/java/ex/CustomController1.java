package ex;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile(ProfilesConst.FIRST)
@RestController
public class CustomController1 implements MyController{

    @GetMapping("/")
    public String method() {
        return "CustomController1";
    }
}
