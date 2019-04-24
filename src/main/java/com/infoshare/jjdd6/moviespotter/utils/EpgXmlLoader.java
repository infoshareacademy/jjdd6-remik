package com.infoshare.jjdd6.moviespotter.utils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import java.io.File;

@RequestScoped
class EpgXmlLoader {

    @Inject
    ConfigLoader configLoader;

    Logger log = LoggerFactory.getLogger(EpgXmlLoader.class.getName());

    protected Document loadEpgData() {


        log.info("Loading XML data file...");

        try {
            String epgXmpPath = configLoader.getProperties().getProperty("xmlpath");
            File fXmlFile = new File(epgXmpPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            log.info("XML data loaded!");

            return doc;

        } catch (Exception e) {
            e.printStackTrace();
            log.error("XML data not loaded: "+e);
            return null;
        }
    }
}


