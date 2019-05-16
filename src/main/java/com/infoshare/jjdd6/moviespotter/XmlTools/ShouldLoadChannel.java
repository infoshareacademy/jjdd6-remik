package com.infoshare.jjdd6.moviespotter.XmlTools;

import com.infoshare.jjdd6.moviespotter.services.ConfigLoader;

import javax.inject.Inject;

class ShouldLoadChannel {

    @Inject
    private ConfigLoader configLoader;

    boolean checkShouldBeLoaded(String channelName) {

        String ignore = configLoader.getProperties().getProperty("Ignore");
        String onlyLoad = configLoader.getProperties().getProperty("OnlyLoad");

        if ((ignore != null && ignore.contains(channelName))
                || (onlyLoad != null)
                && !onlyLoad.contains(channelName)) {
            return true;
        } else {
            return false;
        }
    }
}
