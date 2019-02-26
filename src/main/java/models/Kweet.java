package models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity()
@XmlRootElement
public class Kweet implements Serializable {

    @Id @GeneratedValue
    private Long id;
    @Column(unique=true)
    private User creator;

    public Kweet() {}

    public Kweet(User creator)
    {
        this.creator = creator;
    }
}
