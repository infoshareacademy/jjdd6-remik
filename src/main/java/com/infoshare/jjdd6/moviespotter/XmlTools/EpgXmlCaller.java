package com.infoshare.jjdd6.moviespotter.XmlTools;

import com.infoshare.jjdd6.moviespotter.services.ConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@RequestScoped
public class EpgXmlCaller {

    @Inject
    private ConfigLoader configLoader;

    @EJB
    private EpgXmlLoader epgXmlLoader;

    @EJB
    private EpgXmlParser epgXmlParser;

    private static final Logger log = LoggerFactory.getLogger(EpgXmlCaller.class.getName());

    public boolean parseXmlTvData() {

         String loadXml = configLoader.getProperties().getProperty("loadXml");
         Document doc = epgXmlLoader.loadEpgData();

        if (loadXml.equals("true") || loadXml.equals("yes")) {

            log.info("XML parser will try to call EpgXmlLoader.loadEpgData");

            new Thread(() -> {
                epgXmlParser.doParse(doc);
            }).start();
        }
        return true;
    }
}

