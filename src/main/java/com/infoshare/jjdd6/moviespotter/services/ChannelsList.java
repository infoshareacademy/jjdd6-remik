package com.infoshare.jjdd6.moviespotter.services;

import com.infoshare.jjdd6.moviespotter.dao.ChannelDao;
import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Channel;
import com.infoshare.jjdd6.moviespotter.models.Programme;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Transactional
public class ChannelsList {

    @EJB
    private ProgrammeDao programmeDao;

    @EJB
    ChannelDao channelDao;


    public List<Channel> getAllNames() {

        return channelDao
                .findAll()
                .stream()
                .filter(a -> !a.getProgrammes().isEmpty())
                .sorted(Comparator.comparing(Channel::getName))
                .collect(Collectors.toList());
    }

    public List<Programme> programme1channel(String programmeName) {

        return programmeDao.findByName(programmeName);
    }
}
