package com.infoshare.jjdd6.moviespotter.models;

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
    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String Name;

    @Column(name = "surname")
    private String Surname;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_TO_FAV_CHANNELS",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id", referencedColumnName = "channel_id"))// COURSES
    private List<Channel> channels;

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

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }
}
