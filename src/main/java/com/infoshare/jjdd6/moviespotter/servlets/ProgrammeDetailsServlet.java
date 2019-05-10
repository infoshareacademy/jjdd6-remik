package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/programme/details"})
public class ProgrammeDetailsServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ProgrammeDetailsLogic programmeDetailsLogic;

    private static final Logger log = LoggerFactory.getLogger(ProgrammeDetailsServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = (NumberUtils.toInt(request.getParameter("id"), 0));

        log.info("GET: "+request.getParameterNames().toString());

        String title = request.getParameter("title");

        Map<String, Object> model = new HashMap<>();

        if (id > 0) {

            model = (programmeDetailsLogic.findMovieDetails(id));
        } else if (title != null && !title.isEmpty()) {

            model = programmeDetailsLogic.findMovieDetails(title);
        } else {
            response.sendRedirect("/error");
        }

        Template template = templateProvider.getTemplate(getServletContext(), "movieDetails.ftlh");

        try {

            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            log.error("Error processing template: " + e);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("POST: "+request.getParameter("title"));
        doGet(request, response);

    }
}
