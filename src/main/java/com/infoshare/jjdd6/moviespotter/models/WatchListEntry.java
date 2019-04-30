package com.infoshare.jjdd6.moviespotter.models;

import javax.persistence.*;

@Entity
@Table(name = "WATCH_LIST_ENTRY")
public class WatchListEntry {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titlePl")
    private String titlePl;

    @Column(name = "titleEn")
    private String titleEn;

    @Column(name = "titleXx")
    private String titleXx;

    @Column(name = "year")
    private int year;


    public WatchListEntry() {
    }

    public Long getId() {
        return id;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
