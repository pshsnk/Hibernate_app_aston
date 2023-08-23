package org.example.hibernate_app_aston.dao;

import org.example.hibernate_app_aston.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Employee> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select e from Employee e", Employee.class)
                .getResultList();
    }

    @Transactional
    public Employee show(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Transactional
    public Employee showByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e where name= ?1", Employee.class)
                .setParameter(1, name).getSingleResult();
    }


    @Transactional
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }


    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employeeToDelete = session.get(Employee.class, id);
        session.remove(employeeToDelete);
    }

}
