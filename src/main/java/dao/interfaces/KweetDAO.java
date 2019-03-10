package dao.interfaces;

import models.Kweet;

import java.util.ArrayList;

public interface KweetDAO {
    void addKweet(Kweet kweet);

    void removeKweet(Kweet kweet);

    Kweet findByID(Long id);

    ArrayList<Kweet> findByMessage(String username);

    ArrayList<Kweet> getKweets();
}
