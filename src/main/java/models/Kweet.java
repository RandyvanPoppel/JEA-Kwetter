package models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity(name = "Kweet")
@Table(name = "kweet")
@XmlRootElement
public class Kweet extends BaseModel implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kweeter_id")
    private Kweeter kweeter;

    @Column(name = "message", unique = true)
    private String message;

    //    @ElementCollection
//    @CollectionTable(name ="likes" , joinColumns=@JoinColumn(name="id"))
//    @Column(name="kweet")
//    private ArrayList<Like> likes = new ArrayList<Like>();

    public Kweet() {}

    public Kweet(Kweeter kweeter, String message)
    {
        this.kweeter = kweeter;
        this.message = message;
    }

    public void setKweeter(Kweeter kweeter)
    {
        this.kweeter = kweeter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kweet )) return false;
        return id != null && id.equals(((Kweet) o).id);
    }
    @Override
    public int hashCode() {
        return 31;
    }

//    public void addLike(Like like)
//    {
//        likes.add(like);
//    }

//    public void removeLike(Like like)
//    {
//        likes.remove(like);
//    }
}
