package dao.implementations;

import dao.JPA;
import dao.interfaces.AdminDAO;
import models.Admin;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

@Stateless
@JPA
public class AdminDAOJPA implements AdminDAO {
    @PersistenceContext(unitName = "JEA-Kwetter")
    private EntityManager em;

    public AdminDAOJPA() {}


    @Override
    public void addAdmin(Admin admin) {
        em.persist(admin);
    }

    @Override
    public void removeAdmin(Admin admin) {
        em.remove(admin);
    }

    @Override
    public Admin findByID(long id) {
        Admin admin = em.find(Admin.class, id);
        if (admin == null)
        {
            throw new EntityNotFoundException("Can't find Admin with ID: " + id);
        }
        return admin;
    }
}
