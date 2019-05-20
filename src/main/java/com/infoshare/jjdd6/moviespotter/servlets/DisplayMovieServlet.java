package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.FavoriteMovieDao;
import com.infoshare.jjdd6.moviespotter.dao.UserDao;
import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;
import com.infoshare.jjdd6.moviespotter.models.FavoriteMovie;
import com.infoshare.jjdd6.moviespotter.models.User;
import com.infoshare.jjdd6.moviespotter.oAuth2.SessionInfo;
import com.infoshare.jjdd6.moviespotter.services.FilmWebBrowser;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import info.talacha.filmweb.models.Film;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@WebServlet("/programme/movie")
public class DisplayMovieServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private FilmWebBrowser filmWebBrowser;

    @Inject
    private FavoriteMovieDao favoriteMovieDao;

    @Inject
    private SessionInfo sessionInfo;

    @Inject
    private UserDao userDao;

    private static final Logger log = LoggerFactory.getLogger(DisplayMovieServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = (NumberUtils.toLong(request.getParameter("fwID"), 0));

        Map<String, Object> model = new HashMap<>();

        Film film = filmWebBrowser.getFilmInfo(id);

        if (film != null) {
            model.put("m_movie", film);
            model.put("m_persons", filmWebBrowser.getFilmPersons(id));
            model.put("fwID", id);
        }


        FavoriteMovie favoriteMovie = new FavoriteMovie();
        favoriteMovie.setFilmWebId(id);
        favoriteMovie.setPolishTitle(film.getPolishTitle());
        favoriteMovie.setTitle(film.getTitle());

        User user = userDao.findByLogin(sessionInfo.getUserName());

        if (user != null) {



            List<FavoriteMovie> userMovies = user.getMovies();
            if (userMovies != null || userMovies.isEmpty()) {
                favoriteMovie.getUsers().add(user);
                favoriteMovieDao.save(favoriteMovie);
                userMovies.add(favoriteMovie);
                userDao.save(user);
            }
        }

        Template template = templateProvider.getTemplate(getServletContext(), "movieDetails.ftlh");

        log.info("using freemarker template: " + template.getName());

        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            log.error("Error processing template: " + e);
        }
    }
}
