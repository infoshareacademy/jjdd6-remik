package com.infoshare.jjdd6.moviespotter.models;

import javax.persistence.*;
import java.util.List;

@Entity(name="USERS_TO_FAV_MOVIES")
public class FavoriteMovie {

    @Id
    @Column(name = "filmweb_id", length = 32)
    private Long filmWebId;

    @OneToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<User> users;

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
