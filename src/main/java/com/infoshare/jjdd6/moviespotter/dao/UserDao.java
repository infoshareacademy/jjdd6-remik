package com.infoshare.jjdd6.moviespotter.dao;

import com.infoshare.jjdd6.moviespotter.models.User;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserDao {

    private static final Logger log = LoggerFactory.getLogger(UserDao.class.getName());
    private Session session;

    @PersistenceContext
    private EntityManager entityManager;

    public User save(User c) {

        //session.refresh(c);
        entityManager.persist(c);
        log.debug("creating " + c);
        return c;
    }

    public User update(User c) {
        return entityManager.merge(c);
    }

    public void delete(String name) {
        final User c = entityManager.find(User.class, name);
        if (c != null) {
            entityManager.remove(c);
            log.warn("removing " + c);
        }
    }

    public User findById(int Id) {
        return entityManager.find(User.class, Id);
    }


    public Optional<User> findByLogin(String User) {

        Query query = entityManager
                .createQuery("SELECT c FROM User c WHERE c.login like :User")
                .setParameter("User", User);

        return query.getResultStream().findFirst();
    }

    public List <User> findAll() {
        Query query = entityManager
                .createQuery("SELECT c from User c");
        return query.getResultList();
    }
}
