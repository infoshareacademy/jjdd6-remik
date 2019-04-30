package com.infoshare.jjdd6.moviespotter.freemarker;


import com.infoshare.jjdd6.moviespotter.utils.ConfigLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.io.IOException;

@RequestScoped
public class TemplateProvider {

    private Logger log = LoggerFactory.getLogger(TemplateProvider.class.getName());

    private final String TEMPLATES_DIRECTORY_PATH = "WEB-INF/fm-templates";

    private Configuration configuration;

    @Inject
    private ConfigProvider configProvider;

    public Template getTemplate(ServletContext servletContext, String templateName) throws IOException {

        log.info("templates path: " + TEMPLATES_DIRECTORY_PATH);

        configuration = configProvider.getConfiguration();
        configuration.setServletContextForTemplateLoading(servletContext, TEMPLATES_DIRECTORY_PATH);
        return configuration.getTemplate(templateName);
    }
}
