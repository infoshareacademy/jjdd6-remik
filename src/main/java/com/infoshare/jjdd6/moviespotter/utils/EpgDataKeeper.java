package com.infoshare.jjdd6.moviespotter.utils;

import com.infoshare.jjdd6.moviespotter.models.Programme;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class EpgDataKeeper {

    @Inject
    EpgXmlParser epgXmlParser;

    private  ArrayList<Programme> programsList = new ArrayList<>();

    public List<Programme> getAllPrograms() {

        if (programsList == null || programsList.isEmpty()) {
            programsList =  epgXmlParser.parseXmlTvData();
        }
        return programsList;
    }
}
