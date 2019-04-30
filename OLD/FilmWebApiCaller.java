/*
Using: https://bitbucket.org/varabi/filmweb-api
 */

package com.infoshare.jjdd6.moviespotter.viewers;

import info.talacha.filmweb.api.FilmwebApi;
import info.talacha.filmweb.connection.FilmwebException;
import info.talacha.filmweb.models.Film;
import info.talacha.filmweb.models.Person;
import info.talacha.filmweb.models.Profession;
import info.talacha.filmweb.search.models.FilmSearchResult;

import java.util.List;

public class FilmWebApiCaller {

    public void TestFilmweb() {


        FilmwebApi fa = new FilmwebApi();

        List<FilmSearchResult> list = fa.findFilm("Skazani na shawshenk");


        for (FilmSearchResult filmSearchResult : list) {
            System.out.println(filmSearchResult.getPolishTitle() + " " + filmSearchResult.getAlternativeTitle() + " " + filmSearchResult.getTitle() + " " + filmSearchResult.getId());

        }


        try {

            Long fId = 449390L;

            Film film1 = fa.getFilmData(fId);

            System.out.println(film1.getVotes());

            List<Person> persons = fa.getPersons(fId, Profession.ACTOR, 0,5);

            for (Person person : persons) {
                System.out.println(person.getRole()+" - "+person.getName());

            }


        } catch (FilmwebException f) {
            System.out.println(f);
        }
    }
}
