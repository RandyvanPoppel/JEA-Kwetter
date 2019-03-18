package services;

import dao.JPA;
import dao.interfaces.AdminDAO;
import models.Admin;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AdminService {
    @Inject
    @JPA
    private AdminDAO adminDAO;

    public AdminService() {}

    public void addAdmin(Admin admin)
    {
        adminDAO.addAdmin(admin);
    }

    public void removeAdmin(Admin admin)
    {
        adminDAO.removeAdmin(admin);
    }

    public Admin findByID(long id) {
        return adminDAO.findByID(id);
    }
}
