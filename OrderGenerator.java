package hw4;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class OrderGenerator {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	System.out.println(" Give the number of orders ");
    	int numOforders = scan.nextInt();
    	scan.close();
    	String [] orders = new String[numOforders];
    	int [] time = new int[numOforders];
    	
    	for( int i = 0; i < numOforders; i++) {
    		Order order = new Order();
    		orders[i] = order.toString();
    		time[i] = order.getTorder();	
    	}
    	Sort.bubbleSort(time , orders);
    	
    	// create a file
    	try {
            File myObj = new File("orders.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    
    	// write into a file
    	 try {
    	      FileWriter myWriter = new FileWriter("orders.txt");
    	      for( int i = 0; i < numOforders; i++) {
    	          myWriter.write( orders[i] );
    	          myWriter.write( "\n" );
    	      }
    	      myWriter.close();
    	      System.out.println("Successfully wrote to the file.");
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    	  
    	
    	
    	
    }     
}