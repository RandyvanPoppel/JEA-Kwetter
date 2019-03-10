package services;

import dao.JPA;
import dao.interfaces.CommentDAO;
import models.Comment;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

@Stateless
public class CommentService {

    @Inject @JPA
    private CommentDAO commentDAO;

    public CommentService() {}

    public void addComment(Comment comment)
    {
        commentDAO.addComment(comment);
    }

    public void removeComment(Comment comment)
    {
        commentDAO.removeComment(comment);
    }

    public Comment findByID(Long id)
    {
        return commentDAO.findByID(id);
    }

    public ArrayList<Comment> findByMessage(String message)
    {
        return commentDAO.findByMessage(message);
    }

    public ArrayList<Comment> getComments()
    {
        return commentDAO.getComments();
    }
}
