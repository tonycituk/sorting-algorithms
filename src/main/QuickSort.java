public class Quicksort {
    
    private static int llamadas = 0;
    private static int intercambios = 0;
    private static int comparaciones = 0;

    public void quicksort(Movie[] array, int start, int end, String param, String cond){
        
        Quicksort.llamadas++;

        int partition;
        switch(param){
            case "duration" :
                partition = partition(array, start, end, param, cond);
                Quicksort.comparaciones++;
                if(partition-1>start) {
                    quicksort(array, start, partition - 1, param, cond);
                }
                Quicksort.comparaciones++;
                if(partition+1<end) {
                    quicksort(array, partition + 1, end, param, cond);
                }
            break;
            case "budget" :
                partition = partition(array, start, end, param, cond);
                Quicksort.comparaciones++;
                if(partition-1>start) {
                    quicksort(array, start, partition - 1, param, cond);
                }
                Quicksort.comparaciones++;
                if(partition+1<end) {
                    quicksort(array, partition + 1, end, param, cond);
                }
            break; 
            case "rate" : 
                partition = partition(array, start, end, param, cond);
                Quicksort.comparaciones++;
                if(partition-1>start) {
                    quicksort(array, start, partition - 1, param, cond);
                }
                Quicksort.comparaciones++;
                if(partition+1<end) {
                    quicksort(array, partition + 1, end, param, cond);
                }
            break;
            case "title" : 
                partition = partition(array, start, end, param, cond); //partition = partitionCrescent(array, start, end, cond);
                Quicksort.comparaciones++;
                if(partition-1>start) {
                    quicksort(array, start, partition - 1, param, cond);
                }
                Quicksort.comparaciones++;
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
                        Quicksort.comparaciones++;
                        while( i <= j ){
                            Quicksort.comparaciones++;
                            while (array[i].getTitle().compareToIgnoreCase(pivot) < 0) { // se cambia de operador para invertir
                                i++;
                            }
                            Quicksort.comparaciones++;
                            while (array[j].getTitle().compareToIgnoreCase(pivot) > 0) { //se cambia de operador para invertir
                                j--;
                            }
                            Quicksort.comparaciones++;
                            if(i <= j){
                                Movie temp= array[i];
                                array[i]=array[j];
                                array[j]=temp;
                                i++;
                                j--;

                                Quicksort.intercambios++;
                            }
                        }
                        Quicksort.comparaciones++;
                        if (start < j) {
                            quicksort(array,start, j, param, cond);
                        }
                        Quicksort.comparaciones++;
                        if (i < end) {
                            quicksort(array, i, end, param, cond);
                        }
                    break;
                    case "decrescent" : 
                        Quicksort.comparaciones++;
                        while( i <= j ){
                            Quicksort.comparaciones++;
                            while (array[i].getTitle().compareToIgnoreCase(pivot) > 0) { // se cambia de operador para invertir
                                i++;
                            }
                            Quicksort.comparaciones++;
                            while (array[j].getTitle().compareToIgnoreCase(pivot) < 0) { //se cambia de operador para invertir
                                j--;
                            }
                            Quicksort.comparaciones++;
                            if(i <= j){
                                Movie temp= array[i];
                                array[i]=array[j];
                                array[j]=temp;
                                i++;
                                j--;

                                Quicksort.intercambios++;
                            }
                        }
                        Quicksort.comparaciones++;
                        if (start < j) {
                            quicksort(array,start, j, param, cond);
                        }
                        Quicksort.comparaciones++;
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
                        Quicksort.comparaciones++; 
                        if(arr[i].getDuration()<pivot.getDuration()){
                            Movie temp= arr[start];
                            arr[start]=arr[i];
                            arr[i]=temp;
                            start++;

                            Quicksort.intercambios++;
                        }
                    }
                break;
                case ("budget") :
                    for(int i=start; i<end; i++){
                        Quicksort.comparaciones++;
                        if(arr[i].getBudget()<pivot.getBudget()){
                            Movie temp= arr[start];
                            arr[start]=arr[i];
                            arr[i]=temp;
                            start++;

                            Quicksort.intercambios++;
                        }
                    }
                break;
                case ("rate") :
                    for(int i=start; i<end; i++){
                        Quicksort.comparaciones++;
                        if(arr[i].getRate()<pivot.getRate()){
                            Movie temp= arr[start];
                            arr[start]=arr[i];
                            arr[i]=temp;
                            start++;

                            Quicksort.intercambios++;
                        }
                    }
                break;
                case ("title") :
                for(int i=start; i<end; i++){
                    Quicksort.comparaciones++;
                    if(arr[i].getID()<pivot.getID()){
                        Movie temp= arr[start];
                        arr[start]=arr[i];
                        arr[i]=temp;
                        start++;

                        Quicksort.intercambios++;
                    }
                }
                break;

            }
            break;
            case "decrescent" :
            switch(param){
                case ("duration") : 
                for(int i=start; i<end; i++){
                    Quicksort.comparaciones++;
                    if(arr[i].getDuration() > pivot.getDuration()){
                        Movie temp= arr[start];
                        arr[start]=arr[i];
                        arr[i]=temp;
                        start++;

                        Quicksort.intercambios++;
                    }
                }
            break;
            case ("budget") :
                for(int i=start; i<end; i++){
                    Quicksort.comparaciones++;
                    if(arr[i].getBudget() > pivot.getBudget()){
                        Movie temp= arr[start];
                        arr[start]=arr[i];
                        arr[i]=temp;
                        start++;

                        Quicksort.intercambios++;
                    }
                }
            break;
            case ("rate") :
                for(int i=start; i<end; i++){
                    Quicksort.comparaciones++;
                    if(arr[i].getRate() > pivot.getRate()){
                        Movie temp= arr[start];
                        arr[start]=arr[i];
                        arr[i]=temp;
                        start++;

                        Quicksort.intercambios++;
                    }
                }
            break;
            case ("title") :
            for(int i=start; i<end; i++){
                Quicksort.comparaciones++;
                if(arr[i].getID() > pivot.getID()){
                    Movie temp= arr[start];
                    arr[start]=arr[i];
                    arr[i]=temp;
                    start++;

                    Quicksort.intercambios++;
                }
            }
            break;
            }
            break;
        }
        Movie temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        Quicksort.intercambios++;

        return start;
    }    
    
    void printArr(Movie a[], int n){  
        int i;  
        for (i = 0; i < n; i++){  
            System.out.println(i + " : " + a[i].toString() + " ");  
        } 
    } 

    public void resetMetricas(){
        Quicksort.llamadas = 0;
        Quicksort.intercambios = 0;
        Quicksort.comparaciones = 0 ;
    }

    public void printMetricas(){
        String metricas = ("\n Número de llamadas al método : " + Quicksort.llamadas
        + "\n Número de intercambios : " + Quicksort.intercambios + "\n Número de comparaciones : " + Quicksort.comparaciones);

        System.out.println(metricas);

    }

    public String getMetricas(){
        String metricas = ("\n Número de llamadas al método : " + Quicksort.llamadas
        + "\n Número de intercambios : " + Quicksort.intercambios + "\n Número de comparaciones : " + Quicksort.comparaciones);
        return metricas;   
    }
}
