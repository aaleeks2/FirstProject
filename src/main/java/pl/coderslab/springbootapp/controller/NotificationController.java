package pl.coderslab.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.springbootapp.entity.Notification;
import pl.coderslab.springbootapp.repository.NotificationRepository;

import java.util.List;

@Controller
@RequestMapping(path = "/notification")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

//    TODO - granting access for workshop emplyees only
    @GetMapping(path = "/list/it", produces = "test/plain; charset=UTF-8")
    String notificationsListIT(Model model){
        String department = "IT";
        List<Notification> notificationsIT = notificationRepository.findAllByDepartment(department);
        model.addAttribute("notificationsIT", notificationsIT);
        return "notification/listIT";
    }

    // TODO - granting access for IT employees only
    @GetMapping(path = "/list/workshop", produces = "text/plain; charset=utf-8")
    String notificationListWorkshop(Model model){
        String department = "workshop";
        List<Notification> notificationsWorkshop = notificationRepository.findAllByDepartment(department);
        model.addAttribute("notificationsWorkshop", notificationsWorkshop);
        return "notification/listWorkshop";
    }

    //TODO - create function on btn click event - information about the notification if its taken
    @GetMapping(path = "/details", produces = "text/plain; charset=UTF-8")
    String notificationDetails(@RequestParam("notificationId") long id,
                               Model model){
        Notification notification = notificationRepository.findById(id).get();
        model.addAttribute("notification", notification);
        return "notification/details";
    }

}
