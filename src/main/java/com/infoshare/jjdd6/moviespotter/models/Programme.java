package com.infoshare.jjdd6.moviespotter.models;


public class Programme {

    private String channel;
    private String start;
    private String stop;
    private String titlePl;
    private String titleEn;
    private String titleXx;
    private String subtitlePl;
    private String descPl;
    private String categoriesPl;
    private String director;
    private String actor;
    private String rating;
    private String episodeXmlNs;
    private String country;
    private int date;

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

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleXx() {
        return titleXx;
    }

    public void setTitleXx(String titleXx) {
        this.titleXx = titleXx;
    }

    public String getSubtitlePl() {
        return subtitlePl;
    }

    public void setSubtitlePl(String subtitlePl) {
        this.subtitlePl = subtitlePl;
    }

    public String getDescPl() {
        return descPl;
    }

    public void setDescPl(String descPl) {
        this.descPl = descPl;
    }

    public String getCategoriesPl() {
        return categoriesPl;
    }

    public void setCategoriesPl(String categoriesPl) {
        this.categoriesPl = categoriesPl;
    }

    public void addCategoryPl(String category) {
        if (categoriesPl == null) categoriesPl = category;
        else categoriesPl=categoriesPl + ", " + category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void addDirector(String director) {
        if (director != null && this.director == null) this.director = director;
        else this.director = this.director+", "+director;
    }
    
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void addActor(String actor) {
        if (actor != null && this.actor == null) this.actor = actor;
        else this.actor = this.actor+", "+actor;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getEpisodeXmlNs() {
        return episodeXmlNs;
    }

    public void setEpisodeXmlNs(String episodeXmlNs) {
        this.episodeXmlNs = episodeXmlNs;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addCountry(String country) {
        if (country != null && this.country == null) this.country = country;
        else this.country = this.country + ", " + country;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("channel=").append(channel);
        //sb.append(", start='").append(start).append('\'');
        //sb.append(", stop='").append(stop).append('\'');
        sb.append(", titles='").append(titlePl).append('\'').append(titleEn).append('\'').append(titleXx).append('\'');
        sb.append(", subtitlePl=").append(subtitlePl).append('\'');
        sb.append(", director=").append(director).append('\'');
        //sb.append(", actor=").append(actor).append('\'');
        //sb.append(", descPl=").append(descPl).append('\'');\
        sb.append(", cat:").append(categoriesPl).append('\'');
        sb.append(", date:").append(date).append('\'');
        sb.append(", ep:").append(episodeXmlNs).append('\'');
        sb.append(", country:").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}