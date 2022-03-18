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
import main.Entitities.Movie;
import main.QuickSort;


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
     * Linked List to store the movies
     */
    public Movie movies[];

    private ArrayList<Movie> moviesAL;
    private ArrayList<ReporteQuicksort> reporteQS;


    /**
     * 
     * @param pathToCSV path to the CSV file to read movies from
     */
    public CSVMovieManager(String pathToCSV) {
        
        this.pathToCSV = pathToCSV;
        this.moviesAL = new ArrayList<Movie>();

        this.reporteQS = new ArrayList<ReporteQuicksort>();
    }

    /**
     * 
     * loads data from the CSV in Crescent order using the title as reference also
     * runs some LinkedList methods for homework purposes
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
            br.readLine();
            while ((linea = br.readLine()) != null && i < lines) {
                String[] datos = linea.split(",");

                for (int j = 0; j < datos.length; j++) {
                    if (datos[j].equals("")) {
                        datos[j] = "0";
                    }
                }

                Movie movie = new Movie(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[7]),
                        Float.parseFloat(datos[9]));
                //this.moviesLL.insertCrescent(movie);

                this.movies[i] = movie;
                this.moviesAL.add(movie);
                // usr.imprimirInfo(); //Eliminar después
                System.out.println("Se cargó : " + getMovie()[i].toString());
                i++;
                
            }
            this.movies = moviesAL.toArray(new Movie[0]);

            
        }
    }

    public void testQuicksort() throws Exception{
        QuickSort q = new QuickSort();
            int lenght = movies.length;
            System.out.println("Length : " + lenght);


            //SE ORDENAN POR DURACION DE MENOR A MAYOR

            long startTime = System.nanoTime();
            //q.quickSortDurationCrescent(movies, 0, lenght-1);
            q.quicksort(movies, 0, lenght-1, "duration", "crescent");
            long endTime = System.nanoTime();
            Long processTime = (endTime-startTime);
            q.printArr(movies, lenght);
            System.out.println("Tiempo de ordenamiento por duracion : " + processTime);
            q.printMetricas();
            reporteQS.add(new ReporteQuicksort("Duración menor a mayor" , q.getMetricas(), processTime.toString()));
            System.out.println(reporteQS.get(0).toString());
            q.resetMetricas();

            //Escritura en el CSV
            writeToCSVFromArray("C:/Users/fer98/Desktop/JAVA VS CODE/", "QuicksortMovieDuraciónCreciente");

            System.out.println("------------------------------------------------------------------");

            //SE ORDENAN POR DURACION DE MAYOR A MENOR

            startTime = System.nanoTime();
            //q.quickSortDurationCrescent(movies, 0, lenght-1);
            q.quicksort(movies, 0, lenght-1, "duration", "decrescent");
            endTime = System.nanoTime();
            processTime = (endTime - startTime);
            q.printArr(movies, lenght);
            reporteQS.add(new ReporteQuicksort("Duración mayor a menor" , q.getMetricas(), processTime.toString()));
            System.out.println(reporteQS.get(1).toString());
            System.out.println("Tiempo de ordenamiento por duracion : " + (endTime-startTime));
            q.printMetricas();
            q.resetMetricas();

            //Escritura en el CSV
            writeToCSVFromArray("C:/Users/fer98/Desktop/JAVA VS CODE/", "QuicksortMovieDuraciónDecreciente");

            System.out.println("------------------------------------------------------------------");

            //SE ORDENAN POR PRESUPUESTO DE MENOR A MAYOR

            startTime = System.nanoTime();
            //q.quickSortDurationCrescent(movies, 0, lenght-1);
            q.quicksort(movies, 0, lenght-1, "budget", "crescent");
            endTime = System.nanoTime();
            processTime = (endTime - startTime);
            q.printArr(movies, lenght);
            reporteQS.add(new ReporteQuicksort("Presupuesto menor a mayor" , q.getMetricas(), processTime.toString()));
            System.out.println(reporteQS.get(2).toString());
            System.out.println("Tiempo de ordenamiento por presupuesto: " + (endTime-startTime));
            q.printMetricas();
            q.resetMetricas();

            //Escritura en el CSV
            writeToCSVFromArray("C:/Users/fer98/Desktop/JAVA VS CODE/", "QuicksortMoviePresupuestoCreciente");

            System.out.println("------------------------------------------------------------------");

            //SE ORDENAN POR PRESUPUESTO DE MAYOR A MENOR

            startTime = System.nanoTime();
            //q.quickSortDurationCrescent(movies, 0, lenght-1);
            q.quicksort(movies, 0, lenght-1, "budget", "decrescent");
            endTime = System.nanoTime();
            processTime = (endTime - startTime);
            q.printArr(movies, lenght);
            reporteQS.add(new ReporteQuicksort("Presupuesto mayor a menor" , q.getMetricas(), processTime.toString()));
            System.out.println(reporteQS.get(3).toString());
            System.out.println("Tiempo de ordenamiento por presupuesto : " + (endTime-startTime));
            q.printMetricas();
            q.resetMetricas();

            //Escritura en el CSV
            writeToCSVFromArray("C:/Users/fer98/Desktop/JAVA VS CODE/", "QuicksortMoviePresupuestoDecreciente");

            System.out.println("------------------------------------------------------------------");

            //SE ORDENAN POR RATE DE MENOR A MAYOR

            startTime = System.nanoTime();
            //q.quickSortDurationCrescent(movies, 0, lenght-1);
            q.quicksort(movies, 0, lenght-1, "rate", "crescent");
            endTime = System.nanoTime();
            processTime = (endTime - startTime);
            q.printArr(movies, lenght);
            reporteQS.add(new ReporteQuicksort("Rate menor a mayor" , q.getMetricas(), processTime.toString()));
            System.out.println(reporteQS.get(4).toString());
            System.out.println("Tiempo de ordenamiento por rate: " + (endTime-startTime));

            q.printMetricas();
            q.resetMetricas();

            //Escritura en el CSV
            writeToCSVFromArray("C:/Users/fer98/Desktop/JAVA VS CODE/", "QuicksortMovieRateCreciente");

            System.out.println("------------------------------------------------------------------");

            //SE ORDENAN POR RATE DE MAYOR A MENOR

            startTime = System.nanoTime();
            //q.quickSortDurationCrescent(movies, 0, lenght-1);
            q.quicksort(movies, 0, lenght-1, "rate", "decrescent");
            endTime = System.nanoTime();
            processTime = (endTime - startTime);
            q.printArr(movies, lenght);
            reporteQS.add(new ReporteQuicksort("Rate mayor a menor" , q.getMetricas(), processTime.toString()));
            System.out.println(reporteQS.get(5).toString());
            System.out.println("Tiempo de ordenamiento por rate : " + (endTime-startTime));

            q.printMetricas();
            q.resetMetricas();

            writeToCSVFromArray("C:/Users/fer98/Desktop/JAVA VS CODE/", "QuicksortMovieRateDecreciente");

            System.out.println("------------------------------------------------------------------");

            //SE ORDENAN POR TITULO DE MENOR A MAYOR 

            startTime = System.nanoTime();
            //q.quickSortDurationCrescent(movies, 0, lenght-1);
            //q.quicksortCrescent(movies, 0, lenght-1, "title");
            q.quicksort(movies, 0, lenght-1, "TITLE", "crescent");
            endTime = System.nanoTime();
            processTime = (endTime - startTime);
            q.printArr(movies, lenght);
            reporteQS.add(new ReporteQuicksort("Título menor a mayor" , q.getMetricas(), processTime.toString()));
            System.out.println(reporteQS.get(6).toString());
            System.out.println("Tiempo de ordenamiento por título: " + (endTime-startTime));

            q.printMetricas();
            q.resetMetricas();

            writeToCSVFromArray("C:/Users/fer98/Desktop/JAVA VS CODE/", "QuicksortMovieAlfabeticoCreciente");

            System.out.println("------------------------------------------------------------------");
            //SE ORDENAN POR TITULO DE MAYOR A MENOR

            startTime = System.nanoTime();
            //q.quickSortDurationCrescent(movies, 0, lenght-1);
            q.quicksort(movies, 0, lenght-1, "TITLE", "decrescent");
            endTime = System.nanoTime();
            processTime = (endTime - startTime);
            q.printArr(movies, lenght);
            reporteQS.add(new ReporteQuicksort("Título mayor a menor" , q.getMetricas(), processTime.toString()));
            System.out.println(reporteQS.get(7).toString());
            System.out.println("Tiempo de ordenamiento por titulo : " + (endTime-startTime));

            q.printMetricas();
            q.resetMetricas();

            System.out.println("------------------------------------------------------------------");

            System.out.println("ULTIMA MOVIE : " + movies[99].toString());

            //ESCRITURA EN EL CSV
            writeToCSVFromArray("C:/Users/fer98/Desktop/JAVA VS CODE/", "QuicksortMovieAlfabeticoDecreciente");

            //Escritura en el TXT
            writeToTXTFromArray("C:/Users/fer98/Desktop/JAVA VS CODE/", "MetricasQuicksort");

            q.printMetricas();
            q.resetMetricas();
    }

    public Movie[] getMovie(){
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

    

    public void writeToTXTFromArray(String path, String nombre) throws FileNotFoundException {
        List<String> dataLines = new ArrayList<>();
        dataLines.add("MÉTRICAS QUICKSORT");

        for (ReporteQuicksort xReporte : reporteQS) {
            dataLines.add(xReporte.toString());
            System.out.println(dataLines);
        }

        File txtOutputFile = new File(path + nombre);
        try (PrintWriter pw = new PrintWriter(txtOutputFile)) {
            dataLines.stream()
                    .map(this::convertToTXT).forEach(pw::println);;
            
        }
    }

    private String convertToTXT(String data) {
        return data;
    }


    /**
     * Writes the movie LL to a CSV
     * 
     * @param path Path to store the file at
     * @throws ExcepcionDynamicList
     * @throws FileNotFoundException
     */
    /*
    public void writeToCSV(String path) throws ExcepcionDynamicList, FileNotFoundException {
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[] { "movie_title", "movie_duration", "movie_budget", "movie_rate" });

        while (this.moviesLL.getSize() > 0) {
            Movie xMovie = this.moviesLL.deleteFirst().getDato();
            dataLines.add(new String[] { xMovie.getTitle(), String.valueOf(xMovie.getDuration()),
                    String.valueOf(xMovie.getBudget()), String.valueOf(xMovie.getRate()) });
        }

        File csvOutputFile = new File(path);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }


    */
}
