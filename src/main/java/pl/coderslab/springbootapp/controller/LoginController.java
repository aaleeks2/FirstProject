package pl.coderslab.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

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

    String JSLINK = "src=\"${pageContext.request.contextPath}/js/buttonScript.js\"";
}
