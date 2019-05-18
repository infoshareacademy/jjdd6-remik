package com.infoshare.jjdd6.moviespotter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@Singleton
public class ConfigLoader {

    private static final Logger log = LoggerFactory.getLogger(ConfigLoader.class.getName());
    private String appConfigPath = System.getProperty("user.home")+"/MovieSpotter_data/appConfig.properties";
    private Properties properties;

    public Properties getProperties() {

        log.debug("asked for configuration");
        if (properties == null) {
            properties = load();
        }
        return properties;
    }

    private Properties load() {

        try (InputStream input = new FileInputStream(appConfigPath)) {
            Properties props = new Properties();
            props.load(input);
            props.setProperty("dataPath", System.getProperty("user.home")+"/MovieSpotter_data/");
            log.debug("Loaded config: " + props.toString());
            return props;

        } catch (Exception e) {
            log.error("config not loaded: " + e);
            return null;
        }
    }
}