package services;

import dao.JPA;
import dao.interfaces.KweeterDAO;
import models.Kweeter;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class KweeterService {

    @Inject @JPA
    private KweeterDAO kweeterDAO;

    public KweeterService() {}

    public void addKwetteraar(Kweeter kweeter)
    {
        kweeterDAO.addKweeter(kweeter);
    }
}
