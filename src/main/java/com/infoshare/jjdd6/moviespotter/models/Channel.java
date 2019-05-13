package com.infoshare.jjdd6.moviespotter.models;


import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Entity
@Table(name = "CHANNELS")
public class Channel {

    @Id
    @Column(name = "channel_id", length = 16)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull
    @Column(name = "name", length = 48, unique = true)
    String name;

    @Column(name = "iconURL", length = 128)
    String iconUrl;

    @OneToMany(mappedBy = "channel", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Programme> programmes;


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
}
