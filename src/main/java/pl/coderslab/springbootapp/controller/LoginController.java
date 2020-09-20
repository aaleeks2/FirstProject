package pl.coderslab.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.springbootapp.entity.User;
import pl.coderslab.springbootapp.service.UserService;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/")
    String startingPage(){
        return "common/start";
    }

    @GetMapping("/login")
    String showLoginForm(){
        return "common/login";
    }

    @GetMapping("/403")
    String accessDeniedPage(){
        return "common/403";
    }

    @GetMapping("/homePage")
    String homePage(){
        return "common/index";
    }

    @GetMapping("/contact")
    String contact(Model model){
        List<User> nonUserUsers = userService.findAllItAndWorkshopEmployees();
        model.addAttribute("employees", nonUserUsers);
        return "common/contact";
    }
}
