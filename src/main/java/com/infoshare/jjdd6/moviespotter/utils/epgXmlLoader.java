package com.infoshare.jjdd6.moviespotter.utils;

import javax.swing.text.AsyncBoxView;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import org.apache.commons.lang3.math.NumberUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

public class epgXmlLoader {

    public static void loadEpgData() {

        Properties AppConfig = ConfigLoader.getInstance();

        String epgXmpPath = AppConfig.getProperty("xmlpath");

        try {

            File fXmlFile = new File(epgXmpPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            String ignore = AppConfig.getProperty("Ignore");

            String onlyLoad = AppConfig.getProperty("OnlyLoad");

            NodeList channelsList = doc.getDocumentElement().getElementsByTagName("programme");

            ArrayList<Programme> tvProgrammes = new ArrayList<>();

            for (int i = 0; i < channelsList.getLength(); i++) {

                Node node = channelsList.item(i);
                Programme programme = new Programme();

                String channelName = node.getAttributes().getNamedItem("channel").getNodeValue();

                if (ignore.contains(channelName) || (onlyLoad != null) && !onlyLoad.contains(channelName)) {
                    continue;
                }

                programme.setChannel(channelName);
                programme.setStart(node.getAttributes().getNamedItem("start").getNodeValue());
                programme.setStop(node.getAttributes().getNamedItem("stop").getNodeValue());

                NodeList childnodes = node.getChildNodes();

                for (int j = 0; j < childnodes.getLength(); j++) {

                    Node child = childnodes.item(j);

                    if (child.getNodeName().equalsIgnoreCase("title")) {

                        if (child.getAttributes().getNamedItem("lang").getNodeValue().equals("pl") && programme.getTitlePl() == null) {
                            programme.setTitlePl(child.getTextContent());
                        } else if (child.getAttributes().getNamedItem("lang").getNodeValue().equals("en") && programme.getTitleEn() == null) {
                            programme.setTitleEn(child.getTextContent());
                        } else if (child.getAttributes().getNamedItem("lang").getNodeValue().equals("xx") && programme.getTitleXx() == null) {
                            programme.setTitleXx(child.getTextContent());
                        } else {
                            //TODO: logger!
                        }
                    }
                    if (child.getNodeName().equalsIgnoreCase("sub-title")) {
                        if (child.getAttributes().getNamedItem("lang").getNodeValue().equals("pl") && programme.getSubtitlePl() == null) {
                            programme.setSubtitlePl(child.getTextContent());
                        } else {
                            //TODO: logger!
                        }
                    }
                    if (child.getNodeName().equalsIgnoreCase("desc")) {
                        if (child.getAttributes().getNamedItem("lang").getNodeValue().equals("pl") && programme.getDescPl() == null) {
                            programme.setDescPl(child.getTextContent());
                        } else {
                            //TODO: logger!
                        }
                    }

                    if (child.getNodeName().equalsIgnoreCase("credits")) {
                        for (int k = 0; k < child.getChildNodes().getLength(); k++) {
                            if (child.getChildNodes().item(k).getNodeName().equalsIgnoreCase("director"))
                                programme.setDirector(child.getChildNodes().item(k).getTextContent());
                            if (child.getChildNodes().item(k).getNodeName().equalsIgnoreCase("actor"))
                                programme.addActor(child.getChildNodes().item(k).getTextContent());
                        }
                    }

                    if (child.getNodeName().equalsIgnoreCase("date")) {
                        if (NumberUtils.isDigits(child.getTextContent()))
                            programme.setDate(Integer.parseInt(child.getTextContent()));
                    }

                    if (child.getNodeName().equalsIgnoreCase("category")) {
                            programme.addCategoryPl(child.getTextContent());
                    }

                    if (child.getNodeName().equalsIgnoreCase("episode-num")) {

                        if (child.getAttributes().getNamedItem("system").getNodeValue().equals("xmltv_ns")) {
                            programme.setEpisodeXmlNs(child.getTextContent());
                        } else {
                            //todo: loggers
                        }
                    }

                }
                System.out.println(programme.toString());
                tvProgrammes.add(programme);
            }

        } catch (Exception e) {
            e.printStackTrace();
            //todo logger
        }
    }
}


