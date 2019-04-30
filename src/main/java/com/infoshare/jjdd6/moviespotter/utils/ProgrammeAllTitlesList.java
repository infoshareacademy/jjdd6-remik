package com.infoshare.jjdd6.moviespotter.utils;

import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
import com.infoshare.jjdd6.moviespotter.models.Programme;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ProgrammeAllTitlesList {

    @Inject
    ProgrammeDao programmeDao;

    public List<String> getTitlesList (int id) {

        Programme detailed = programmeDao.findById(id);

        if (detailed != null) {
            List<String> detailedTitles = new ArrayList<>();

            if (detailed.getTitlePl() != null)
                detailedTitles.add(detailed.getTitlePl());

            if (detailed.getTitleEn() != null)
                detailedTitles.add(detailed.getTitleEn());

            if (detailed.getTitleXx() != null)
                detailedTitles.add(detailed.getTitleXx());

            return detailedTitles;
        } else
            return null;
    }
}
