package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.services.ChannelsList;
import com.infoshare.jjdd6.moviespotter.services.ProgrammeAllTitlesList;
import com.infoshare.jjdd6.moviespotter.services.StarRating;
import com.sun.istack.Nullable;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@RequestScoped
public class FindProgrammeLogic {

    @Inject
    ChannelsList channelsList;

    @Inject
    ProgrammeAllTitlesList programmeAllTitlesList;

    @Inject
    ProgrammeDao programmeDao;

    @Inject
    StarRating starRating;

    private Map<String, Object> model = new HashMap<>();

    private final static Logger log = LoggerFactory.getLogger(FindProgrammeLogic.class.getName());

    public Map<String, Object> searchProgramme(int tvItemInt) {

        List<String> progAllTitles = programmeAllTitlesList.getTitlesList(tvItemInt);
        model = findTvProgramme(progAllTitles, null);
        log.info("int parameter accepted");

        return model;
    }


    public Map<String, Object> searchProgramme(String tvItemString) {

        List<Programme> progsMatchingTitles = programmeDao.getByStringTitle(tvItemString);
        log.info("String parameter accepted. Got programmes list of items: "+progsMatchingTitles.size());
        model = findTvProgramme(null, progsMatchingTitles);

        return model;
    }

    private Map<String, Object> findTvProgramme(@Nullable List<String> progAllTitles, @Nullable List<Programme> progsMatchingTitles) {

        List<Programme> allTvItemOccurences = new ArrayList<>();

        if (progAllTitles != null) {
            allTvItemOccurences = programmeDao.getAllOccurences(progAllTitles);
        }
        if (progsMatchingTitles != null) {
            allTvItemOccurences = progsMatchingTitles;
        }

        List<Programme> allTvItemOccurencesSorted = allTvItemOccurences
                .stream()
                //.sorted((p1, p2) -> p1.getStart().compareTo(p2.getStart()))
                .sorted(Comparator.comparing(Programme::getStart))
                .collect(Collectors.toList());
        //.forEach(a-> a.setRating(starRating.toStars(a.getRating())));

        allTvItemOccurencesSorted.forEach(a -> a.setRating(starRating.toStars(a.getRating())));

        List<String> chList = channelsList.getAllNames();

        Map<String, Object> model = new HashMap<>();

        model.put("channels", chList);
        model.put("tvProgramme", allTvItemOccurencesSorted);

        return model;

    }

}
