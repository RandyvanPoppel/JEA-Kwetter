package dao.interfaces;

import models.Kweeter;

import java.util.ArrayList;

public interface KweeterDAO {
    void addKwetteraar(Kweeter kweeter);

    void removeKwetteraar(Kweeter kweeter);

    Kweeter findByUserName(String username);

    ArrayList<Kweeter> getKwetteraars();
}
