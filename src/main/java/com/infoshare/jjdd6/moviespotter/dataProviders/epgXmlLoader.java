package com.infoshare.jjdd6.moviespotter.dataProviders;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.infoshare.jjdd6.moviespotter.models.Programme;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.*;

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

        ArrayList<Programme> tvProgramme = new ArrayList<>();

        for (int i =0 ; i < channelsList.getLength(); i++) {

            Node node = channelsList.item(i);
            Programme programme = new Programme();

            //node.getAttributes().getNamedItem("channel").toString();

            programme.setChannel(node.getAttributes().getNamedItem("channel").getNodeValue());
            programme.setStart(node.getAttributes().getNamedItem("start").getNodeValue());
            programme.setStart(node.getAttributes().getNamedItem("stop").getNodeValue());

            tvProgramme.add(programme);
        }



    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        loadEpgData();
    }
}


