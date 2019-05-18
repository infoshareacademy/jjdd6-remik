package com.infoshare.jjdd6.moviespotter.oAuth2;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;
import com.infoshare.jjdd6.moviespotter.services.AddUserAfterOauth;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/programme/account/logout")
public class LogOutServlet extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(LogOutServlet.class.getName());

    @Inject
    TemplateProvider templateProvider;

    @Inject
    AddUserAfterOauth addUserAfterOauth;

    @Inject
    SessionInfo sessionInfo;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        sessionInfo.setUserName(null);
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/");
    }
}


