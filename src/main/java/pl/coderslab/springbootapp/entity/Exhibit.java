package pl.coderslab.springbootapp.entity;

import javax.persistence.*;
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

    public Exhibit() {
    }

    public int countNotifications(){
        return this.notifications.size();
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

    public List<Notification> getNotifications() {
        return notifications;
    }

}
