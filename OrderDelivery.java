package hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderDelivery {

	private int M; // fuku capacity
	private int T; // coal preparation time
	private int NC; // number of totals pans multiplied by the capacity of each pan
	private int X; // the space every chisel of souvlaki occupies
	private int Y; // the space every chisel of shieftalia occupies
	private int Z; // the space every pitta occupies
	
	public OrderDelivery(int M, int T, int N, int C, int X, int Y, int Z) {
		
		this.M = M;
		this.T = T;
		this.NC = N * C;
		this.X = X;
		this.Y = Y;
		this.Z = Z;
		
	}
	
	public int getCoalPreparationTime() { // returns how much time the coal will take to be ready 
		
		return this.T;
		
	}
	
	public boolean Availability(Errand order) { 
		
		// checks whether the fuku is available to take the next order 
		
		if (IsFukuAvailable(this.OrderSpace(order), this.PortionsOfPotatoes(order))) {
			this.FukuAdder(order); // if the fuku is available, it starts preparing the next order
			return true;
		}
		
		return false;
		
	}
	
	public int OrderSpace(Errand order) { // returns the total number of space the order occupies
		
		int orderSpace, souvlakiSpace, shieftaliaSpace, pittaSpace;
		
		souvlakiSpace = (order.getPorkChisels() + order.getChickenChisels())*this.X; // the space pork and chicken souvlaki chisels occupie
	
		shieftaliaSpace = order.getShieftaliaChisels() * this.Y; // the space shieftalia chisels occupie
		
		pittaSpace = order.getPittes() * this.Z; // the space pittes occupie
		
		orderSpace = souvlakiSpace + shieftaliaSpace + pittaSpace; // total number of space the order occupies
		
		return orderSpace;
		
	}
	
	public int PortionsOfPotatoes(Errand order) { // returns how many potato portions the order has
		
		int portionsOfPotatoes;
		
		portionsOfPotatoes = order.getPotatoes(); // the number of potato portions in the order
		
		return portionsOfPotatoes;
		
	}
	
	public boolean IsFukuAvailable(int orderSpace, int portionsOfPotatoes) {
		
		// returns if the fuku and the pans have enough space to start preparing the next order
		
		// checking if the occupying space of the next order is smaller than the current available space
		if (orderSpace <= this.M && portionsOfPotatoes <= this.NC)
			return true;  
		
		return false;
		
	}
	
	public void FukuAdder(Errand order) {
		
		// when an order is added in the fuku, it decreases the fuku's available space and the number of available pans
		
		this.M -= this.OrderSpace(order);
		this.NC -= this.PortionsOfPotatoes(order);
		
	}
	
	public void FukuRemover(int readySouvlakiChisels, int readyShieftaliaChisels, int readyPittes, int readyPotatoes) {
		
		// when any part of any order is finished, it is taken out of the fuku and the fuku's available space is getting increased, same goes with the pans
		
		this.M += readySouvlakiChisels*this.X + readyShieftaliaChisels*this.Y + readyPittes*this.Z;
		this.NC += readyPotatoes;
		
	}
	
	
public static void main(String[] args) {
	
	// checking if the command line arguments are the right number and if the algorithm is either 1, 2 or 3
	if (args.length != 8 || Integer.parseInt(args[7]) > 3 && Integer.parseInt(args[7])<1)
		System.err.println("Error");
	
	int M = Integer.parseInt(args[0]), T = Integer.parseInt(args[1]), N = Integer.parseInt(args[2]), C = Integer.parseInt(args[3]), X = Integer.parseInt(args[4]), Y = Integer.parseInt(args[5]), Z = Integer.parseInt(args[6]), algo = Integer.parseInt(args[7]);
		
	List<int[]> list = new ArrayList<>();
		
	String fileName = "orders.txt"; // the file OrderGenerator generates

	try (FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) { // reads line by line
            	
            	int cnt = 0;
            	
            	// counting how many spaces there are in the line
            	for (int i = 0; i < line.length(); i++)
            		if (line.charAt(i) == ' ')
            			cnt++;
            			
            	if (cnt == 7) { // checking whether the data of each line is the correct number, taking into consideration the number of spaces
            		
            		int[] array = new int[8];
            		
            		int cnt1 = 0;
            		String num = "";
            		
            		for (int i = 0; i < line.length(); i++) { // a for-loop that helps process all the data of the line
            			
            			if (line.charAt(i) != ' ' && line.charAt(i) != '<' && line.charAt(i) != '>' && line.charAt(i) != ',')
            				num += line.charAt(i); // adding to each number when the character is correct
            			
            			if (line.charAt(i) == ' ' || line.charAt(i) == '>'){ // checking if the number ended
            				
            				// adding the number to an array that consists of the data of the line
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
            		
            		// adding the array that has all the data of the line into a list that is going to end up having all the data of all the lines
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
	
	// copying the list into a two-dimensional array, for more convenient processing
    for (int r = 0; r < list.size(); r++) {
        int[] array = list.get(r);
        for (int c = 0; c < array.length; c++) {
            int element = array[c];
            orders[r][c] = element;
        }
    }
    
    for (int r = 0; r < orders.length; r++) {
    	for (int c = 0; c < 8; c++)
    		System.out.print(orders[r][c] + " ");
    	System.out.println();
    }
    
    OrderDelivery od = new OrderDelivery(M, T, N, C, X, Y, Z);

    //if (algo == 1) {
    	Algorithm1 A = new Algorithm1(od, orders, orders.length);
    //}
    
    A.ResultsBasedOnAlgorithm();
    
}

}