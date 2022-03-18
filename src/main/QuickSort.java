package main;

import main.Entitities.Movie;

public class QuickSort {
    
    private static int llamadas = 0;
    private static int intercambios = 0;
    private static int comparaciones = 0;

    public void quicksort(Movie[] array, int start, int end, String param, String cond){
        
        QuickSort.llamadas++;

        int partition;
        switch(param){
            case "duration" :
                partition = partition(array, start, end, param, cond);
                QuickSort.comparaciones++;
                if(partition-1>start) {
                    quicksort(array, start, partition - 1, param, cond);
                }
                QuickSort.comparaciones++;
                if(partition+1<end) {
                    quicksort(array, partition + 1, end, param, cond);
                }
            break;
            case "budget" :
                partition = partition(array, start, end, param, cond);
                QuickSort.comparaciones++;
                if(partition-1>start) {
                    quicksort(array, start, partition - 1, param, cond);
                }
                QuickSort.comparaciones++;
                if(partition+1<end) {
                    quicksort(array, partition + 1, end, param, cond);
                }
            break; 
            case "rate" : 
                partition = partition(array, start, end, param, cond);
                QuickSort.comparaciones++;
                if(partition-1>start) {
                    quicksort(array, start, partition - 1, param, cond);
                }
                QuickSort.comparaciones++;
                if(partition+1<end) {
                    quicksort(array, partition + 1, end, param, cond);
                }
            break;
            case "title" : 
                partition = partition(array, start, end, param, cond); //partition = partitionCrescent(array, start, end, cond);
                QuickSort.comparaciones++;
                if(partition-1>start) {
                    quicksort(array, start, partition - 1, param, cond);
                }
                QuickSort.comparaciones++;
                if(partition+1<end) {
                    quicksort(array, partition + 1, end, param, cond);
                }
            break;
            case "TITLE" : 
                int i = start;
                int j = end;
                String pivot = array[end].getTitle();
                switch(cond){
                    case "crescent" : 
                        QuickSort.comparaciones++;
                        while( i <= j ){
                            QuickSort.comparaciones++;
                            while (array[i].getTitle().compareToIgnoreCase(pivot) < 0) { // se cambia de operador para invertir
                                i++;
                            }
                            QuickSort.comparaciones++;
                            while (array[j].getTitle().compareToIgnoreCase(pivot) > 0) { //se cambia de operador para invertir
                                j--;
                            }
                            QuickSort.comparaciones++;
                            if(i <= j){
                                Movie temp= array[i];
                                array[i]=array[j];
                                array[j]=temp;
                                i++;
                                j--;

                                QuickSort.intercambios++;
                            }
                        }
                        QuickSort.comparaciones++;
                        if (start < j) {
                            quicksort(array,start, j, param, cond);
                        }
                        QuickSort.comparaciones++;
                        if (i < end) {
                            quicksort(array, i, end, param, cond);
                        }
                    break;
                    case "decrescent" : 
                        QuickSort.comparaciones++;
                        while( i <= j ){
                            QuickSort.comparaciones++;
                            while (array[i].getTitle().compareToIgnoreCase(pivot) > 0) { // se cambia de operador para invertir
                                i++;
                            }
                            QuickSort.comparaciones++;
                            while (array[j].getTitle().compareToIgnoreCase(pivot) < 0) { //se cambia de operador para invertir
                                j--;
                            }
                            QuickSort.comparaciones++;
                            if(i <= j){
                                Movie temp= array[i];
                                array[i]=array[j];
                                array[j]=temp;
                                i++;
                                j--;

                                QuickSort.intercambios++;
                            }
                        }
                        QuickSort.comparaciones++;
                        if (start < j) {
                            quicksort(array,start, j, param, cond);
                        }
                        QuickSort.comparaciones++;
                        if (i < end) {
                            quicksort(array, i, end, param, cond);
                        }
                    break;
                }
            break;
            
        }
    }


