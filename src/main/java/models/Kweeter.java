package models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@Entity()
@Table(name = "Kweeter")
@XmlRootElement
public class Kweeter extends BaseModel implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "kweeterID")
    private Long id;
    @Column(name = "username", unique = true)
    private String username;

    // Kwetteraars that this Kweeter follows
//    @ElementCollection
//    @CollectionTable(name ="followers" , joinColumns=@JoinColumn(name="id"))
//    @Column(name="followedKwetteraar")
//    private ArrayList<Kweeter> followedKwetteraars = new ArrayList<Kweeter>();

    // Following Kwetteraars that this Kweeter has
//    @ElementCollection
//    @CollectionTable(name ="followers" , joinColumns=@JoinColumn(name="id"))
//    @Column(name="followingKwetteraar")
//    private ArrayList<Kweeter> followingKwetteraars = new ArrayList<Kweeter>();

    public Kweeter() {
    }

    public Kweeter(String username)
    {
        this.username = username;
    }

//    public void addFollower(Kweeter kwetteraar) // Add new Kweeter that follows this Kweeter
//    {
//        followedKwetteraars.add(kwetteraar);
//    }
//
//    public void removeFollower(Kweeter kwetteraar) // Remove Kweeter that follows this Kweeter
//    {
//        followedKwetteraars.remove(kwetteraar);
//    }
//
//    public void addFollowing(Kweeter kwetteraar) // Add new Kweeter that this Kweeter follows
//    {
//        followedKwetteraars.add(kwetteraar);
//    }
//
//    public void removeFollowing(Kweeter kwetteraar) // Remove Kweeter that this Kweeter follows
//    {
//        followedKwetteraars.remove(kwetteraar);
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
