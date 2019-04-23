package com.infoshare.jjdd6.moviespotter;

import com.infoshare.jjdd6.moviespotter.dao.WatchListEntryDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.models.WatchListEntry;
import com.infoshare.jjdd6.moviespotter.utils.ConfigLoader;
import com.infoshare.jjdd6.moviespotter.utils.EpgDateConverter;
import com.infoshare.jjdd6.moviespotter.utils.EpgXmlParser;
import com.infoshare.jjdd6.moviespotter.viewers.FilmWebApiCaller;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class App {


    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(App.class.getName());

        System.setProperty("log4j.configurationFile","./data/log4j.properties");
        BasicConfigurator.configure();

        log.info("App is starting...preparing configuration");

        ConfigLoader configLoader = new ConfigLoader();
        configLoader.load();

        log.info("Configuration OK. calling parser for data object");
        EpgXmlParser epgXmlParser = new EpgXmlParser();

        List <Programme> programme = epgXmlParser.parseXmlTvData();


        for (Programme programme1 : programme) {

            if ((programme1.getTitleXx() != null || programme1.getTitleEn()!=null)) {
                System.out.println(programme1);
            } else System.out.println(programme1);
        }




       // FilmWebApiCaller filmWebApiCaller = new FilmWebApiCaller();
        //filmWebApiCaller.TestFilmweb();

      //  EpgDateConverter epgDateConverter = new EpgDateConverter();
       // epgDateConverter.ToLocalDateTime("20190416033000 +0330");
    }

}
