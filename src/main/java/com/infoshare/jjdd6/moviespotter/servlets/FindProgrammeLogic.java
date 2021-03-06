package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Channel;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.oAuth2.SessionInfo;
import com.infoshare.jjdd6.moviespotter.services.ChannelsList;
import com.infoshare.jjdd6.moviespotter.services.ProgrammeAllTitlesList;
import com.infoshare.jjdd6.moviespotter.services.StarRating;
import com.sun.istack.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@RequestScoped
public class    FindProgrammeLogic {

    @Inject
    private ChannelsList channelsList;

    @Inject
    private ProgrammeAllTitlesList programmeAllTitlesList;

    @Inject
    private ProgrammeDao programmeDao;

    @Inject
    private StarRating starRating;

    @Inject
    FavoritesListOfUser favoritesListOfUser;

    @Inject
    SessionInfo sessionInfo;

    private Map<String, Object> model = new HashMap<>();

    private final static Logger log = LoggerFactory.getLogger(FindProgrammeLogic.class.getName());

    public Map<String, Object> searchProgramme(int tvItemInt) {

        List<String> progAllTitles = programmeAllTitlesList.getTitlesList(tvItemInt);
        model = findTvProgramme(progAllTitles, null);
        log.info("int parameter accepted");

        return model;
    }

    public Map<String, Object> searchProgramme() {
        model = findTvProgramme(null, null);
        return model;
    }

    public Map<String, Object> searchProgramme(String tvItemString) {

        List<Programme> progsMatchingTitles = programmeDao.getByStringTitle(tvItemString);
        log.info("String parameter accepted. Got programmes list of items: "+progsMatchingTitles.size());

        if (progsMatchingTitles.isEmpty()) {

            model = findTvProgramme(null, null);
        }
        else {
            model = findTvProgramme(null, progsMatchingTitles);
        }

        return model;
    }

    private Map<String, Object> findTvProgramme(@Nullable List<String> progAllTitles, @Nullable List<Programme> progsMatchingTitles) {

        List<Programme> allTvItemOccurences = new ArrayList<>();

        if (progAllTitles != null) {
            allTvItemOccurences = programmeDao.getAllOccurences(progAllTitles);
        } else if (progsMatchingTitles != null) {
            allTvItemOccurences = progsMatchingTitles;
        } else {
            Channel  channel = new Channel();
            Programme programmeNotFound = new Programme();
            programmeNotFound.setChannel(channel);
            programmeNotFound.getChannel().setName(":-(");
            programmeNotFound.setDescPl("Niestety, wyszukiwanie nie przyniosło resultatów - w aktualnym programie brak pasującej pozycji.");
            allTvItemOccurences.add(programmeNotFound);
        }

        List<Programme> allTvItemOccurencesSorted = allTvItemOccurences
                .stream()
                .sorted(Comparator.comparing(Programme::getStart))
                .collect(Collectors.toList());

        allTvItemOccurencesSorted.forEach(a -> a.setRating(starRating.toStars(a.getRating())));

        List<Channel> chList = channelsList.getAllNames();

        Map<String, Object> model = new HashMap<>();



        model.put("channels", chList);
        model.put("tvProgramme", allTvItemOccurencesSorted);
        model.put("usersFavorites", favoritesListOfUser.getFavoriteChannels(sessionInfo.getUserName()));

        return model;
    }
}
