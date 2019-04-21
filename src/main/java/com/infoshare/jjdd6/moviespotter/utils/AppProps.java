package com.infoshare.jjdd6.moviespotter.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class AppProps {

    public static void main (String [] args) {
        try (OutputStream output = new FileOutputStream("appConfig.properties")) {


            Properties props = new Properties();
            props.setProperty("Ignored","FoodNetwork");
            props.store(output, null);

        }
        catch (Exception e) {

        }
    }
}
