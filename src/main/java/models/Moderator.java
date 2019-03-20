package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "Moderator")
@Table(name = "moderator")
@XmlRootElement
public class Moderator extends User {
    @Id
    @GeneratedValue
    private Long id;

    public Moderator() {}
}
