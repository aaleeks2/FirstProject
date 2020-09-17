package pl.coderslab.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.springbootapp.entity.Notification;
import pl.coderslab.springbootapp.repository.NotificationRepository;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path = "/notification")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping(path = "/it/list", produces = "test/plain; charset=UTF-8")
    String notificationsListIT(Model model){
        String department = "it";
        List<Notification> notificationsIT = notificationRepository.findAllByDepartmentNotClosed(department);
        model.addAttribute("notificationsIT", notificationsIT);
        return "notification/listIT";
    }

    @GetMapping(path = "/workshop/list", produces = "text/plain; charset=utf-8")
    String notificationListWorkshop(Model model){
        String department = "workshop";
        List<Notification> notificationsWorkshop = notificationRepository.findAllByDepartmentNotClosed(department);
        model.addAttribute("notificationsWorkshop", notificationsWorkshop);
        return "notification/listWorkshop";
    }

    @GetMapping(path="/history")
    String viewHistoryByCreated(Model model){
        List<Notification> historyOfNotifications = notificationRepository.findAllByCreated();
        model.addAttribute("historyOfNotifications", historyOfNotifications);
        return "notification/history";
    }

    @GetMapping(path = "/details", produces = "text/plain; charset=UTF-8")
    String notificationDetails(@RequestParam("notificationId") long id,
                               Model model){
        Notification notification = notificationRepository.findById(id).get();
        List<Notification> notificationsWorkshop = notificationRepository.findAllByDepartmentNotClosed(notification.getDepartment());
        model.addAttribute("notification", notification);
        model.addAttribute("notificationsWorkshop", notificationsWorkshop);
        return "notification/details";
    }

    @GetMapping(path = "/it/taken")
    String notificationItTaken(@RequestParam("notId") long id, Model model){
        Notification notification = notificationRepository.findById(id).get();
        notification.setTaken(1);
        notificationRepository.save(notification);
        List<Notification> notificationsIT = notificationRepository.findAllByDepartmentNotClosed(notification.getDepartment());
        model.addAttribute("notificationsIT", notificationsIT);
        model.addAttribute("notification", notification);
        return "notification/listIT";
    }

    @GetMapping(path = "it/close")
    String closeNotificationIt(@RequestParam("notId") long id, Model model){
        Notification notification = notificationRepository.findById(id).get();
        notification.setClosed(1);
        notificationRepository.save(notification);
        List<Notification> notificationsIt = notificationRepository.findAllByDepartmentNotClosed(notification.getDepartment());
        model.addAttribute("notificationsIT", notificationsIt);
        model.addAttribute("notification", notification);
        return "notification/listIT";
    }

    @GetMapping(path = "/workshop/taken")
    String notificationWorkshopTaken(@RequestParam("notId") long id, Model model){
        Notification notification = notificationRepository.findById(id).get();
        notification.setTaken(1);
        notificationRepository.save(notification);
        List<Notification> notificationsWorkshop = notificationRepository.findAllByDepartmentNotClosed(notification.getDepartment());
        model.addAttribute("notificationsWorkshop", notificationsWorkshop);
        model.addAttribute("notification", notification);
        return "notification/listWorkshop";
    }

    @GetMapping(path = "workshop/close")
    String closeNotificationWorkshop(@RequestParam("notId") long id, Model model){
        Notification notification = notificationRepository.findById(id).get();
        notification.setClosed(1);
        notificationRepository.save(notification);
        List<Notification> notificationsWorkshop = notificationRepository.findAllByDepartmentNotClosed(notification.getDepartment());
        model.addAttribute("notificationsWorkshop", notificationsWorkshop);
        model.addAttribute("notification", notification);
        return "notification/listWorkshop";
    }
}
