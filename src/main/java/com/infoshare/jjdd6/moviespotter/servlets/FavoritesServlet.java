package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.Main;
import com.infoshare.jjdd6.moviespotter.dao.ChannelDao;
import com.infoshare.jjdd6.moviespotter.dao.UserDao;
import com.infoshare.jjdd6.moviespotter.models.Channel;
import com.infoshare.jjdd6.moviespotter.models.User;
import com.infoshare.jjdd6.moviespotter.services.ConfigLoader;
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
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/programme/favorites")
public class FavoritesServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(FavoritesServlet.class.getName());

    @Inject
    UserDao userDao;
    @Inject
    ChannelDao channelDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String channel = request.getParameter("favchan");
        final int channelInt = NumberUtils.toInt(channel, 0);

        log.info("favorite channel clicked: " + channel);

        if (channelInt > 0) {

            HttpSession session = request.getSession();
            User user = userDao.findByLogin(session.getAttribute("userName").toString()).orElse(null);
            log.info(user.getLogin());

            List<Channel> userList = user.getChannels()
                    .stream()
                    .sorted(Comparator.comparing(Channel::getId))
                    .collect(Collectors.toList());

            log.info("user "+user.getLogin()+" has "+userList.size());

            if ((userList
                    .stream()
                    .filter(a -> a.getId() == channelInt)
                    .collect(Collectors.toList())
            ).isEmpty()) {

                userList.add(channelDao.findById(channelInt));

            } else {

                Iterator itr = userList.iterator();
                while (itr.hasNext()) {
                    Channel c = (Channel)itr.next();
                    if (c.getId() == channelInt)
                        itr.remove();
                }
            }

            user.setChannels(userList);
            userDao.update(user);

        } else {

            response.sendRedirect("/error");
        }
    }
}
