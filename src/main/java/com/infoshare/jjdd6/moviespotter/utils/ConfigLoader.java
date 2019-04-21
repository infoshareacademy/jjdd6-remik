package com.infoshare.jjdd6.moviespotter.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class ConfigLoader {

    private Logger log = LoggerFactory.getLogger(getClass());
    public static Properties properties;

    public  void load() {

        log.info("Loading app config");

        try (InputStream input = new FileInputStream("./data/appConfig.properties")) {
            Properties props = new Properties();
            props.load(input);
            properties = props;
            log.debug(props.toString());

        } catch (Exception e) {
            log.error("File not loaded: "+ e);
        }
    }
}
