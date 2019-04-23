package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.utils.ConfigLoader;
import com.infoshare.jjdd6.moviespotter.utils.EpgXmlParser;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ConfigLoader configLoader = new ConfigLoader();
        configLoader.load();

        EpgXmlParser epgXmlParser = new EpgXmlParser();

        List<Programme> programme = epgXmlParser.parseXmlTvData();

        for (Programme programme1 : programme) {
            if ((programme1.getTitleXx() != null || programme1.getTitleEn() != null)) {
                response.getWriter().write(programme1.toString());
            } else System.out.println(programme1);
        }
    }
}
