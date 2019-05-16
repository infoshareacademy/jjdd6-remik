package com.infoshare.jjdd6.moviespotter.dao;

import com.infoshare.jjdd6.moviespotter.models.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class ChannelDao {

    private static final Logger log = LoggerFactory.getLogger(ChannelDao.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    public Channel save(Channel c) {

        entityManager.persist(c);
        log.debug("creating " + c);
        return c;
    }

    public Channel update(Channel c) {
        return entityManager.merge(c);
    }

    public void delete(String name) {
        final Channel c = entityManager.find(Channel.class, name);
        if (c != null) {
            entityManager.remove(c);
            log.warn("removing " + c);
        }
    }

    public Channel findById(int Id) {
        return entityManager.find(Channel.class, Id);
    }

    public Optional<Channel> findByName(String channel) {

        Query query = entityManager
                .createQuery("SELECT c FROM Channel c WHERE c.name like :channel")
                .setParameter("channel", channel);

        return query.getResultStream().findFirst();
    }

    public List<Channel> findAll() {
        Query query = entityManager
                .createQuery("SELECT c from Channel c");

        return query.getResultList();
    }
}
