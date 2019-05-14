package com.infoshare.jjdd6.moviespotter.services;

import javax.enterprise.context.RequestScoped;
import org.apache.commons.lang3.math.NumberUtils;

@RequestScoped
public class StarRating {

    public String toStars(String strRate) {

        int rate = NumberUtils.toInt(strRate, -1);
        String strStars="";

        if (rate > -1) {
            for (int i = 0; i < 5; i++) {
                if (i<rate) {
                    strStars+="★";
                } else {
                    strStars+="☆";
                }
            }
        }
        return strStars;
    }
}
