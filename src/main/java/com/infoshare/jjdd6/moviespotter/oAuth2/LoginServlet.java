package com.infoshare.jjdd6.moviespotter.oAuth2;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;
import com.infoshare.jjdd6.moviespotter.servlets.FindProgrammeServlet;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/movieSpotter/login")
public class LoginServlet extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(LoginServlet.class.getName());

    @Inject
    TemplateProvider templateProvider;

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

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", name);
            resp.sendRedirect("/");

            //            req.getServletContext()
//                    .getRequestDispatcher("/").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

