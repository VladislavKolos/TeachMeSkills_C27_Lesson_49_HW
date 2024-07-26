package com.example.service;

import com.example.model.User;
import com.example.util.HibernateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

/**
 * User management service. Performs user creation, getting, updating, and deleting operations.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final HibernateUtil hibernateUtil;

    /**
     * Creates a new user in the database.
     * @param user user object to add
     * @return added user
     */
    public User createUser(User user) {
        SessionFactory sessionFactory = hibernateUtil.buildSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            session.save(user);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error("An exception occurred while creating a user! " + e);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    /**
     * Finds a user by ID.
     * @param id user ID
     * @return found user or null if user not found
     */
    public User getUser(int id) {
        SessionFactory sessionFactory = hibernateUtil.buildSessionFactory();
        Session session = null;
        User user = null;

        try {
            session = sessionFactory.openSession();

            user = session.get(User.class, id);

        } catch (Exception e) {
            log.error("An exception occurred while searching for a user! " + e);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    /**
     * Updates the user login.
     * @param id user ID
     * @param newLogin new user login
     */
    public void updateUser(int id, String newLogin) {
        SessionFactory sessionFactory = hibernateUtil.buildSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            User user = session.get(User.class, id);
            user.setLogin(newLogin);
            session.update(user);
            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error("An exception occurred during a user update! " + e);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Removes a user from the database by ID.
     * @param id user ID to delete
     */
    public void deleteUser(int id) {
        SessionFactory sessionFactory = hibernateUtil.buildSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error("An exception occurred when deleting a user! " + e);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
