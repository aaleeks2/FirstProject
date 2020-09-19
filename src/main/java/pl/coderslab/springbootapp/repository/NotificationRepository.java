package pl.coderslab.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.springbootapp.entity.Exhibit;
import pl.coderslab.springbootapp.entity.Notification;

import java.util.List;
import java.util.Map;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByDepartment(String department);

    @Query("select n from Notification n where n.exhibit.name=?1")
    List<Notification> findAllByExhibit(String exhibitName);

    @Query("select n from Notification n where n.closed=0 and n.department=?1")
    List<Notification> findAllByDepartmentNotClosed(String department);

    @Query("select n from Notification n order by n.created desc")
    List<Notification> findAllByCreated();
//
//    @Query("select e from Exhibit e group by e.id order by count(e.notifications) desc")
//    List<Notification> findAllExhibitsByCount();

}
