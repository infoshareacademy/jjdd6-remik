package com.infoshare.jjdd6.moviespotter.services;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ChannelsList {

    @Inject
    private ProgrammeDao programmeDao;

    public List<String> getAllNames() {

        return programmeDao
                .getAllProgrammes()
                .stream()
                .map(a -> a.getChannel().getName())
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Programme> programme1channel(String programmeName) {

        return programmeDao
                .getAllProgrammes()
                .stream()
                .filter(a -> a.getChannel().getName().equalsIgnoreCase(programmeName))
                .collect(Collectors.toList());
    }
}
