package com.infoshare.jjdd6.moviespotter.models;

import java.util.HashMap;

public class Programme {

    String channel;
    String start;
    String stop;
    String titlePl;
    HashMap<String, String> otherTitles;
    String descPl;
    String categoryPl;
    String rating;
    int date;

    public Programme () {
        otherTitles = new HashMap<>();
    }

    public HashMap<String, String> getOtherTitles() {
        return otherTitles;
    }

    public void setOtherTitles(HashMap<String, String> otherTitles) {
        this.otherTitles = otherTitles;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getTitlePl() {
        return titlePl;
    }

    public void setTitlePl(String titlePl) {
        this.titlePl = titlePl;
    }

    public String getDescPl() {
        return descPl;
    }

    public void setDescPl(String descPl) {
        this.descPl = descPl;
    }

    public String getCategoryPl() {
        return categoryPl;
    }

    public void setCategoryPl(String categoryPl) {
        this.categoryPl = categoryPl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}




/*
<programme start="20190421112500 +0000" stop="20190421115500 +0000" channel="TVR.pl">
<title lang="pl">Inspektor Gadżet</title>
<desc lang="pl">Inspektor Gadżet z Interpolu poddał się operacji, w efekcie której został wyposażony w różne potrzebne mu urządzenia. Niestety, roztargniony inspektor często myli sterujące nimi guziki.</desc>
<date>1983</date>
<category lang="pl">Dla Dzieci</category>
<category lang="pl">Młodzieży</category>
<icon src="https://wp6-images-pl-dynamic.horizon.tv/Images/99521097.p.8b3a16dd29c71174331676231544326933168255.jpg"/>
<rating>
<value>6+</value>
</rating>
</programme>
*/