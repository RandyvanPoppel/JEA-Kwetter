package dao.interfaces;

import models.Comment;

import java.util.ArrayList;

public interface CommentDAO {
    void addComment(Comment comment);

    void removeComment(Comment comment);

    Comment findByID(Long id);

    ArrayList<Comment> findByMessage(String message);

    ArrayList<Comment> getComments();
}
