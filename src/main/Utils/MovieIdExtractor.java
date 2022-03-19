package main.Utils;

import main.Entities.Movie;

public class MovieIdExtractor implements MovieDataExtractor{

    @Override
    public int getData(Movie movie) {
        return movie.getID();
    }
    
}
