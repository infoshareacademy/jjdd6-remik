package com.infoshare.jjdd6.moviespotter.services;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ChannelsList {

    @Inject
    ProgrammeDao programmeDao;

    public List<String> getAllNames() {
        return
                programmeDao
                        .getAllProgrammes()
                        .stream()
                        .map(a -> a.getChannel())
                        .sorted()
                        .distinct()
                        .collect(Collectors.toList());
    }
}
