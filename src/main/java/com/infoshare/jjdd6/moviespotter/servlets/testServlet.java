package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/testServlet")
public class testServlet extends HttpServlet {


@Inject
    ProgrammeDao programmeDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Programme> programme = programmeDao.findByChannelAndDate(request.getParameter("channel"),null,null);

        //response.getWriter().println(programme.toString());


        for (Programme programme1 : programme) {
            if ((programme1.getTitleXx() != null || programme1.getTitleEn() != null)) {
                response.getWriter().println(programme1.toString());
            } else response.getWriter().println(programme1.toString());

        }
    }
}
