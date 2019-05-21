package com.infoshare.jjdd6.moviespotter.models;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity(name = "FAVORITE_MOVIES")
public class FavoriteMovie {

    @Id
    @Column(name = "id", length = 12)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "filmweb_id", length = 32, unique = true)
    private Long filmWebId;

    @Column(name = "polishTitle", length = 256)
    private String polishTitle;

    @Column(name = "title", length = 256)
    private String title;

    @Column(name = "movieUrl")
    private String url;

    @Column(name = "moviePoster")
    private String poster;


    @ManyToMany(mappedBy = "favoriteMovies", fetch = FetchType.LAZY)
    private List<User> users;

    public FavoriteMovie(Long filmWebId, String polishTitle, String title, List<User> users, String url) {
        this.filmWebId = filmWebId;
        this.polishTitle = polishTitle;
        this.title = title;
        this.users = users;
        this.url = url;
    }

    public FavoriteMovie() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
