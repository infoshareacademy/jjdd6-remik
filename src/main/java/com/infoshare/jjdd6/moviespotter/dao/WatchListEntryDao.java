package com.infoshare.jjdd6.moviespotter.dao;

import com.infoshare.jjdd6.moviespotter.models.WatchListEntry;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class WatchListEntryDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public String save(WatchListEntry s) {
        entityManager.persist(s);
        return s.getTitleEn();
    }

    public WatchListEntry update(WatchListEntry s) {
        return entityManager.merge(s);
    }

    public void delete(String name) {
        final WatchListEntry s = entityManager.find(WatchListEntry.class, name);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public WatchListEntry findByName(String name) {
        return entityManager.find(WatchListEntry.class, name);
    }
}
