package com.infoshare.jjdd6.moviespotter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
public class ConfigLoader {

    private Logger log = LoggerFactory.getLogger(getClass());
    private final String appConfigPath = "/home/anyrem/IdeaProjects/jjdd6-remik/data/appConfig.properties";

    private Properties properties;

    public Properties getProperties() {

        log.info("asked for configuration");
        if (properties == null) {
            properties = load();
        }
        return properties;
    }


    private Properties load() {

        try (InputStream input = new FileInputStream(appConfigPath)) {
            Properties props = new Properties();
            props.load(input);
            log.debug("Loaded config: " + props.toString());
            return props;

        } catch (Exception e) {
            log.error("config not loaded: " + e);
            return null;
        }
    }
}
