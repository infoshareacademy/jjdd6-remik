package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.services.FilmWebBrowser;
import com.infoshare.jjdd6.moviespotter.services.ProgrammeAllTitlesList;
import info.talacha.filmweb.models.Film;
import info.talacha.filmweb.search.models.FilmSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestScoped
public class ProgrammeDetailsLogic {

    @Inject
    private ProgrammeDao programmeDao;

    @Inject
    private FilmWebBrowser filmWebBrowser;

    @Inject
    private ProgrammeAllTitlesList programmeAllTitlesList;

    private Map<String, Object> model = new HashMap<>();
    private  List<FilmSearchResult> briefList;

    private static final Logger log = LoggerFactory.getLogger(ProgrammeDetailsLogic.class.getName());


    Map<String, Object> findMovieDetails(String title) {

    briefList = filmWebBrowser.findMoviesBriefInfo(title);
    log.info("title:" +title+" list size:"+briefList.size());
    model.put("movies", briefList);
    return model;

        }

    Map<String, Object> findMovieDetails(int id) {

        Programme detailed = programmeDao.findById(id);

        List<String> allTitles = (programmeAllTitlesList.getTitlesList(id));

        briefList = filmWebBrowser.findMoviesBriefInfo(id);

        Map<String, Object> model = new HashMap<>();

        for (FilmSearchResult filmSearchResult : briefList) {

            for (String allTitle : allTitles) {

                if ((allTitle.equalsIgnoreCase(filmSearchResult.getTitle())
                        || allTitle.equalsIgnoreCase(filmSearchResult.getPolishTitle())
                        || allTitle.equalsIgnoreCase(filmSearchResult.getAlternativeTitle()))
                        && detailed.getDate() == filmSearchResult.getYear()
                ) {
                    Film film = filmWebBrowser.getFilmInfo(filmSearchResult.getId());

                    if (film != null) {
                        model.put("m_movie", film);
                        model.put("m_persons", filmWebBrowser.getFilmPersons(filmSearchResult.getId()));
                        break;
                    }
                }
            }
        }

        model.put("movies", briefList);
        return model;
    }
}