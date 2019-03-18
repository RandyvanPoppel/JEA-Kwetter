package models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity(name = "User")
@Table(name = "user")
@XmlRootElement
public abstract class User extends BaseModel implements Serializable {

    @Id @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String name;
    private String bio;
    private String location;
    private String website;

    public User() {}

    public User(String name, String bio, String location, String website) {
        this.name = name;
        this.bio = bio;
        this.location = location;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
