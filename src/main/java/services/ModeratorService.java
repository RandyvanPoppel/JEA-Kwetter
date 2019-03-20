package services;

import dao.JPA;
import dao.interfaces.ModeratorDAO;
import models.Moderator;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ModeratorService {
    @Inject
    @JPA
    private ModeratorDAO moderatorDAO;

    public ModeratorService() {}

    public void addModerator(Moderator moderator)
    {
        moderatorDAO.addModerator(moderator);
    }

    public void removeModerator(Moderator moderator)
    {
        moderatorDAO.removeModerator(moderator);
    }

    public Moderator findByID(long id) {
        return moderatorDAO.findByID(id);
    }
}
