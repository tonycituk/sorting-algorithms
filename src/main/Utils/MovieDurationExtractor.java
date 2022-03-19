package main.Utils;
import main.Entities.Movie;

public class MovieDurationExtractor implements MovieDataExtractor{

    @Override
    public int getData(Movie movie) {
        // TODO Auto-generated method stub
        return movie.getDuration();
    }
    
}
