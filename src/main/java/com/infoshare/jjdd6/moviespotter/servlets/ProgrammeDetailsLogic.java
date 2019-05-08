package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.services.FilmWebBrowser;
import com.infoshare.jjdd6.moviespotter.services.ProgrammeAllTitlesList;
import info.talacha.filmweb.models.Film;
import info.talacha.filmweb.search.models.FilmSearchResult;

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


    Map<String, Object> findMovieDetais(int id) {

        Programme detailed = programmeDao.findById(id);

        List<String> allTitles = (programmeAllTitlesList.getTitlesList(id));

        List<FilmSearchResult> briefList = filmWebBrowser.findMoviesBriefInfo(id);

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