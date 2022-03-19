package test;

import java.io.FileNotFoundException;
import java.io.IOException;
//import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.Scanner;

import main.InsertionSort;
import main.QuickSort;
import main.RadixSort;
import main.Entities.Report;
import main.Utils.CSVMovieManager;
import main.Utils.MetricsWriter;
import main.Utils.MovieBudgetExtractor;
import main.Utils.MovieDurationExtractor;
import main.Utils.MovieIdExtractor;

/**
 * TestAlgorithms
 * 
 * @author tonycituk
 */
public class TestAlgorithms {
    private Scanner sc;
    private CSVMovieManager movieManager;
    private ArrayList<Report> reportes;
    private String path;

    public TestAlgorithms() {
        reportes = new ArrayList<Report>();
        sc = new Scanner(System.in);
        System.out.println("Ingresa el path al CSV de Movies: ");
        String path = sc.nextLine();
        movieManager = new CSVMovieManager(path);
        System.out.println("Ingresa la cantidad de Movies a cargar: ");
        int lines = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el path para guardar las métricas y resultados: ");
        String npath = sc.nextLine();
        this.path = npath;
        try {
            movieManager.loadData(lines);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testAll() {
        try {
            System.out.println("Testing sorting algorithms . . .");
            System.out.println("Length : " + movieManager.getMovies().length);
            this.testQuickSort();
            this.testRadixSort();
            this.testInsertionSort();

            new MetricsWriter(reportes, path).writeToTXTFromArray(this.path, "Metrics.txt");;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generarReporte(String name, String executionTime, int calls, int comparations, int swaps) {
        Report nuevo = new Report(name, executionTime, calls, comparations, swaps);
        reportes.add(nuevo);
        nuevo.imprimir();
    }

    public void testInsertionSort() throws Exception {
        long startTime = System.nanoTime();
        // RadixSort.radixSort(movieManager.getMovies(), new MovieIdExtractor());
        InsertionSort.sortMovieTitle(movieManager.movies);
        long endTime = System.nanoTime();
        generarReporte(
                "InsertionSort : Title menor a mayor",
                String.valueOf(endTime - startTime),
                InsertionSort.getLlamadas(),
                InsertionSort.getComparaciones(),
                InsertionSort.getIntercambios());
        movieManager.writeToCSVFromArray(this.path,
                "InsertionSortCrescentOrderedTitle.csv");
    }

    public void testQuickSort() throws Exception {
        // SE ORDENAN POR DURACION DE MENOR A MAYOR
        long startTime = System.nanoTime();
        QuickSort.quicksort(movieManager.getMovies(), 0, movieManager.getMovies().length - 1, "duration", "crescent");
        long endTime = System.nanoTime();
        generarReporte(
                "QuickSort : Duración menor a mayor",
                String.valueOf(endTime - startTime),
                QuickSort.getLlamadas(),
                QuickSort.getComparaciones(),
                QuickSort.getIntercambios());
        QuickSort.resetMetricas();
        movieManager.writeToCSVFromArray(this.path,
                "QuickSortCrescentOrderedDuration.csv");

       

        // SE ORDENAN POR DURACION DE MAYOR A MENOR

        startTime = System.nanoTime();
        QuickSort.quicksort(movieManager.getMovies(), 0, movieManager.getMovies().length - 1, "duration", "decrescent");
        endTime = System.nanoTime();
        // processTime = (endTime - startTime);
        generarReporte(
                "QuickSort : Duración mayor a menor",
                String.valueOf(endTime - startTime),
                QuickSort.getLlamadas(),
                QuickSort.getComparaciones(),
                QuickSort.getIntercambios());
        QuickSort.resetMetricas();

        // Escritura en el CSV
        movieManager.writeToCSVFromArray(this.path,
                "QuickSortDecrescentOrderedDuration.csv");

       

        // SE ORDENAN POR PRESUPUESTO DE MENOR A MAYOR

        startTime = System.nanoTime();
        // q.quickSortDurationCrescent(movies, 0, lenght-1);
        QuickSort.quicksort(movieManager.getMovies(), 0, movieManager.getMovies().length - 1, "budget", "crescent");
        endTime = System.nanoTime();
        // processTime = (endTime - startTime);
        generarReporte(
                "QuickSort : Presupuesto menor a mayor",
                String.valueOf(endTime - startTime),
                QuickSort.getLlamadas(),
                QuickSort.getComparaciones(),
                QuickSort.getIntercambios());
        QuickSort.resetMetricas();

        // Escritura en el CSV
        movieManager.writeToCSVFromArray(this.path,
                "QuickSortCrescentOrderedBudget.csv");

       

        // SE ORDENAN POR PRESUPUESTO DE MAYOR A MENOR

        startTime = System.nanoTime();
        // q.quickSortDurationCrescent(movies, 0, lenght-1);
        QuickSort.quicksort(movieManager.getMovies(), 0, movieManager.getMovies().length - 1, "budget", "decrescent");
        endTime = System.nanoTime();
        // processTime = (endTime - startTime);
        generarReporte(
                "QuickSort : Presupuesto mayor a menor",
                String.valueOf(endTime - startTime),
                QuickSort.getLlamadas(),
                QuickSort.getComparaciones(),
                QuickSort.getIntercambios());
        QuickSort.resetMetricas();

        // Escritura en el CSV
        movieManager.writeToCSVFromArray(this.path,
                "QuickSortDecrescentOrderedBudget.csv");

        

        // SE ORDENAN POR RATE DE MENOR A MAYOR

        startTime = System.nanoTime();
        // q.quickSortDurationCrescent(movies, 0, lenght-1);
        QuickSort.quicksort(movieManager.getMovies(), 0, movieManager.getMovies().length - 1, "rate", "crescent");
        endTime = System.nanoTime();
        // processTime = (endTime - startTime);
        generarReporte(
                "QuickSort : Rate menor a mayor",
                String.valueOf(endTime - startTime),
                QuickSort.getLlamadas(),
                QuickSort.getComparaciones(),
                QuickSort.getIntercambios());
        QuickSort.resetMetricas();

        // Escritura en el CSV
        movieManager.writeToCSVFromArray(this.path,
                "QuickSortCrescentOrderedRate.csv");

        

        // SE ORDENAN POR RATE DE MAYOR A MENOR

        startTime = System.nanoTime();
        // q.quickSortDurationCrescent(movies, 0, lenght-1);
        QuickSort.quicksort(movieManager.getMovies(), 0, movieManager.getMovies().length - 1, "rate", "decrescent");
        endTime = System.nanoTime();
        // processTime = (endTime - startTime);
        generarReporte(
                "QuickSort : Rate mayor a menor",
                String.valueOf(endTime - startTime),
                QuickSort.getLlamadas(),
                QuickSort.getComparaciones(),
                QuickSort.getIntercambios());
        QuickSort.resetMetricas();

        movieManager.writeToCSVFromArray(this.path,
                "QuickSortDecrescentOrderedRate.csv");

        

        // SE ORDENAN POR TITULO DE MENOR A MAYOR

        startTime = System.nanoTime();
        // q.quickSortDurationCrescent(movies, 0, lenght-1);
        // q.quicksortCrescent(movies, 0, lenght-1, "title");
        QuickSort.quicksort(movieManager.getMovies(), 0, movieManager.getMovies().length - 1, "TITLE", "crescent");
        endTime = System.nanoTime();
        // processTime = (endTime - startTime);
        generarReporte(
                "QuickSort : Título menor a mayor",
                String.valueOf(endTime - startTime),
                QuickSort.getLlamadas(),
                QuickSort.getComparaciones(),
                QuickSort.getIntercambios());
        QuickSort.resetMetricas();

        movieManager.writeToCSVFromArray(this.path,
                "QuickSort : QuickSortCrescentOrderedTitle.csv");

        
        // SE ORDENAN POR TITULO DE MAYOR A MENOR

        startTime = System.nanoTime();
        // q.quickSortDurationCrescent(movies, 0, lenght-1);
        QuickSort.quicksort(movieManager.getMovies(), 0, movieManager.getMovies().length - 1, "TITLE", "decrescent");
        endTime = System.nanoTime();
        // processTime = (endTime - startTime);
        generarReporte(
                "QuickSort : Título mayor a menor",
                String.valueOf(endTime - startTime),
                QuickSort.getLlamadas(),
                QuickSort.getComparaciones(),
                QuickSort.getIntercambios());
        QuickSort.resetMetricas();

    

        // System.out.println("ULTIMA MOVIE : " + movies[99].toString());

        // ESCRITURA EN EL CSV
        movieManager.writeToCSVFromArray(this.path,
                "QuickSortDecrescentOrderedTitle.csv");

        QuickSort.resetMetricas();
        //
    }

    public void testRadixSort() throws FileNotFoundException {

        // id
        long startTime = System.nanoTime();
        RadixSort.radixSort(movieManager.getMovies(), new MovieIdExtractor());
        long endTime = System.nanoTime();
        generarReporte(
                "RadixSort : Id menor a mayor",
                String.valueOf(endTime - startTime),
                RadixSort.getLlamadas(),
                RadixSort.getComparaciones(),
                RadixSort.getIntercambios());
        movieManager.writeToCSVFromArray(this.path, "RadixSortCrescentOrderedId.csv");

        // budget
        startTime = System.nanoTime();
        RadixSort.radixSort(movieManager.getMovies(), new MovieBudgetExtractor());
        endTime = System.nanoTime();
        generarReporte(
                "RadixSort : Budget menor a mayor",
                String.valueOf(endTime - startTime),
                RadixSort.getLlamadas(),
                RadixSort.getComparaciones(),
                RadixSort.getIntercambios());
        movieManager.writeToCSVFromArray(this.path, "RadixSortCrescentOrderedBudget.csv");

        // duration
        startTime = System.nanoTime();
        RadixSort.radixSort(movieManager.getMovies(), new MovieDurationExtractor());
        endTime = System.nanoTime();
        generarReporte(
                "RadixSort : Duration menor a mayor",
                String.valueOf(endTime - startTime),
                RadixSort.getLlamadas(),
                RadixSort.getComparaciones(),
                RadixSort.getIntercambios());
        movieManager.writeToCSVFromArray(this.path, "RadixSortCrescentOrderedDuration.csv");
    }

    public static void main(String[] args) {
        new TestAlgorithms().testAll();
    }

}