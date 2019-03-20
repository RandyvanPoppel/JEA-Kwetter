package services;

import dao.JPA;
import dao.interfaces.LikeDAO;
import models.Kweet;
import models.Kweeter;
import models.Like;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

@Stateless
public class LikeService {

    @Inject @JPA
    private LikeDAO likeDAO;

    public LikeService() {}

    public void addLike(Like like)
    {
        likeDAO.addLike(like);
    }

    public void removeLike(Like like)
    {
        likeDAO.removeLike(like);
    }

    public Like findByID(Long id)
    {
        return likeDAO.findByID(id);
    }

    public ArrayList<Like> findByKweet(Kweet kweet)
    {
        return likeDAO.findByKweet(kweet);
    }

    public ArrayList<Like> findByKweeter(Kweeter kweeter)
    {
        return likeDAO.findByKweeter(kweeter);
    }
}
