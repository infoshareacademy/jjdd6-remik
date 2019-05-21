package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.Main;
import com.infoshare.jjdd6.moviespotter.dao.UserDao;
import com.infoshare.jjdd6.moviespotter.models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class FavoritesListOfUser {

    @Inject
    private UserDao userDao;

        public List<Integer> getFavoriteChannels(String login) {

        User loggedUser = userDao.findByLogin(login);

        if (loggedUser != null) {
            return loggedUser
                    .getChannels()
                    .stream()
                    .map(a -> a.getId())
                    .sorted()
                    .collect(Collectors.toList());
        }
        else return null;
    }
}
