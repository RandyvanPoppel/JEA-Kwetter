package models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "message")
    private String message;

    @OneToMany(
            mappedBy = "kweet",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments = new ArrayList<>();

    public Kweet() {}

    public Kweet(Kweeter kweeter, String message)
    {
        this.kweeter = kweeter;
        this.message = message;
    }

    public Long getID()
    {
        return id;
    }

    public Kweeter getKweeter() {
        return kweeter;
    }

    public String getMessage() {
        return message;
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
