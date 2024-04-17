package hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderDelivery {

	private int [][]orders; // a two-dimensional array that has all the data generated from OrderGenerator
	private String [][]deliveries; // a two-dimensional array that has everything that is going to be printed on deliveries.txt
	private Algorithm A;
	Fuku fuku;
	
	public OrderDelivery(int M, int T, int N, int C, int X, int Y, int Z, int num, int [][]orders , Algorithm A) {
		
		fuku = new Fuku( M, T, N, C, X, Y, Z );
	    this.A = A;
		
		for (int r = 0; r < num; r++)
			for (int c = 0; c < 8; c++)
				this.orders[r][c] = orders[r][c];
		
	}
	public void callAlgorithm () {
		A.resultsBasedOnAlgorithm;
	}
	
public static void main(String[] args) {
	
	if (args.length != 8 || Integer.parseInt(args[7]) > 3 && Integer.parseInt(args[7])<1)
		System.err.println("Error");
	
	int M = Integer.parseInt(args[0]), T = Integer.parseInt(args[1]), N = Integer.parseInt(args[2]), C = Integer.parseInt(args[3]), X = Integer.parseInt(args[4]), Y = Integer.parseInt(args[5]), Z = Integer.parseInt(args[6]), A = Integer.parseInt(args[7]);
	
		
	List<int[]> list = new ArrayList<>();
		
	String fileName = "orders.txt"; 

	try (FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
            	
            	int cnt = 0;
            	
            	for (int i = 0; i < line.length(); i++)
            		if (line.charAt(i) == ' ')
            			cnt++;
            			
            	if (cnt == 7) {
            		
            		int[] array = new int[8];
            		
            		int cnt1 = 0;
            		String num = "";
            		
            		for (int i = 0; i < line.length(); i++) {
            			if (line.charAt(i) != ' ' && line.charAt(i) != '<' && line.charAt(i) != '>' && line.charAt(i) != ',')
            				num += line.charAt(i);
            			if (line.charAt(i) == ' ' || line.charAt(i) == '>'){
            				
            				if (cnt1 == 0)
            					array[0] = Integer.parseInt(num);
            				else if (cnt1 == 1)
            					array[1] = Integer.parseInt(num);
            				else if (cnt1 == 2)
            					array[2] = Integer.parseInt(num);
            				else if (cnt1 == 3)
            					array[3] = Integer.parseInt(num);
            				else if (cnt1 == 4)
            					array[4] = Integer.parseInt(num);
            				else if (cnt1 == 5)
            					array[5] = Integer.parseInt(num);
            				else if (cnt1 == 6)
            					array[6] = Integer.parseInt(num);
            				else if (cnt1 == 7)
            					array[7] = Integer.parseInt(num);
            				
            				cnt1++;
            				num = "";
            				
            			}
            		}
            		
            		list.add(array);
           
            	}
            		
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

	 /*printing the list so I know I copied the data
     // Iterate through each array in the list
        for (int r = 0; r < list.size(); r++) {
            int[] array = list.get(r);
            // Iterate through each element in the array
            for (int c = 0; c < array.length; c++) {
                int element = array[c];
                System.out.print(element + " ");
            }
            // Print a newline after printing each array
            System.out.println();
        }*/
	
	int orders[][] = new int[list.size()][8];
	
    for (int r = 0; r < list.size(); r++) {
        int[] array = list.get(r);
        // Iterate through each element in the array
        for (int c = 0; c < array.length; c++) {
            int element = array[c];
            orders[r][c] = element;
        }
    }
    
    for (int r = 0; r < list.size(); r++) {
    	for (int c = 0; c<8; c++)
    		System.out.print(orders[r][c] + " ");
    	System.out.println();
    }
    

	
    
}

}