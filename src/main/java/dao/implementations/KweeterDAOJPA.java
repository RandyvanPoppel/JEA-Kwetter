package dao.implementations;

import dao.JPA;
import dao.interfaces.KweeterDAO;
import models.Kweeter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Stateless
@JPA
public class KweeterDAOJPA implements KweeterDAO {
    @PersistenceContext(unitName = "JEA-Kwetter")
    private EntityManager em;

    public KweeterDAOJPA() {}

    @Override
    public void addKwetteraar(Kweeter kweeter) {
        em.persist(kweeter);
    }

    @Override
    public void removeKwetteraar(Kweeter kweeter) {

    }

    @Override
    public Kweeter findByUserName(String username) {
        return null;
    }

    @Override
    public ArrayList<Kweeter> getKwetteraars() {
        return null;
    }
}
