package com.infoshare.jjdd6.moviespotter.dao;

import com.infoshare.jjdd6.moviespotter.models.FavoriteMovie;
import com.infoshare.jjdd6.moviespotter.models.User;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Stateless
public class FavoriteMovieDao {

    private static final Logger log = LoggerFactory.getLogger(FavoriteMovieDao.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    public FavoriteMovie save(FavoriteMovie c) {

        log.info("trying to write favmovie: "+c.getFilmWebId());
        entityManager.persist(c);
        log.debug("creating " + c);
        return c;
    }

    public FavoriteMovie update(FavoriteMovie c) {
        return entityManager.merge(c);
    }

    public void delete(Long Id) {
        final FavoriteMovie c = entityManager.find(FavoriteMovie.class, Id);
        if (c != null) {
            entityManager.remove(c);
            log.warn("removing " + c);
        }
    }

    public FavoriteMovie findById(int Id) {
        return entityManager.find(FavoriteMovie.class, Id);
    }



    public List<FavoriteMovie> findByFwId(Long filmWebId) {
        Query query = entityManager
                .createQuery("SELECT c from FavoriteMovie c where c.filmWebId = :filmWebId")
                .setParameter("filmWebId", filmWebId);
        return query.getResultList();
    }

    public List<FavoriteMovie> findAll() {
        Query query = entityManager
                .createQuery("SELECT c from FavoriteMovie c");

        return query.getResultList();
    }


}
