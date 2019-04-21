package com.infoshare.jjdd6.moviespotter;

import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.utils.ConfigLoader;
import com.infoshare.jjdd6.moviespotter.utils.EpgDateConverter;
import com.infoshare.jjdd6.moviespotter.utils.EpgXmlParser;
import com.infoshare.jjdd6.moviespotter.viewers.FilmWebApiCaller;
import org.apache.log4j.BasicConfigurator;


import java.util.List;

public class App {

    public static void main(String[] args) {

        System.setProperty("log4j.configurationFile","./data/log4j.properties");
        BasicConfigurator.configure();

        System.out.println("App is starting...");

        ConfigLoader configLoader = new ConfigLoader();
        configLoader.load();

        EpgXmlParser epgXmlParser = new EpgXmlParser();

        List <Programme> programme = epgXmlParser.parseXmlTvData();

        System.out.println(programme.size());


        for (Programme programme1 : programme) {

            if ((programme1.getTitleXx() != null || programme1.getTitleEn()!=null)) {
                System.out.println(programme1);
            } //else System.out.println(programme1);
        }


       // FilmWebApiCaller filmWebApiCaller = new FilmWebApiCaller();
        //filmWebApiCaller.TestFilmweb();

      //  EpgDateConverter epgDateConverter = new EpgDateConverter();
       // epgDateConverter.ToLocalDateTime("20190416033000 +0330");
    }

}
