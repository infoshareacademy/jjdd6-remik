package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.Main;
import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.services.ChannelsList;
import com.infoshare.jjdd6.moviespotter.services.StarRating;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/programme/new", "/error"})
public class DisplayProgrammeServlet2 extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    @Inject
    ChannelsList channelsList;

    @Inject
    StarRating starRating;

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String channel  = request.getParameter("ch");

        List<String> chList = channelsList.getAllNames();

        Map<String, Object> model = new HashMap<>();

        model.put("channels" , chList);

        if (!chList.contains(channel)) {
            channel = chList.get(0);
        }

        List <Programme> tvProgramme = channelsList.programme1channel(channel);

        tvProgramme.forEach(a-> a.setRating(starRating.toStars(a.getRating())));

        model.put("tvProgramme", tvProgramme);

        log.info("programmes/model has entries: " + model.size());

        Template template = templateProvider.getTemplate(getServletContext(), "bs-main.ftlh");

        log.info("using freemarker template: " + template.getName());

        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            log.error("Error processing template: " + e);
        }
    }
}
