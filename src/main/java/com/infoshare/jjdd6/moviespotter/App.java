package com.infoshare.jjdd6.moviespotter;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.infoshare.jjdd6.moviespotter.utils.epgXmlLoader;
import com.infoshare.jjdd6.moviespotter.utils.ConfigLoader;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static java.lang.System.getProperty;
import static java.lang.System.lineSeparator;

public class App {

    public static void main(String[] args) {


        System.out.println("App is starting...");
        epgXmlLoader.loadEpgData();

    }

}
