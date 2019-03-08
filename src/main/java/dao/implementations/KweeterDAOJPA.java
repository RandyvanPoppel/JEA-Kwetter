package dao.implementations;

import dao.JPA;
import dao.interfaces.KweeterDAO;
import models.Kweeter;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPA
public class KweeterDAOJPA implements KweeterDAO {
    @PersistenceContext(unitName = "JEA-Kwetter")
    private EntityManager em;

    public KweeterDAOJPA() {}

    @Override
    public void addKweeter(Kweeter kweeter) {
        em.persist(kweeter);
    }

    @Override
    public void removeKweeter(Kweeter kweeter) {
        em.remove(kweeter);
    }

    @Override
    public Kweeter findByUserName(String username) {
        Kweeter kweeter = em.find(Kweeter.class, username);
        if (kweeter == null)
        {
            throw new EntityNotFoundException("Can't find Kweeter with username: " + username);
        }
        return kweeter;
    }

    @Override
    public ArrayList<Kweeter> getKweeters() {
        List<Kweeter> kweeters = em.createQuery("SELECT k FROM Kweeter k").getResultList();
        return (ArrayList<Kweeter>) kweeters;
    }
}
