package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.Main;
import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.dao.UserDao;
import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;
import com.infoshare.jjdd6.moviespotter.models.Channel;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.models.User;
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
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/programme/new", "/error"})
public class DisplayProgrammeServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private ChannelsList channelsList;

    @Inject
    private StarRating starRating;

    @Inject
    private UserDao userDao;

    @Inject
    private FavoritesListOfUser favoritesListOfUser;

    private static Logger log = LoggerFactory.getLogger(DisplayProgrammeServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String channel = request.getParameter("ch");
        String channelAlt = channel;

        log.info("Channel passed in parameter ch="+channelAlt);

        List<Channel> chList = channelsList.getAllNames();
        Map<String, Object> model = new HashMap<>();
        model.put("channels", chList);

        channelAlt = (
                chList
                        .stream()
                        .filter(a -> a.getName().equals(channel))
                        .findFirst().orElse(chList.get(0))
        )
                .getName();

        List<Programme> tvProgramme = channelsList.programme1channel(channelAlt);

        tvProgramme
                .forEach(a -> a.setRating(starRating.toStars(a.getRating())));


        model.put("tvProgramme", tvProgramme);

        log.info("programmes/model has entries: " + model.size());

        model.put("usersFavorites", favoritesListOfUser.getFavoriteChannels());


        Template template = templateProvider.getTemplate(getServletContext(), "bs-main.ftlh");

        log.info("using freemarker template: " + template.getName());

        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            log.error("Error processing template: " + e);
        }
    }
}
