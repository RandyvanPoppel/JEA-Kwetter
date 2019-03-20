package dao.implementations;

import dao.JPA;
import dao.interfaces.ModeratorDAO;
import models.Moderator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

@Stateless
@JPA
public class ModeratorDAOJPA implements ModeratorDAO {
    @PersistenceContext(unitName = "JEA-Kwetter")
    private EntityManager em;

    public ModeratorDAOJPA() {}

    @Override
    public void addModerator(Moderator moderator) {
        em.persist(moderator);
    }

    @Override
    public void removeModerator(Moderator moderator) {
        em.remove(moderator);
    }

    @Override
    public Moderator findByID(long id) {
        Moderator moderator = em.find(Moderator.class, id);
        if (moderator == null)
        {
            throw new EntityNotFoundException("Can't find Moderator with ID: " + id);
        }
        return moderator;
    }
}
