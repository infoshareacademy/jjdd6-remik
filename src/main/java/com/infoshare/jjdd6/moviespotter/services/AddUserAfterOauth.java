package com.infoshare.jjdd6.moviespotter.services;

import com.infoshare.jjdd6.moviespotter.dao.UserDao;
import com.infoshare.jjdd6.moviespotter.models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AddUserAfterOauth {

    @Inject
    private UserDao userDao;

    public boolean addUser(String userName) {

        if (userDao.findByLogin(userName) == null){

            User user = new User();
            user.setLogin(userName);
            user.setOnlyShowFavorites(false);

            try {
                userDao.save(user);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
