package com.infoshare.jjdd6.moviespotter.dao;

import com.infoshare.jjdd6.moviespotter.models.Channel;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.services.DummiesProducer;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
@Transactional
public class ChannelDao {

    private static final Logger log = LoggerFactory.getLogger(ChannelDao.class.getName());
    private Session session;

    @PersistenceContext
    private EntityManager entityManager;
    private List<Channel> temp = new ArrayList<>();

    public Channel save(Channel c) {

        //session.refresh(c);
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


    public Channel findByName(String channel) {

        Query query = entityManager
                .createQuery("SELECT c FROM Channel c WHERE c.name like :channel")
                .setParameter("channel", channel);

        return (Channel) query.getResultStream().findAny().orElse(null);
    }

    public List<Channel> findAll() {
        Query query = entityManager
                .createQuery("SELECT c from Channel c");

        return query.getResultList();
    }


}
