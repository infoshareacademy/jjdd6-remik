package com.infoshare.jjdd6.moviespotter.services;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.sun.istack.Nullable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;


@RequestScoped
public class EpgDataFilters {

    @Inject
    ProgrammeDao programmeDao;


    //private ArrayList<Programme> programsList = new ArrayList<>();

    public List<Programme> getAllPrograms() {

        return null;
    }


    public List<Programme> getMoviesByChannel(@Nullable List<Programme> programmes, String[] channel) {

        if (programmes == null) {
            programmes = this.getAllPrograms();
        }

        return  programmes
                .stream()
                .filter(a -> Arrays.asList(channel).contains(a.getChannel()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
