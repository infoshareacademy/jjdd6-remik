package com.infoshare.jjdd6.moviespotter.models;

import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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



    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_TO_FAV_CHANNELS",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id", referencedColumnName = "channel_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Channel> channels;

    @ManyToMany()//(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_TO_FAV_MOVIES",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<FavoriteMovie> favoriteMovies;

    public User() {
    }

    public User(@NotNull String login, String name, String surname, Boolean onlyShowFavorites, List<Channel> channels, List<FavoriteMovie> favoriteMovies) {
        this.login = login;
        Name = name;
        Surname = surname;
        this.onlyShowFavorites = onlyShowFavorites;
        this.channels = channels;
        this.favoriteMovies = favoriteMovies;
    }

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
        return favoriteMovies;
    }

    public void setMovies(List<FavoriteMovie> movies) {
        this.favoriteMovies = movies;
    }
}
