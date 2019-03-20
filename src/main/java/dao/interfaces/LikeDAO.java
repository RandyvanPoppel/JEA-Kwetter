package dao.interfaces;

import models.Kweet;
import models.Kweeter;
import models.Like;

import java.util.ArrayList;

public interface LikeDAO {
    void addLike(Like like);

    void removeLike(Like like);

    Like findByID(Long id);

    ArrayList<Like> findByKweet(Kweet kweet);

    ArrayList<Like> findByKweeter(Kweeter kweeter);
}
