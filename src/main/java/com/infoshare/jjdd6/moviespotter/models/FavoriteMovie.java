package com.infoshare.jjdd6.moviespotter.models;

import com.sun.istack.Nullable;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.ejb.Stateful;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USER_TO_FAV_MOVIES")
public class FavoriteMovie {

    @Id
    @Column(name = "favorite_id", length = 16)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "filmweb_id", length = 128)
    private Long filmWebId;

    @Column(name = "polishTitle", length = 128)
    private String polishTitle;

    @Column(name = "title")
    private String title;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_TO_FAV_MOVIES",
            joinColumns = @JoinColumn(name = "favorite_id", referencedColumnName = "favorite_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users = new ArrayList<>();

    public FavoriteMovie(Long filmWebId, String polishTitle, String title, List<User> users) {
        this.filmWebId = filmWebId;
        this.polishTitle = polishTitle;
        this.title = title;
        this.users = users;
    }

    public FavoriteMovie() {
    }

    public String getPolishTitle() {
        return polishTitle;
    }

    public void setPolishTitle(String polishTitle) {
        this.polishTitle = polishTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Long getFilmWebId() {
        return filmWebId;
    }

    public void setFilmWebId(Long filmWebId) {
        this.filmWebId = filmWebId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
