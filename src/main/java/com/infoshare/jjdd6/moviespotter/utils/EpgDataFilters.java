package com.infoshare.jjdd6.moviespotter.utils;

import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.sun.istack.Nullable;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class EgpDataFiters {

    @Inject
    EpgDataKeeper epgDataKeeper;

    private ArrayList<Programme> programsList = new ArrayList<>();

    public List<Programme> getMoviesByChannel(@Nullable List<Programme> programmes, String channel) {

        if (programmes == null) {
            programmes = epgDataKeeper.getAllPrograms();
        }

        return  programmes
                .stream()
                .filter(a -> a.getChannel().equals(channel))
                .collect(Collectors.toCollection(ArrayList::new));
    }


}
