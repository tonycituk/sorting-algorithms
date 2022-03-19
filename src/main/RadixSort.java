package main;
import main.Entities.Movie;
import main.Utils.MovieDataExtractor;

public class RadixSort {
    private static int llamadas = 0;
    private static int intercambios = 0;
    private static int comparaciones = 0;

    static void countingSort(Movie[] movies, int place, MovieDataExtractor mde) {
        Movie[] output = new Movie[movies.length + 1];
        int max = getMax(movies, mde);

        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;
        for (int i = 0; i < movies.length; i++)
            count[(mde.getData(movies[i]) / place) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = movies.length - 1; i >= 0; i--) {
            intercambios++;
            output[count[(mde.getData(movies[i]) / place) % 10] - 1] = movies[i];
            count[(mde.getData(movies[i]) / place) % 10]--;
        }

        for (int i = 0; i < movies.length; i++)
            movies[i] = output[i];
    }

    static int getMax(Movie[] movies, MovieDataExtractor mde) {
        int max = mde.getData(movies[0]);
        for (int i = 1; i < movies.length; i++) {
            if (mde.getData(movies[i]) > max) {
                max = mde.getData(movies[i]);

            }
        }

        return max;
    }

    public static void radixSort(Movie[] movies, MovieDataExtractor mde) {
        llamadas = 1;
        int max = getMax(movies, mde);
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(movies, place, mde);
    }

    public static int getLlamadas() {
        return llamadas;
    }

    public static void setLlamadas(int llamadas) {
        RadixSort.llamadas = llamadas;
    }

    public static int getIntercambios() {
        return intercambios;
    }

    public static void setIntercambios(int intercambios) {
        RadixSort.intercambios = intercambios;
    }

    public static int getComparaciones() {
        return comparaciones;
    }

    public static void setComparaciones(int comparaciones) {
        RadixSort.comparaciones = comparaciones;
    }

    

}
