package com.infoshare.jjdd6.moviespotter.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
public class ConfigLoader {

    private Logger log = LoggerFactory.getLogger(getClass());

    //JAVA_OPTS="-DmovieSpotter.config=/home/dx/INFOSHARE/movieSpotter/data/appConfig.properties"
    private Properties sysProps = System.getProperties();
    private final String appConfigPath = sysProps.getProperty("movieSpotter.config");

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
