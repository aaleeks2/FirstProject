package pl.coderslab.springbootapp.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String department;

    @NotEmpty
    private String type;

    @Size(max = 155)
    private String description;

    @ManyToOne
    @JoinColumn(name = "exhibit")
    private Exhibit exhibit;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date created;

    public Notification() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Exhibit getExhibit() {
        return exhibit;
    }

    public void setExhibit(Exhibit exhibit) {
        this.exhibit = exhibit;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", exhibit=" + exhibit +
                '}';
    }
}
