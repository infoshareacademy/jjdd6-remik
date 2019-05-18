package com.infoshare.jjdd6.moviespotter.oAuth2;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@SessionScoped

public class SessionInfo implements Serializable {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }
}

