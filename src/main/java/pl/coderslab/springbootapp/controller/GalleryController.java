package pl.coderslab.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springbootapp.entity.Exhibit;
import pl.coderslab.springbootapp.entity.Exhibition;
import pl.coderslab.springbootapp.entity.Notification;
import pl.coderslab.springbootapp.repository.ExhibitRepository;
import pl.coderslab.springbootapp.repository.ExhibitionRepository;
import pl.coderslab.springbootapp.repository.NotificationRepository;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    private ExhibitionRepository exhibitionRepository;
    @Autowired
    private ExhibitRepository exhibitRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping(path = "/exhibitions", produces = "text/plain; charset=UTF-8")
    public String viewExhibitionsAnimator(){
        return "exhibitions/list";
    }

    @GetMapping(path = "/exhibits", produces = "text/plain; charset = UTF-8")
    public String viewExhibitionsExhibitsAnimator(Model model, @RequestParam("exhibitionName") String exhibitionName){
        Exhibition exhibition = exhibitionRepository.findByName(exhibitionName);
        List<Exhibit> exhibits = exhibitRepository.findAllByExhibitionName(exhibitionName);
        model.addAttribute("exhibition", exhibition);
        model.addAttribute("exhibitsOfExhibition", exhibits);
        return "exhibits/list";
    }

    @GetMapping(path = "/notification", produces = "text/html; charset=UTF-8")
    String notificationForm(Model model, @RequestParam("exhibitName") String exhibitName,
                            @RequestParam("exhibitionName") String exhibitionName){
        Exhibit exhibit = exhibitRepository.findByName(exhibitName);
        List<Notification> notificationsHistory = notificationRepository.findAllByExhibit(exhibitName);
        Notification notification = new Notification();
        notification.setExhibit(exhibit);
        model.addAttribute("notificationHistory", notificationsHistory);
        model.addAttribute("exhibitionName", exhibitionName);
        model.addAttribute("exhibit", exhibit);
        model.addAttribute("notification", notification);
        return "/notification/add";
    }

    @PostMapping(path = "/notification", produces = "text/plain; charset=UTF-8")
    String createNotification(Notification notification, Model model){
        Exhibition exhibition = notification.getExhibit().getExhibition();
        List<Exhibit> exhibits = exhibitRepository.findAllByExhibitionName(exhibition.getName());
        notificationRepository.save(notification);
        model.addAttribute("exhibition", exhibition);
        model.addAttribute("exhibitsOfExhibition", exhibits);
        return "exhibits/list";
    }

    @ModelAttribute("exhibitions")
    public List<Exhibition> exhibitions(){
        return exhibitionRepository.findAll();
    }

    @ModelAttribute("departments")
    public List<String> departments(){
        return Arrays.asList("workshop", "it");
    }
}