    public static int partition(Movie[] arr, int start, int end, String param, String cond){
        Movie pivot = arr[end];
        switch(cond){
            case "crescent" :
            switch(param){
                case ("duration") : 
                    for(int i=start; i<end; i++){
                        QuickSort.comparaciones++; 
                        if(arr[i].getDuration()<pivot.getDuration()){
                            Movie temp= arr[start];
                            arr[start]=arr[i];
                            arr[i]=temp;
                            start++;

                            QuickSort.intercambios++;
                        }
                    }
                break;
                case ("budget") :
                    for(int i=start; i<end; i++){
                        QuickSort.comparaciones++;
                        if(arr[i].getBudget()<pivot.getBudget()){
                            Movie temp= arr[start];
                            arr[start]=arr[i];
                            arr[i]=temp;
                            start++;

                            QuickSort.intercambios++;
                        }
                    }
                break;
                case ("rate") :
                    for(int i=start; i<end; i++){
                        QuickSort.comparaciones++;
                        if(arr[i].getRate()<pivot.getRate()){
                            Movie temp= arr[start];
                            arr[start]=arr[i];
                            arr[i]=temp;
                            start++;

                            QuickSort.intercambios++;
                        }
                    }
                break;
                case ("title") :
                for(int i=start; i<end; i++){
                    QuickSort.comparaciones++;
                    if(arr[i].getID()<pivot.getID()){
                        Movie temp= arr[start];
                        arr[start]=arr[i];
                        arr[i]=temp;
                        start++;

                        QuickSort.intercambios++;
                    }
                }
                break;

            }
            break;
            case "decrescent" :
            switch(param){
                case ("duration") : 
                for(int i=start; i<end; i++){
                    QuickSort.comparaciones++;
                    if(arr[i].getDuration() > pivot.getDuration()){
                        Movie temp= arr[start];
                        arr[start]=arr[i];
                        arr[i]=temp;
                        start++;

                        QuickSort.intercambios++;
                    }
                }
            break;
            case ("budget") :
                for(int i=start; i<end; i++){
                    QuickSort.comparaciones++;
                    if(arr[i].getBudget() > pivot.getBudget()){
                        Movie temp= arr[start];
                        arr[start]=arr[i];
                        arr[i]=temp;
                        start++;

                        QuickSort.intercambios++;
                    }
                }
            break;
            case ("rate") :
                for(int i=start; i<end; i++){
                    QuickSort.comparaciones++;
                    if(arr[i].getRate() > pivot.getRate()){
                        Movie temp= arr[start];
                        arr[start]=arr[i];
                        arr[i]=temp;
                        start++;

                        QuickSort.intercambios++;
                    }
                }
            break;
            case ("title") :
            for(int i=start; i<end; i++){
                QuickSort.comparaciones++;
                if(arr[i].getID() > pivot.getID()){
                    Movie temp= arr[start];
                    arr[start]=arr[i];
                    arr[i]=temp;
                    start++;

                    QuickSort.intercambios++;
                }
            }
            break;
            }
            break;
        }
        Movie temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        QuickSort.intercambios++;

        return start;
    }    
    
    public void printArr(Movie a[], int n){  
        int i;  
        for (i = 0; i < n; i++){  
            System.out.println(i + " : " + a[i].toString() + " ");  
        } 
    } 

    public void resetMetricas(){
        QuickSort.llamadas = 0;
        QuickSort.intercambios = 0;
        QuickSort.comparaciones = 0 ;
    }

    public void printMetricas(){
        String metricas = ("\n Número de llamadas al método : " + QuickSort.llamadas
        + "\n Número de intercambios : " + QuickSort.intercambios + "\n Número de comparaciones : " + QuickSort.comparaciones);

        System.out.println(metricas);

    }

    public String getMetricas(){
        String metricas = ("\n Número de llamadas al método : " + QuickSort.llamadas
        + "\n Número de intercambios : " + QuickSort.intercambios + "\n Número de comparaciones : " + QuickSort.comparaciones);
        return metricas;   
    }
}
