package com.infoshare.jjdd6.moviespotter.utils;

import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.sun.istack.Nullable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Max;
import java.util.*;
import java.util.stream.Collectors;


@RequestScoped
public class EpgDataFilters {

    @Inject
    EpgDataKeeper epgDataKeeper;

    private ArrayList<Programme> programsList = new ArrayList<>();

    public List<Programme> getMoviesByChannel(@Nullable List<Programme> programmes, String[] channel) {

        if (programmes == null) {
            programmes = epgDataKeeper.getAllPrograms();
        }

        return  programmes
                .stream()
                .filter(a -> Arrays.asList(channel).contains(a.getChannel()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
