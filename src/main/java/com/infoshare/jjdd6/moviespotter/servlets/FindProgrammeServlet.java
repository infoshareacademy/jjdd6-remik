package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.services.ChannelsList;
import com.infoshare.jjdd6.moviespotter.services.ConfigLoader;
import com.infoshare.jjdd6.moviespotter.services.ProgrammeAllTitlesList;

import com.infoshare.jjdd6.moviespotter.services.StarRating;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.math.NumberUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/programme/find"})
public class FindProgrammeServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    @Inject
    FindProgrammeLogic findProgrammeLogic;

    private Map<String, Object> model = new HashMap<>();

    private final static Logger log = LoggerFactory.getLogger(FindProgrammeServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tvItemStr = request.getParameter("tvItem");

        int tvItemInt = NumberUtils.toInt(tvItemStr, -1);

        if (tvItemInt >-1) {
            model = findProgrammeLogic.searchProgramme(tvItemInt);
            log.info("Numeric parameter "+tvItemStr+": searching by list option");
        } else {
            model = findProgrammeLogic.searchProgramme(tvItemStr);
            log.info("String-like parameter "+tvItemStr+": searching by form");
        }

        log.info("programmes/model has entries: " + model.size());

        Template template = templateProvider.getTemplate(getServletContext(), "findProgramme.ftlh");

        log.info("using freemarker template: " + template.getName());

        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            log.error("Error processing template: " + e);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}

