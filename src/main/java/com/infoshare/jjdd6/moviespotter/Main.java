package com.infoshare.jjdd6.moviespotter;

import com.infoshare.jjdd6.moviespotter.services.EpgXmlParser;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.inject.Inject;

@Startup
@Lock(LockType.READ)
@Singleton
public class Main {

    Logger log = LoggerFactory.getLogger(Main.class.getName());

    @Inject
    EpgXmlParser epgXmlParser;

    @PostConstruct




         void startUp(){

            System.setProperty("log4j.configurationFile", "./data/log4j.properties");
            BasicConfigurator.configure();

            log.info("Calling epgXmlParser.");
            epgXmlParser.parseXmlTvData();

        }



}
