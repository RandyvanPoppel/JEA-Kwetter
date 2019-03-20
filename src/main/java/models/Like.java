package models;

import javax.persistence.*;
import java.io.Serializable;

public class Like extends BaseModel implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kweet_id")
    private Kweet kweet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kweeter_id")
    private Kweeter kweeter;

    public Like() {}

    public Like(Kweet kweet, Kweeter kweeter)
    {
        this.kweet = kweet;
        this.kweeter = kweeter;
    }
}
