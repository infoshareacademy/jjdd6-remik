package com.infoshare.jjdd6.moviespotter.oAuth2;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;
import com.infoshare.jjdd6.moviespotter.services.AddUserAfterOauth;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/programme/account")
public class LoginServlet extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(LoginServlet.class.getName());

    @Inject
    TemplateProvider templateProvider;

    @Inject
    AddUserAfterOauth addUserAfterOauth;

    @Inject
    SessionInfo sessionInfo;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("userName") == null) {

            Template template = templateProvider.getTemplate(getServletContext(), "login.ftlh");

            log.info("using freemarker template: " + template.getName());

            Map<String,Object> model = new HashMap<>();

            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                log.error("Error processing template: " + e);
            }
        } else {

            Template template = templateProvider.getTemplate(getServletContext(), "logout.ftlh");

            log.info("using freemarker template: " + template.getName());

            Map<String,Object> model = new HashMap<>();

            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                log.error("Error processing template: " + e);
            }
        }
    }


    @Override
    protected void doPost (HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);

            boolean tmp = addUserAfterOauth.addUser(name);
            log.info("User created: "+tmp);

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", name);

            sessionInfo.setUserName(name);

            resp.sendRedirect("/");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

