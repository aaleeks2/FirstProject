package pl.coderslab.springbootapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String name;

    @NotEmpty
    @Size(min=2, max = 50)
    private String surname;

    @NotEmpty
    @Size(min=2, max=15)
    private String username;

    @Email
    private String email;

    private int enabled;

    private int phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications = new ArrayList<>();

    @NotEmpty
    @Size(min = 5, max=255)
    private String password;

    @NotEmpty
    private String department;

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

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public String getUsername() {
        return username;
    }

    public int getEnabled() {
        return enabled;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
