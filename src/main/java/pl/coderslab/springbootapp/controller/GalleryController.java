package pl.coderslab.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springbootapp.entity.Exhibit;
import pl.coderslab.springbootapp.entity.Exhibition;
import pl.coderslab.springbootapp.entity.Notification;
import pl.coderslab.springbootapp.repository.ExhibitRepository;
import pl.coderslab.springbootapp.repository.ExhibitionRepository;
import pl.coderslab.springbootapp.repository.NotificationRepository;
import pl.coderslab.springbootapp.service.ExhibitService;
import pl.coderslab.springbootapp.service.ExhibitionService;
import pl.coderslab.springbootapp.service.NotificationService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    private ExhibitionService exhibitionService;
    @Autowired
    private ExhibitService exhibitService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping(path = "/exhibitions", produces = "text/plain; charset=UTF-8")
    public String viewExhibitionsAnimator(){
        return "exhibitions/list";
    }

    @GetMapping(path = "/exhibits", produces = "text/plain; charset = UTF-8")
    public String viewExhibitionsExhibitsAnimator(Model model, @RequestParam("exhibitionName") String exhibitionName){
        Exhibition exhibition = exhibitionService.findByName(exhibitionName);
        List<Exhibit> exhibits = exhibitService.findAllByExhibitionName(exhibitionName);
        model.addAttribute("exhibition", exhibition);
        model.addAttribute("exhibitsOfExhibition", exhibits);
        return "exhibits/list";
    }

    @GetMapping(path = "/notification", produces = "text/html; charset=UTF-8")
    String notificationForm(Model model, @RequestParam("exhibitName") String exhibitName,
                            @RequestParam("exhibitionName") String exhibitionName){
        Exhibit exhibit = exhibitService.findByName(exhibitName);
        List<Notification> notificationsHistory = notificationService.findAllByExhibit(exhibitName);
        Notification notification = new Notification();
        notification.setExhibit(exhibit);
        model.addAttribute("notificationHistory", notificationsHistory);
        model.addAttribute("exhibitionName", exhibitionName);
        model.addAttribute("exhibit", exhibit);
        model.addAttribute("notification", notification);
        return "/notification/add";
    }

    @PostMapping(path = "/notification", produces = "text/plain; charset=UTF-8")
    String createNotification(@Valid Notification notification, BindingResult br, Model model){
        if(br.hasErrors()){
            return "/notification/add";
        }else {
            Exhibition exhibition = notification.getExhibit().getExhibition();
            List<Exhibit> exhibits = exhibitService.findAllByExhibitionName(exhibition.getName());
            notificationService.save(notification);
            model.addAttribute("exhibition", exhibition);
            model.addAttribute("exhibitsOfExhibition", exhibits);
        }
            return "exhibits/list";
    }

    @ModelAttribute("exhibitions")
    public List<Exhibition> exhibitions(){
        return exhibitionService.findAll();
    }

    @ModelAttribute("departments")
    public List<String> departments(){
        return Arrays.asList("workshop", "it");
    }

    @ModelAttribute("notificationTypes")
    public List<String> notificationTypes(){
        return Arrays.asList("Ekran nie reaguje na dotyk", "Black screen", "Blue screen", "Wada konstrukcyjna", "Brak zasilania", "Uszkodzony eksponat", "Brak materiałów", "Inne");
    }
}
