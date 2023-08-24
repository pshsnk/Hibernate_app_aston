package org.example.hibernate_app_aston.dao;

import org.example.hibernate_app_aston.models.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ProjectDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Project> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Project p", Project.class)
                .getResultList();
    }

    @Transactional
    public Project show(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Project.class, id);
    }


    @Transactional
    public Project showByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Project p where name= ?1", Project.class)
                .setParameter(1, name).getSingleResult();
    }

    @Transactional
    public void save(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.save(project);
    }



    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Project projectToDelete = session.get(Project.class, id);
        session.remove(projectToDelete);
    }

}
