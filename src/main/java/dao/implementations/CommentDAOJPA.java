package dao.implementations;

import dao.JPA;
import dao.interfaces.CommentDAO;
import models.Comment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@JPA
public class CommentDAOJPA implements CommentDAO {
    @PersistenceContext(unitName = "JEA-Kwetter")
    private EntityManager em;

    public CommentDAOJPA() {}

    @Override
    public void addComment(Comment comment) {
        em.persist(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        em.remove(comment);
    }

    @Override
    public Comment findByID(Long id) {
        Comment comment = em.find(Comment.class, id);
        if (comment == null)
        {
            throw new EntityNotFoundException("Can't find Comment with ID: " + id);
        }
        return comment;
    }

    @Override
    public ArrayList<Comment> findByMessage(String message) {
        List<Comment> comments = em.createQuery("SELECT c FROM Comment c WHERE message LIKE %" + message + "%").getResultList();
        return (ArrayList<Comment>) comments;
    }

    @Override
    public ArrayList<Comment> getComments() {
        List<Comment> comments = em.createQuery("SELECT c FROM Comment c").getResultList();
        return (ArrayList<Comment>) comments;
    }
}
