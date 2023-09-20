package org.example.app.repositories;

import org.example.app.entities.User;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class UserReadRepository {

    public List<User> readUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction;

            transaction = session.beginTransaction();
            List<User> contacts = session.createQuery("FROM User", User.class).list();

            transaction.commit();
            return contacts;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
