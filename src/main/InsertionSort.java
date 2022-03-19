package main;
import main.Entities.Movie;
public class InsertionSort {
    private static final  int llamadas = 1;
    private static int intercambios = 0;
    private static int comparaciones = 0;
  
    public static void sortMovieTitle(Movie[] movies) {
        int n = movies.length;
        for (int j = 1; j < n; j++) {
            String key = movies[j].getTitle();
            int i = j - 1;
            comparaciones++;
            while ((i >= 0) && (key.compareTo(movies[i].getTitle()) < 0)) {
                movies[i + 1].setTitle(movies[i].getTitle());
                i--;
                intercambios++;
            }
            movies[i + 1].setTitle(key);
            intercambios++;
        }
    }

    public static int getLlamadas() {
        return llamadas;
    }

    public static int getIntercambios() {
        return intercambios;
    }

    public static void setIntercambios(int intercambios) {
        InsertionSort.intercambios = intercambios;
    }

    public static int getComparaciones() {
        return comparaciones;
    }

    public static void setComparaciones(int comparaciones) {
        InsertionSort.comparaciones = comparaciones;
    }

    public void resetMetricas() {
        InsertionSort.intercambios = 0;
        InsertionSort.comparaciones = 0;
    }
    
    public static String getMetricas() {
        String metricas = ("\n Número de llamadas al método : " + InsertionSort.llamadas
                + "\n Número de intercambios : " + InsertionSort.intercambios + "\n Número de comparaciones : "
                + InsertionSort.comparaciones);
        return metricas;
    }
}
