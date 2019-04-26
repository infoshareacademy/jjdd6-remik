/*
package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet ("/programme")
public class displayTvProgramme {

    @Inject
    TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idParam = request.getParameter("id");
        PrintWriter writer = request.getWriter();

        if (idParam == null || idParam.isEmpty()) {
            request.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }




        Template template = templateProvider.getTemplate(getServletContext(), "find-user-by-id.ftlh");
        Map<String, Object> model = new HashMap<>();

        if (userById != null) {

            Double pulse = 0.0;
            if (Gender.WOMAN.equals(userById.getGender())) {
                pulse = maxPulseBean.getWomanPulse(userById.getAge());
            } else if (Gender.MAN.equals(userById.getGender())) {
                pulse = maxPulseBean.getManMaxPulse(userById.getAge());
            }

            model.put("user", userById);
            model.put("pulse", pulse);

        } else {
            model.put("errorMessage", "User has not been found.");
        }

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }

    }

}
*/