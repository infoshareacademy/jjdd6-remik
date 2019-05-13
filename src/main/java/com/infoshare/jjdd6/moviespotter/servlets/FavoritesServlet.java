package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.ChannelDao;
import com.infoshare.jjdd6.moviespotter.dao.UserDao;
import com.infoshare.jjdd6.moviespotter.models.Channel;
import com.infoshare.jjdd6.moviespotter.models.User;
import com.infoshare.jjdd6.moviespotter.services.ConfigLoader;
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
import java.util.List;


@WebServlet("/programme/favorites")
public class FavoritesServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(FavoritesServlet.class.getName());

    @Inject
    UserDao userDao;
    @Inject
    ChannelDao channelDao;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String channel = request.getParameter("channel");
        log.info("favorite channel clicked: "+channel);


        User user = userDao.findByLogin("anyrem").orElse(null);
        List<Channel> userList = user.getChannels();
        userList.add(channelDao.findById(Integer.parseInt(channel)));
        user.setChannels(userList);
        userDao.update(user);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
