package com.infoshare.jjdd6.moviespotter.dao;

import com.infoshare.jjdd6.moviespotter.models.Programme;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProgrammeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public String save(Programme p) {
        entityManager.persist(p);
        return p.getTitleEn();
    }

    public Programme update(Programme p) {
        return entityManager.merge(p);
    }

    public void delete(String name) {
        final Programme p = entityManager.find(Programme.class, name);
        if (p != null) {
            entityManager.remove(p);
        }
    }

    public Programme findByName(String name) {
        return entityManager.find(Programme.class, name);
    }
}
