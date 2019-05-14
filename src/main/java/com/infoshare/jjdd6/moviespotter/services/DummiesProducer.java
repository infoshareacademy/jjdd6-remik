package com.infoshare.jjdd6.moviespotter.services;

import com.infoshare.jjdd6.moviespotter.models.Channel;
import com.infoshare.jjdd6.moviespotter.models.Programme;

public class DummiesProducer {

    public static Programme produceProgramme() {

        Programme programmeNotFound = new Programme();
        programmeNotFound.setTitlePl(":-(");
        programmeNotFound.setDescPl("Niestety, wyszukiwanie nie przyniosło resultatów. Może pora na ciastko? Albo lody...");

        return programmeNotFound;
    }

    public static Channel produceChannel() {
        Channel channel = new Channel();
        channel.setName(":-(");

        return  channel;
    }
}
