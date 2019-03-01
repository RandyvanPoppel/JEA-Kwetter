package dao.interfaces;

import models.Kweeter;

import java.util.ArrayList;

public interface KweeterDAO {
    void addKweeter(Kweeter kweeter);

    void removeKweeter(Kweeter kweeter);

    Kweeter findByUserName(String username);

    ArrayList<Kweeter> getKweeters();
}
