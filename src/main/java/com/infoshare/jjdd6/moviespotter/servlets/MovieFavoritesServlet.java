package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.ChannelDao;
import com.infoshare.jjdd6.moviespotter.dao.FavoriteMovieDao;
import com.infoshare.jjdd6.moviespotter.dao.UserDao;
import com.infoshare.jjdd6.moviespotter.models.Channel;
import com.infoshare.jjdd6.moviespotter.models.FavoriteMovie;
import com.infoshare.jjdd6.moviespotter.models.User;
import com.infoshare.jjdd6.moviespotter.oAuth2.SessionInfo;
import com.infoshare.jjdd6.moviespotter.services.FilmWebBrowser;
import info.talacha.filmweb.models.Film;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Transactional
@WebServlet("/programme/movie/favorites")
public class MovieFavoritesServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(MovieFavoritesServlet.class.getName());

    @Inject
    private UserDao userDao;

    @Inject
    private FavoriteMovieDao favoriteMovieDao;

    @Inject
    private SessionInfo sessionInfo;

    @Inject
    private FilmWebBrowser filmWebBrowser;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String param = request.getParameter("favmov");
        final Long movieLong = NumberUtils.toLong(param, 0);

        log.info("favorite movie clicked: " + param);

        if (movieLong > 0) {

            Film film = filmWebBrowser.getFilmInfo(movieLong);

            User user = userDao.findByLogin(sessionInfo.getUserName());
            log.info(user.getLogin());

            List<FavoriteMovie> userMovies = user.getMovies();

            log.info("user " + user.getLogin() + " has " + userMovies.size());

            if ((userMovies
                    .stream()
                    .filter(a -> a.getFilmWebId().equals(movieLong))
                    .count() == 0

            )) {

                log.info("favorite movie not found, adding...");
                if (favoriteMovieDao.findByFwId(movieLong).isEmpty()) {
                    FavoriteMovie favoriteMovie = new FavoriteMovie();
                    favoriteMovie.setFilmWebId(movieLong);
                    favoriteMovie.setPolishTitle(film.getPolishTitle());
                    favoriteMovie.setTitle(film.getTitle());
                    favoriteMovie.setUrl(film.getWebsiteURL().toString());
                    favoriteMovie.setPoster(film.getPosterURL().toString());
                    favoriteMovieDao.save(favoriteMovie);

                }

                userMovies.add(favoriteMovieDao.findByFwId(movieLong).get(0));
                user.setMovies(userMovies);
                userDao.update(user);

            } else {
                log.info("removing movie from favorites");

                userMovies.remove(favoriteMovieDao.findByFwId(movieLong).get(0));
                Iterator itr = userMovies.iterator();
                while (itr.hasNext()) {
                    FavoriteMovie m = (FavoriteMovie)itr.next();
                    if (m.getFilmWebId().equals(movieLong)) {
                        itr.remove();
                        user.setMovies(userMovies);
                        userDao.update(user);
                    }
                }
            }
        } else {
            response.sendRedirect("/error");
        }
    }
}
