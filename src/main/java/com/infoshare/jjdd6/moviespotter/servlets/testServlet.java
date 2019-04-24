package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.utils.EpgXmlParser;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/testServlet")
public class testServlet extends HttpServlet {

    @Inject
    EpgXmlParser epgXmlParser;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Programme> programme = epgXmlParser.parseXmlTvData();
        PrintWriter writer = response.getWriter();

        for (Programme programme1 : programme) {
            if ((programme1.getTitleXx() != null || programme1.getTitleEn() != null)) {
                writer.println(programme1.toString());
            } else writer.println(programme1.toString());
        }
    }
}
