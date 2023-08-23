package org.example.hibernate_app_aston.dao;

import org.example.hibernate_app_aston.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class RoleDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Role> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select r from Role r", Role.class)
                .getResultList();
    }

    @Transactional
    public Role show(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, id);
    }


    @Transactional
    public Role showByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select r from Role r where name= ?1", Role.class)
                .setParameter(1, name).getSingleResult();
    }

    @Transactional
    public void save(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.save(role);
    }



    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Role roleToDelete = session.get(Role.class, id);
        session.remove(roleToDelete);
    }
}
