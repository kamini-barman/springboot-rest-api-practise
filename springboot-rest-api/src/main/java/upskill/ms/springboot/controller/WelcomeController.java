package upskill.ms.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    // HTTP GET REQUEST
    //http://localhost:8080/welcome
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome !!";
    }
}
