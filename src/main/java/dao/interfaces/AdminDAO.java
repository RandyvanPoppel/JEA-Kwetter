package dao.interfaces;

import models.Admin;

public interface AdminDAO {
    void addAdmin(Admin admin);

    void removeAdmin(Admin admin);

    Admin findByID(long id);
}
