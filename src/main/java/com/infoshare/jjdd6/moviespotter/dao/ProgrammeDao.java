package com.infoshare.jjdd6.moviespotter.dao;

import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.sun.istack.Nullable;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.CONCAT;

@Transactional
@Stateless
public class ProgrammeDao {

    private Session session;

    private static final Logger log = LoggerFactory.getLogger(ProgrammeDao.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    public String save(Programme p) {
        log.debug("programme " + p.getChannel().getName() + p.getStart());
        entityManager.persist(p);
        log.debug("creating " + p);
        return p.getTitlePl();
    }

    public Programme update(Programme p) {
        return entityManager.merge(p);
    }

    public void delete(String name) {
        final Programme p = entityManager.find(Programme.class, name);
        if (p != null) {
            entityManager.remove(p);
            log.warn("removing " + p);
        }
    }

    public Programme findById(int Id) {
        return entityManager.find(Programme.class, Id);
    }

    public List<Programme> findByChannel(String channel) {
        Query query = entityManager
                .createQuery("SELECT s FROM Programme s WHERE s.channel.name like :channel ORDER BY s.channel.name, s.start")
                .setParameter("channel", channel);
        return query.getResultList();
    }

    public List<Programme> findByChannelAndDate(String channel, @Nullable LocalDateTime from, @Nullable LocalDateTime to) {

        try {
            if (from == null) {
                from = LocalDateTime.now();
            }
            if (to == null) {
                to = LocalDateTime.now().plusYears(100);
            }

            Query query = entityManager
                    .createQuery("SELECT s FROM Programme s WHERE s.channel.name like :channel AND s.start >= :from AND s.start <= :to ORDER BY s.channel.name, s.start")
                    .setParameter("channel", channel)
                    .setParameter("from", from)
                    .setParameter("to", to);
            return query.getResultList();
        } catch (Exception e) {
            log.error("By channel, from, to: "+e);
            return null;
        }
    }

    public List<Programme> getAllProgrammes() {
        Query query = entityManager.createQuery("SELECT s FROM Programme s ORDER BY s.channel.name, s.start");
        return query.getResultList();
    }

    public List<Programme> findByName (String name) {
        Query query = entityManager
                .createQuery("SELECT s FROM Programme s WHERE s.channel.name like :name ORDER BY s.start")
                .setParameter("name",name);
        List <Programme> ret =query.getResultList();

        log.info("Asked for "+name+", found"+ret.stream().findAny().orElse(null).getChannel().getName());

        return ret;
    }

    public List<Programme> getAllOccurences(List<String> Titles) {
        Query query = entityManager
                .createQuery("SELECT s FROM Programme s WHERE s.titlePl in :Titles")
                .setParameter("Titles", Titles);

        return query.getResultList();
    }

    public List<Programme> getByStringTitle(String title) {
        Query query = entityManager
                .createQuery("SELECT s FROM Programme s WHERE s.titlePl like CONCAT('%', :title, '%') OR s.titleEn like CONCAT('%', :title, '%') OR s.titleXx like CONCAT('%', :title, '%')")
                .setParameter("title", title);
        return query.getResultList();
    }

    public Programme findByHash(int hash) {
        return entityManager.find(Programme.class, hash);
    }
}
