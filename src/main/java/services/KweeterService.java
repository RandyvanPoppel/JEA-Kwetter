package services;

import dao.JPA;
import dao.interfaces.KweeterDAO;
import models.Kweeter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;

@Stateless
public class KweeterService {

    @Inject @JPA
    private KweeterDAO kweeterDAO;

    public KweeterService() {}

    public void addKweeter(Kweeter kweeter)
    {
        kweeterDAO.addKweeter(kweeter);
    }

    public void removeKweeter(Kweeter kweeter)
    {
        kweeterDAO.removeKweeter(kweeter);
    }

    public Kweeter findByUserName(String username)
    {
        return kweeterDAO.findByUserName(username);
    }

    public ArrayList<Kweeter> getKweeters()
    {
        return kweeterDAO.getKweeters();
    }
}
