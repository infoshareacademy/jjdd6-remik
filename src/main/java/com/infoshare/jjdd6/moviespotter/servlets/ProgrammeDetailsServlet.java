package com.infoshare.jjdd6.moviespotter.servlets;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.services.FilmWebBrowser;
import com.infoshare.jjdd6.moviespotter.services.ProgrammeAllTitlesList;
import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import info.talacha.filmweb.models.Film;
import org.apache.commons.lang3.math.NumberUtils;
import info.talacha.filmweb.search.models.FilmSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = {"/programme"})
public class ProgrammeDetailsServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ProgrammeDetailsLogic programmeDetailsLogic;

    private static final Logger log = LoggerFactory.getLogger(ProgrammeDetailsServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = (NumberUtils.toInt(request.getParameter("id"), 0));


        Map<String, Object> model = new HashMap<>();

        if (id > 0) {

            try {
                model = (programmeDetailsLogic.findMovieDetais(id));
                Template template = templateProvider.getTemplate(getServletContext(), "movieDetails.ftlh");
                template.process(model, response.getWriter());
            } catch (TemplateException e) {
                log.error("Error processing template: " + e);
            }

        } else {
            response.sendRedirect("/programme/error");
        }
    }
}
