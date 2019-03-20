package dao.implementations;

import dao.JPA;
import dao.interfaces.LikeDAO;
import models.Kweet;
import models.Kweeter;
import models.Like;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPA
public class LikeDAOJPA implements LikeDAO {
    @PersistenceContext(unitName = "JEA-Kwetter")
    private EntityManager em;

    public LikeDAOJPA() {}

    @Override
    public void addLike(Like like) {
        em.persist(like);
    }

    @Override
    public void removeLike(Like like) {
        em.remove(like);
    }

    @Override
    public Like findByID(Long id) {
        Like like = em.find(Like.class, id);
        if (like == null)
        {
            throw new EntityNotFoundException("Can't find Like with ID: " + id);
        }
        return like;
    }

    @Override
    public ArrayList<Like> findByKweet(Kweet kweet) {
        List<Like> likes = em.createQuery("SELECT l FROM Like k WHERE kweet_id = " + kweet.getID() + "%").getResultList();
        return (ArrayList<Like>) likes;
    }

    @Override
    public ArrayList<Like> findByKweeter(Kweeter kweeter) {
        List<Like> likes = em.createQuery("SELECT l FROM Like k WHERE kweeter_id = " + kweeter.getUsername() + "%").getResultList();
        return (ArrayList<Like>) likes;
    }
}
