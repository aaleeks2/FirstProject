package pl.coderslab.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.springbootapp.entity.User;
import pl.coderslab.springbootapp.repository.UserRepository;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

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
        List<User> nonUserUsers = userRepository.findAllItAndWorkshopEmployees();
        model.addAttribute("employees", nonUserUsers);
        return "common/contact";
    }

    String JSLINK = "src=\"${pageContext.request.contextPath}/js/buttonScript.js\"";

    String oldCap = "<sec:authorize access=\"isAuthenticated()\">\n" +
            "    Użytkownik: <h3><sec:authentication property=\"principal.username\"/></h3>\n" +
            "<%--    Masz rolę: <sec:authentication property=\"principal.authorities\"/>--%>\n" +
            "    <form id=\"logoutForm\" action=\"/logout\" method=\"post\">\n" +
            "        <input class=\"fa fa-id-badge\" type=\"submit\" value=\"Wyloguj\">\n" +
            "        <input type=\"hidden\" name=\"${_csrf.parameterName}\" value=\"${_csrf.token}\"/>\n" +
            "    </form>\n" +
            "    <a href=\"/contact\">Kontakt do pracowników</a>\n" +
            "</sec:authorize>";
}
