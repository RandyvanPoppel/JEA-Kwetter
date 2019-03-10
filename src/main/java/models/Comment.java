package models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity(name = "Comment")
@Table(name = "comment")
@XmlRootElement
public class Comment extends BaseModel implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kweeter_id")
    private Kweeter kweeter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kweet_id")
    private Kweet kweet;

    @Column(name = "message")
    private String message;

    public Comment() {}

    public Comment(Kweeter kweeter, Kweet kweet, String message)
    {
        this.kweeter = kweeter;
        this.kweet = kweet;
        this.message = message;
    }

    public Kweeter getKweeter()
    {
        return kweeter;
    }

    public Kweet getKweet()
    {
        return kweet;
    }

    public String getMessage()
    {
        return message;
    }
}
