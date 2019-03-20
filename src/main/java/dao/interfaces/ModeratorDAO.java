package dao.interfaces;

import models.Moderator;

public interface ModeratorDAO {
    void addModerator(Moderator moderator);

    void removeModerator(Moderator moderator);

    Moderator findByID(long id);
}
