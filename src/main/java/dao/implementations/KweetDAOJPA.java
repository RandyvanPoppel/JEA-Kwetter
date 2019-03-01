package dao.implementations;

import dao.JPA;
import dao.interfaces.KweetDAO;
import models.Kweet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Stateless
@JPA
public class KweetDAOJPA implements KweetDAO {
    @PersistenceContext(unitName = "JEA-Kwetter")
    private EntityManager em;

    public KweetDAOJPA() {}

    @Override
    public void addKweet(Kweet kweet) {
        em.persist(kweet);
    }

    @Override
    public void removeKweet(Kweet kweet) {

    }

    @Override
    public Kweet findByMessage(String username) {
        return null;
    }

    @Override
    public ArrayList<Kweet> getKweets() {
        return null;
    }
}
