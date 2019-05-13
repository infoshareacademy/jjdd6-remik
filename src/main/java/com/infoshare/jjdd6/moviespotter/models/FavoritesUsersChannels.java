//package com.infoshare.jjdd6.moviespotter.models;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Table(name = "FAVORITES_USERS_CHANNELS")
//public class FavoritesUsersChannels {
//
//    @Id
//    @Column(name = "id", length = 16)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @NotNull
//    @Column(name="userId", length = 16)
//    private int userId;
//
//    @NotNull
//    @Column(name="userId", length = 16)
//    private int channelId;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public int getChannelId() {
//        return channelId;
//    }
//
//    public void setChannelId(int channelId) {
//        this.channelId = channelId;
//    }
//}
