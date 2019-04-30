package com.infoshare.jjdd6.moviespotter.freemarker;


import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConfigProvider {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private Configuration configuration;

    public Configuration getConfiguration() {

        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            configuration.setLogTemplateExceptions(false);
            configuration.setWrapUncheckedExceptions(true);
        }
        log.info("Freemarker config " + configuration.getDefaultEncoding());
        return configuration;
    }
}
