package com.infoshare.jjdd6.moviespotter;

import info.talacha.filmweb.api.FilmwebApi;

public class Test {

    static FilmwebApi filmwebApi = new FilmwebApi();

    public static void main(String[] args) {

        filmwebApi.findFilm("Gorączka").forEach(a -> System.out.println( a.getTitle()));
    }
}
