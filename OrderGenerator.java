package hw4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderGenerator {
    Order orders [] ;
    int torders[];
    String textOrders[];
    int numOforders;
	
	public OrderGenerator( int n ) {
		numOforders = n;
		orders = new Order[n];
		torders = new int[n];
	    textOrders = new String[n];
	    
		for( int i=0; i<n; i++ ) {
			orders[i] = new Order();
			textOrders[i] = orders[i].toString();
			torders[i] =  orders[i].getTorder();
		}
		
		Sort.bubbleSort(torders , textOrders);
	}
	
	public String toString () {
		int num=1;
		String ordersOftheDay="";
		
		ordersOftheDay += numOforders;
		ordersOftheDay += "\n";
		for( int i=0; i<orders.length; i++ ) {
		    ordersOftheDay+= "<" + num +" "+ textOrders[i] + ">";
		    ordersOftheDay+="\n";
		    num++;
		}
	    
		return ordersOftheDay;
	}
    
    
    
    
	public static void main(String[] args) {
		
		int num = Integer.parseInt(args[0]);
		OrderGenerator triti = new OrderGenerator(num);
		
		
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
    	      myWriter.write( triti.toString() );
    	      myWriter.close();
    	      System.out.println("Successfully wrote to the file.");
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    	    
    
	}

}
