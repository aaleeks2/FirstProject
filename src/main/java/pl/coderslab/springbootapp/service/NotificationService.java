package pl.coderslab.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.springbootapp.entity.Notification;
import pl.coderslab.springbootapp.repository.NotificationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    public List<Notification> findAllByDepartmentNotClosed(String department) {
        return notificationRepository.findAllByDepartmentNotClosed(department);
    }

    public List<Notification> findAllByCreated() {
        return notificationRepository.findAllByCreated();
    }

    public Optional<Notification> findById(long id) {
        return notificationRepository.findById(id);
    }

    public void save(Notification notification) {
        notificationRepository.save(notification);
    }

    public List<Notification> findAllByExhibit(String exhibitName) {
        return notificationRepository.findAllByExhibit(exhibitName);
    }

//    public List<Notification> findAllExhibitsByCount() {
//        return notificationRepository.findAllExhibitsByCount();
//    }
}
