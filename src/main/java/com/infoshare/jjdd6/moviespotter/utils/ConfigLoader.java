package com.infoshare.jjdd6.moviespotter.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class ConfigLoader {

    public static Properties getInstance() {

        try (InputStream input = new FileInputStream("./config.properties")) {
            Properties props = new Properties();
            props.load(input);
            return props;

        } catch (Exception e) {
            //todo: logger
            return null;
        }
    }
}
