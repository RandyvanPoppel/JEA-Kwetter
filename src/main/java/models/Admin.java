package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "Admin")
@Table(name = "admin")
@XmlRootElement
public class Admin extends User {
    @Id
    @GeneratedValue
    private Long id;

    public Admin() {}
}
