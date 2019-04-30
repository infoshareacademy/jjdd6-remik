package com.infoshare.jjdd6.moviespotter.servlets;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.utils.FilmWebBrowser;
import org.apache.commons.lang3.math.NumberUtils;
import info.talacha.filmweb.search.models.FilmSearchResult;

@WebServlet("/programme/detail")
public class ProgrammeDetailsServlet extends HttpServlet {

    private NumberUtils numberUtils = new NumberUtils();

    @Inject
    ProgrammeDao programmeDao;

    @Inject
    FilmWebBrowser filmWebBrowser;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = (numberUtils.toInt(request.getParameter("id"), 0));

        Programme detailed = programmeDao.findById(id);
        response.getWriter().println(detailed.toString());



        List<FilmSearchResult> briefList = filmWebBrowser.findMoviesBriefInfo(id);

        for (FilmSearchResult filmSearchResult : briefList) {
            response.getWriter().println(
                    filmSearchResult.getTitle() + " " +
                            filmSearchResult.getAlternativeTitle() + " " +
                            filmSearchResult.getPolishTitle()+" "+
                    filmSearchResult.getId());
        }
    }
}
