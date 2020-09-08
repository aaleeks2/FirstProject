package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springbootapp.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
