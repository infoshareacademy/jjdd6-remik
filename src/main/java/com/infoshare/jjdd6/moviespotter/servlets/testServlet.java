package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.WatchListEntryDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.models.WatchListEntry;
import com.infoshare.jjdd6.moviespotter.utils.EpgDataFilters;
import com.infoshare.jjdd6.moviespotter.utils.EpgDataKeeper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/testServlet")
public class testServlet extends HttpServlet {

    @Inject
    EpgDataKeeper epgDataKeeper;

    @Inject
    EpgDataFilters egpDataFilters;

    @Inject
    WatchListEntryDao watchListEntryDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Programme> programme = egpDataFilters.getMoviesByChannel(null,request.getParameterValues("channel"));

        for (Programme programme1 : programme) {
            if ((programme1.getTitleXx() != null || programme1.getTitleEn() != null)) {
                response.getWriter().println(programme1.toString());
            } else response.getWriter().println(programme1.toString());
        }

        WatchListEntry w = new WatchListEntry();
        w.setTitleEn("TitleEng");
        w.setTitlePl("TitlePl");
        w.setTitleXx("TitleXx");
        watchListEntryDao.save(w);
    }
}
