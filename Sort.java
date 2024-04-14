package hw4;

public class Sort { 
	
    public static void bubbleSort(int time[], String order[]) { 
        int n = time.length; 
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (time[j] > time[j + 1]) { 
                    int temp = time[j]; 
                    time[j] = time[j + 1]; 
                    time[j + 1] = temp; 
                    String tempo = order[j];
                    order[j] = order[j+1];
                    order[j+1] = tempo;
                } 
       }
    } 
