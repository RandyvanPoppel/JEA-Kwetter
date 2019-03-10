package dao.implementations;

import dao.JPA;
import dao.interfaces.KweetDAO;
import models.Kweet;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
        em.remove(kweet);
    }

    @Override
    public Kweet findByID(Long id) {
        Kweet kweet = em.find(Kweet.class, id);
        if (kweet == null)
        {
            throw new EntityNotFoundException("Can't find Kweet with ID: " + id);
        }
        return kweet;
    }

    @Override
    public ArrayList<Kweet> findByMessage(String message) {
        List<Kweet> kweets = em.createQuery("SELECT k FROM Kweet k WHERE message LIKE %" + message + "%").getResultList();
        return (ArrayList<Kweet>) kweets;
    }

    @Override
    public ArrayList<Kweet> getKweets() {
        List<Kweet> kweets = em.createQuery("SELECT k FROM Kweet k").getResultList();
        return (ArrayList<Kweet>) kweets;
    }
}
