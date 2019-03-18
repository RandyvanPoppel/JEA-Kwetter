package models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Kweeter")
@Table(name = "kweeter")
@XmlRootElement
public class Kweeter extends User implements Serializable {

    @Id
    @Column(unique = true)
    private String username;

    @OneToMany(
            mappedBy = "kweeter",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Kweet> kweets = new ArrayList<>();

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addKweet(Kweet kweet)
    {
        kweets.add(kweet);
    }

    public void removeKweet(Kweet kweet)
    {
        kweets.remove(kweet);
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
}
