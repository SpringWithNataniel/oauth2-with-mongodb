package br.com.oauth2.mongodb.entity;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author nataniel
 */
@Document
public class User {

    @Id
    private String id;

    @NotNull(message = "NAME_REQUIRED")
    private String name;

    @NotNull(message = "EMAIL_REQUIRED")
    @Indexed(unique = true)
    private String email;

    private String pass;

    @DBRef
    private List<Role> roles;

    private Boolean isDeleted;

    @DBRef
    private FileMeRoubaram photo;

    public User(User user) {
        super();
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.roles = user.getRoles();
        this.pass = user.getPass();
        this.isDeleted = false;
    }

    public User() {
    }

    public User(String name, String email, String password, List<Role> roles) {
        this.name = name;
        this.email = email;
        this.pass = password;
        this.roles = roles;
        this.isDeleted = false;
    }

    public String getId() {
        return id;
    }

    public FileMeRoubaram getPhoto() {
        return photo;
    }

    public void setPhoto(FileMeRoubaram photo) {
        this.photo = photo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
