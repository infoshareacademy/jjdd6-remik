package com.infoshare.jjdd6.moviespotter.utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class epgXmlLoader {

   public static void loadEpgData() {

    try {

        File fXmlFile = new File("./data/c7fc-iqa746.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        System.out.println("----------------------------");

        NodeList channelsList=doc.getDocumentElement().getElementsByTagName("programme");

        ArrayList<Programme> tvProgrammes = new ArrayList<>();

        for (int i =0 ; i < channelsList.getLength(); i++) {
        //for (int i =0 ; i < 5; i++) {

            Node node = channelsList.item(i);
            Programme programme = new Programme();

            //node.getAttributes().getNamedItem("channel").toString();

            programme.setChannel(node.getAttributes().getNamedItem("channel").getNodeValue());
            programme.setStart(node.getAttributes().getNamedItem("start").getNodeValue());
            programme.setStart(node.getAttributes().getNamedItem("stop").getNodeValue());

                NodeList childnodes = node.getChildNodes();
                for (int j = 0; j < childnodes.getLength(); j++) {

                    Node child = childnodes.item(j);

                    if (child.getNodeName().matches("title") &&
                            child.getAttributes().getNamedItem("lang").getNodeValue().equals("pl") &&
                            programme.getTitlePl() == null) {
                        programme.setTitlePl(child.getTextContent());

                    } else if (child.getNodeName().matches("title") && !child.getAttributes().getNamedItem("lang").getNodeValue().isEmpty()) {
                        programme.getOtherTitles().put(child.getAttributes().getNamedItem("lang").getNodeValue(), child.getTextContent());
                    }

                    //System.out.println(programme.getOtherTitles().values());
                }


            tvProgrammes.add(programme);

            
        }




    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        loadEpgData();
    }
}


