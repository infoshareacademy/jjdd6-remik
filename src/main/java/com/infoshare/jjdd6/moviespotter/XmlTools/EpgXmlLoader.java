package com.infoshare.jjdd6.moviespotter.XmlTools;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.infoshare.jjdd6.moviespotter.services.ConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import java.io.File;

@Stateless
public class EpgXmlLoader {

    @Inject
    private ConfigLoader configLoader;

    private static final Logger log = LoggerFactory.getLogger(EpgXmlLoader.class.getName());

    public Document loadEpgData() {

        log.info("Loading XML data file...");

        try {

            String epgXmlFile = configLoader.getProperties().getProperty("xmlfile");
            String appConfigPath = configLoader.getProperties().getProperty("dataPath");
            final String epgXmlPath = appConfigPath+"/"+epgXmlFile;

            File fXmlFile = new File(epgXmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            log.info("XML data loaded!");

            return doc;

        } catch (Exception e) {
            log.error("XML data not loaded: " + e);
            return null;
        }
    }
}


