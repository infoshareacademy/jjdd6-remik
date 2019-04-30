package com.infoshare.jjdd6.moviespotter.dao;

import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.sun.istack.Nullable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

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

    public Programme findById(int Id) {
        return entityManager.find(Programme.class, Id);
    }

    public List<Programme> findByChannel(String channel) {
        Query query = entityManager
                .createQuery("SELECT s FROM Programme s WHERE s.channel like :channel ORDER BY s.channel, s.start")
                .setParameter("channel", channel);
        return query.getResultList();
    }

    public List<Programme> findByChannelAndDate (String channel, @Nullable LocalDateTime from, @Nullable LocalDateTime to) {
        if (from == null)
            from = LocalDateTime.now();
        if (to == null)
            to = LocalDateTime.now().plusYears(100);

        Query query = entityManager
                .createQuery("SELECT s FROM Programme s WHERE s.channel like :channel AND s.start >= :from AND s.start <= :to ORDER BY s.channel, s.start")
                .setParameter("channel", channel )
                .setParameter("from", from)
                .setParameter("to", to);
        return query.getResultList();
    }

    public List<Programme> getAllProgrammes() {
        Query query = entityManager.createQuery("SELECT s FROM Programme s ORDER BY s.channel, s.start");
        return query.getResultList();
    }


}
