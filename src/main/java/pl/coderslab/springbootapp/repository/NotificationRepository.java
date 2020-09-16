package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.springbootapp.entity.Notification;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByDepartment(String department);

    @Query("select n from Notification n where n.exhibit.name=?1")
    List<Notification> findAllByExhibit(String exhibitName);
}
