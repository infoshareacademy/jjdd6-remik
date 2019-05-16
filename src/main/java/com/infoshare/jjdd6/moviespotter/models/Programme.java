package com.infoshare.jjdd6.moviespotter.models;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Stateful
@Transactional
@Entity
@Table(name = "PROGRAMMES")
public class Programme {

    @Id
    @Column(name = "id", length = 32)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "channel_id")
    Channel channel;

    @Column(name = "start")
    private LocalDateTime start;

    @Column(name = "stop")
    private LocalDateTime stop;

    @Column(name = "titlePl")
    private String titlePl;

    @Column(name = "titleEn")
    private String titleEn;

    @Column(name = "titleXx")
    private String titleXx;

    @Column(name = "subtitlePl")
    private String subtitlePl;

    @Column(name = "descPl", length = 2048)
    private String descPl;

    @Column(name = "categoriesPl", length = 4096)
    private String categoriesPl;

    @Column(name = "director")
    private String director;

    @Column(name = "actor", length = 4096)
    private String actor;

    @Column(name = "rating")
    private String rating;

    @Column(name = "episodeXmlNs")
    private String episodeXmlNs;

    @Column(name = "country")
    private String country;

    @Column(name = "date")
    private int date;

    @NotNull
    @Unique
    @Column(name = "hash", unique = true)
    private int hash;


    public Programme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getStop() {
        return stop;
    }

    public void setStop(LocalDateTime stop) {
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
        if (categoriesPl == null) {
            categoriesPl = category;
        } else {
            categoriesPl = categoriesPl + " " + category;
        }
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void addDirector(String director) {
        if (director != null && this.director == null) {
            this.director = director;
        } else {
            this.director = this.director + ", " + director;
        }
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void addActor(String actor) {
        if (actor != null && this.actor == null) {
            this.actor = actor;
        } else {
            this.actor = this.actor + ", " + actor;
        }
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
        if (country != null && this.country == null) {
            this.country = country;
        } else {
            this.country = this.country + ", " + country;
        }
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("channel=").append(channel);
        sb.append(", start='").append(start).append('\'');
        sb.append(", stop='").append(stop).append('\'');
        sb.append(", titles='").append(titlePl).append('\'').append(titleEn).append('\'').append(titleXx).append('\'');
        sb.append(", subtitlePl=").append(subtitlePl).append('\'');
        sb.append(", country:").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}