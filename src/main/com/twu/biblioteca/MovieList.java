package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MovieList {

    private List<Movie> movieList = new ArrayList<>();

    public MovieList() {
        Movie darkCrystal = new Movie("The Dark Crystal", "1982", "Jim Henson", "8/10", "REF01");
        Movie MIB = new Movie("Men in Black", "1997", "Barry Sonnenfeld", "7/10", "REF02");

        movieList.add(darkCrystal);
        movieList.add(MIB);
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
