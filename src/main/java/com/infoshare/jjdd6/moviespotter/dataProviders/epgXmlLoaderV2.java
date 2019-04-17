package com.infoshare.jjdd6.moviespotter.dataProviders;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;


public class epgXmlLoaderV2 {

    public static void loader() {
    //Load
    File f = new File ("./data/c7fc-iqa746.xml");
    Properties properties = new Properties();
        try {
            properties.load(new FileReader(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Retrieve data
    String parameterName = "parameter1";
    String property1 = properties.getProperty(parameterName);

    }

    @Root (name = "tv")
    public class tv {
        @Attribute
        public String channel;

    }




    public static void main(String[] args) {

        loader();
    }
}
