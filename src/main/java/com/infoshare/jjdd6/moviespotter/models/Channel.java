package com.infoshare.jjdd6.moviespotter.models;


import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "CHANNELS")
public class Channel {

    @Id
    @Column(name = "channel_id", length = 16)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull
    @Column(name = "name", length = 48)
    private String name;

    @Column(name = "iconURL", length = 128)
    private String iconUrl;

    @Column(name = "displayCounter")
    private int displayCounter;

    @OneToMany(mappedBy = "channel", fetch = FetchType.LAZY)
    private List<Programme> programmes;

    @OneToMany(mappedBy = "channels", fetch = FetchType.LAZY)
    private List<User> users;

    public Channel() {
    }

    public Channel(String name, String iconUrl) {
        this.name = name;
        this.iconUrl = iconUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public List<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getDisplayCounter() {
        return displayCounter;
    }

    public void setDisplayCounter(int displayCounter) {
        this.displayCounter = displayCounter;
    }
}
