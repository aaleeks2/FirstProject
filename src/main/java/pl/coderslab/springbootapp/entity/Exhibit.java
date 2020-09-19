package pl.coderslab.springbootapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Exhibit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "exhibition")
    private Exhibition exhibition;

    @OneToMany(mappedBy = "exhibit", fetch = FetchType.EAGER)
    private List<Notification> notifications = new ArrayList<>();

    @Transient
    private long notificationCount;

    public int countNotifications(){
        return this.notifications.size();
    }

    public Exhibit(long id, String name, Exhibition exhibition, long notificationCount){
        this.id = id;
        this.name = name;
        this.exhibition = exhibition;
        this.notificationCount = notificationCount;
    }

    public long getNotificationCount() {
        return notificationCount;
    }

    public Exhibit() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Exhibition getExhibition() {
        return exhibition;
    }

    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "Exhibit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exhibition=" + exhibition +
                '}';
    }
}
