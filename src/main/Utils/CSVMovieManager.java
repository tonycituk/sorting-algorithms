package main.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.Entities.Movie;

/**
 * Class to load/write data from/a Movie.csv
 * 
 * @author tonycituk
 * @author FerMendezA
 */
public class CSVMovieManager {

    /**
     * Path to reach the CSV
     */
    private String pathToCSV;

    /**
     * Array to store the movies
     */
    public Movie movies[];

    /**
     * 
     * @param pathToCSV path to the CSV file to read movies from
     */
    public CSVMovieManager(String pathToCSV) {
        this.pathToCSV = pathToCSV;
    }

    /**
     * 
     * loads data from the CSV to a movie's array
     * 
     * @param lines total lines to read
     * @throws NumberFormatException
     * @throws IOException
     * @throws ExcepcionDynamicList
     */
    public void loadData(int lines) throws NumberFormatException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(pathToCSV))) {
            String linea = "";
            this.movies = new Movie[lines];
            int i = 0;
            br.readLine(); // Discard titles
            while ((linea = br.readLine()) != null && i < lines) {
                String[] fields = linea.split(",");
                this.completeFields(fields);
                Movie movie = this.fieldsToMovie(fields);
                this.movies[i] = movie;
                i++;
            }
        }
    }

    /**
     * Utility function for {@link main.Utils.CSVMovieManager#loadData(int)}
     * 
     * @param fields String array to be fulfiilled with 0's on empty arrays
     */
    private void completeFields(String[] fields) {
        for (int j = 0; j < fields.length; j++) {
            if (fields[j].equals("")) {
                fields[j] = "0";
            }
        }
    }

    /**
     * Utility function for {@link main.Utils.CSVMovieManager#loadData(int)}
     * 
     * @param fields String array containing specific fields order of movie
     * @return movie instance
     */
    private Movie fieldsToMovie(String[] fields) {
        return new Movie(Integer.parseInt(
                fields[0]),
                fields[1],
                Integer.parseInt(fields[2]),
                Integer.parseInt(fields[7]),
                Float.parseFloat(fields[9]));
    }

    public void testQuicksort() throws Exception {
        
    }

    public Movie[] getMovies() {
        return this.movies;
    }

    public void writeToCSVFromArray(String path, String nombre) throws FileNotFoundException {
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[] { "movie_id", "movie_title", "movie_duration", "movie_budget", "movie_rate" });

        for (Movie xMovie : movies) {
            dataLines.add(new String[] { String.valueOf(xMovie.getID()), xMovie.getTitle(),
                    String.valueOf(xMovie.getDuration()),
                    String.valueOf(xMovie.getBudget()), String.valueOf(xMovie.getRate()) });
        }

        File csvOutputFile = new File(path + nombre);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }

    /**
     * Helper to convert a String array to a comma separated string.
     * 
     * @param data
     * @return Comma separated string.
     */
    private String convertToCSV(String[] data) {
        return Stream.of(data)
                .collect(Collectors.joining(","));
    }

    /**
     * Writes the movie LL to a CSV
     * 
     * @param path Path to store the file at
     * @throws ExcepcionDynamicList
     * @throws FileNotFoundException
     */
    /*
     * public void writeToCSV(String path) throws ExcepcionDynamicList,
     * FileNotFoundException {
     * List<String[]> dataLines = new ArrayList<>();
     * dataLines.add(new String[] { "movie_title", "movie_duration", "movie_budget",
     * "movie_rate" });
     * 
     * while (this.moviesLL.getSize() > 0) {
     * Movie xMovie = this.moviesLL.deleteFirst().getDato();
     * dataLines.add(new String[] { xMovie.getTitle(),
     * String.valueOf(xMovie.getDuration()),
     * String.valueOf(xMovie.getBudget()), String.valueOf(xMovie.getRate()) });
     * }
     * 
     * File csvOutputFile = new File(path);
     * try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
     * dataLines.stream()
     * .map(this::convertToCSV)
     * .forEach(pw::println);
     * }
     * }
     * 
     * 
     */
}
