package com.infoshare.jjdd6.moviespotter;

import com.infoshare.jjdd6.moviespotter.dao.UserDao;
import com.infoshare.jjdd6.moviespotter.models.User;
import com.infoshare.jjdd6.moviespotter.services.ConfigLoader;
import com.infoshare.jjdd6.moviespotter.XmlTools.EpgXmlCaller;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class.getName());

    public static String mockedUser = "anyrem";

    @Inject
    private EpgXmlCaller epgXmlCaller;

    @Inject
    private ConfigLoader configLoader;

    @Inject
    UserDao userDao;

    @PostConstruct
    public void startUp() {

        System.setProperty("log4j.configurationFile", configLoader.getProperties().getProperty("dataPath"));
        BasicConfigurator.configure();

        try {
            User anyrem = new User();
            anyrem.setLogin("anyrem");
            userDao.save(anyrem);
        } catch (Exception e){
        }

        log.info("Calling epgXmlParser.");
        epgXmlCaller.parseXmlTvData();
    }
}
