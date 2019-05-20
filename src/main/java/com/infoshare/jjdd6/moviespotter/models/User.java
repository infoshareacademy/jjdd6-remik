package com.infoshare.jjdd6.moviespotter.models;

import com.sun.istack.Nullable;
import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "user_id", length = 16)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "name")
    private String Name;

    @Column(name = "surname")
    private String Surname;

    @Column(name = "onlyShowFavorites")
    private Boolean onlyShowFavorites;

    @Nullable
    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_TO_FAV_CHANNELS",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id", referencedColumnName = "channel_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Channel> channels;

    @ManyToMany//(mappedBy = "users", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<FavoriteMovie> movies = new ArrayList<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public Boolean getOnlyShowFavorites() {
        return onlyShowFavorites;
    }

    public void setOnlyShowFavorites(Boolean onlyShowFavorites) {
        this.onlyShowFavorites = onlyShowFavorites;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public List<FavoriteMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<FavoriteMovie> movies) {
        this.movies = movies;
    }
}
