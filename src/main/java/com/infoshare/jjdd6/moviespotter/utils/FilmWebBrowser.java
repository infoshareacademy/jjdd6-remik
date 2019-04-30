package com.infoshare.jjdd6.moviespotter.utils;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import info.talacha.filmweb.api.FilmwebApi;
import info.talacha.filmweb.search.models.FilmSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.inject.Inject;
import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.PublicKey;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Local
public class FilmWebBrowser {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private FilmwebApi filmwebApi = new FilmwebApi();

    @Inject
    ProgrammeDao programmeDao;

    public List<FilmSearchResult> findMoviesBriefInfo(int id) {

        Programme programme = programmeDao.findById(id);
        log.info("Analyzing: "+programme.toString());

        List<String> titles = new ArrayList<>();
        if (programme.getTitlePl() != null && !programme.getTitlePl().isEmpty())
        titles.add(programme.getTitlePl());

        if (programme.getTitleEn() != null && !programme.getTitleEn().isEmpty())
        titles.add(programme.getTitleEn());

        if (programme.getTitleXx() != null && !programme.getTitleXx().isEmpty())
        titles.add(programme.getTitleXx());

        log.info("Found titles: "+titles.toString());

        List<FilmSearchResult> output = new ArrayList<>();
        for (String title : titles) {
            output.addAll(filmwebApi.findFilm(title));
        }

        return output;
    }


/*
        try {

        Long fId = 449390L;

        Film film1 = fa.getFilmData(fId);

        System.out.println(film1.getVotes());

        List<Person> persons = fa.getPersons(fId, Profession.ACTOR, 0,5);

        for (Person person : persons) {
            System.out.println(person.getRole()+" - "+person.getName());

        }


    } catch (FilmwebException f) {
        System.out.println(f);
    }
}
}
*/
}
