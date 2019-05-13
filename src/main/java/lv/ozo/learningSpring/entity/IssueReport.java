package lv.ozo.learningSpring.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "issues")
public class IssueReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Urla is mandatory")
    private String url;
    @NotBlank(message = "text is mandatory")
    private String description;
    private boolean markedAsPrivate;
    private boolean updates;
    private boolean done;
    private Date created;
    private Date updated;

    public IssueReport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMarkedAsPrivate() {
        return markedAsPrivate;
    }

    public void setMarkedAsPrivate(boolean markedAsPrivate) {
        this.markedAsPrivate = markedAsPrivate;
    }

    public boolean isUpdates() {
        return updates;
    }

    public void setUpdates(boolean updates) {
        this.updates = updates;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}