package services;

import dao.JPA;
import dao.interfaces.KweetDAO;
import models.Kweet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

@Stateless
public class KweetService {

    @Inject @JPA
    private KweetDAO kweetDAO;

    public KweetService() {}

    public void addKweet(Kweet kweet)
    {
        kweetDAO.addKweet(kweet);
    }

    public void removeKweet(Kweet kweet)
    {
        kweetDAO.removeKweet(kweet);
    }

    public Kweet findByID(Long id)
    {
        return kweetDAO.findByID(id);
    }

    public Kweet findByMessage(String message)
    {
        return kweetDAO.findByMessage(message);
    }

    public ArrayList<Kweet> getKweets()
    {
        return kweetDAO.getKweets();
    }
}
