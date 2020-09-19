package pl.coderslab.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springbootapp.entity.Exhibit;
import pl.coderslab.springbootapp.entity.Notification;
import pl.coderslab.springbootapp.entity.User;
import pl.coderslab.springbootapp.repository.UserRepository;
import pl.coderslab.springbootapp.service.ExhibitService;
import pl.coderslab.springbootapp.service.NotificationService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExhibitService exhibitService;

    @GetMapping(path = "/it/list", produces = "test/plain; charset=UTF-8")
    String notificationsListIT(Model model){
        String department = "it";
        List<Notification> notificationsIT = notificationService.findAllByDepartmentNotClosed(department);
        model.addAttribute("notificationsIT", notificationsIT);
        model.addAttribute("count", notificationsIT.size());
        return "notification/listIT";
    }

    @GetMapping(path = "/workshop/list", produces = "text/plain; charset=utf-8")
    String notificationListWorkshop(Model model){
        String department = "workshop";
        List<Notification> notificationsWorkshop = notificationService.findAllByDepartmentNotClosed(department);
        model.addAttribute("count", notificationsWorkshop.size());
        model.addAttribute("notificationsWorkshop", notificationsWorkshop);
        return "notification/listWorkshop";
    }

    @GetMapping(path="/history")
    String viewHistoryByCreated(Model model){
        List<Notification> historyOfNotifications = notificationService.findAllByCreated();
        model.addAttribute("historyOfNotifications", historyOfNotifications);
        return "notification/history";
    }

    @GetMapping(path = "/details", produces = "text/plain; charset=UTF-8")
    String notificationDetails(@RequestParam("notificationId") long id,
                               Model model){
        Notification notification = notificationService.findById(id).get();
        List<Notification> notificationsWorkshop = notificationService.findAllByDepartmentNotClosed(notification.getDepartment());
        model.addAttribute("notification", notification);
        model.addAttribute("notificationsWorkshop", notificationsWorkshop);
        return "notification/details";
    }

    @GetMapping(path = "/it/taken")
    String notificationItTaken(@RequestParam("notId") long id, @RequestParam("username") String username, Model model){
        Notification notification = notificationService.findById(id).get();
        User user = userRepository.findByUsername(username);
        notification.setTaken(1);
        notification.setUser(user);
        notificationService.save(notification);
        List<Notification> notificationsIT = notificationService.findAllByDepartmentNotClosed(notification.getDepartment());
        model.addAttribute("notificationsIT", notificationsIT);
        model.addAttribute("notification", notification);
        model.addAttribute("count", notificationsIT.size());
        return "notification/listIT";
    }

    @GetMapping(path = "it/close")
    String closeNotificationIt(@RequestParam("notId") long id, Model model){
        Notification notification = notificationService.findById(id).get();
        notification.setClosed(1);
        notificationService.save(notification);
        List<Notification> notificationsIt = notificationService.findAllByDepartmentNotClosed(notification.getDepartment());
        model.addAttribute("notificationsIT", notificationsIt);
        model.addAttribute("notification", notification);
        model.addAttribute("count", notificationsIt.size());
        return "notification/listIT";
    }

    @GetMapping(path = "/workshop/taken")
    String notificationWorkshopTaken(@RequestParam("notId") long id, @RequestParam("username") String username, Model model){
        Notification notification = notificationService.findById(id).get();
        User user = userRepository.findByUsername(username);
        notification.setTaken(1);
        notification.setUser(user);
        notificationService.save(notification);
        List<Notification> notificationsWorkshop = notificationService.findAllByDepartmentNotClosed(notification.getDepartment());
        model.addAttribute("notificationsWorkshop", notificationsWorkshop);
        model.addAttribute("notification", notification);
        model.addAttribute("count", notificationsWorkshop.size());
        return "notification/listWorkshop";
    }

    @GetMapping(path = "workshop/close")
    String closeNotificationWorkshop(@RequestParam("notId") long id, Model model){
        Notification notification = notificationService.findById(id).get();
        notification.setClosed(1);
        notificationService.save(notification);
        List<Notification> notificationsWorkshop = notificationService.findAllByDepartmentNotClosed(notification.getDepartment());
        model.addAttribute("notificationsWorkshop", notificationsWorkshop);
        model.addAttribute("notification", notification);
        model.addAttribute("count", notificationsWorkshop.size());
        return "notification/listWorkshop";
    }

    @GetMapping(path = "/ranking")
    String ranking(Model model){
//        List<Exhibit> exhibitRanking = exhibitService.findAll();
//        Map<Exhibit, Integer> exhibitIntegerMap = exhibitRanking.stream()
//                .collect(Collectors.toMap(x -> x, x -> x.countNotifications()));
        List<Exhibit> exhibitRanking = exhibitService.findAllCount();
        Map<Exhibit, Integer> exhibitIntegerMap = exhibitRanking.stream()
                .collect(Collectors.toMap(x -> x, x -> x.countNotifications()));
        model.addAttribute("exhibitRanking", exhibitRanking);
        return "exhibits/ranking";
    }
}
