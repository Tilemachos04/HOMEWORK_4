package hw4;

public abstract class Algorithm {
	
	OrderDelivery od; // the equipment of the souvlatzidiko along with the commands 
	int [][]orders; // a two-dimensional array that consists of all the orders of the day
	int [][]deliveries; // a two-dimensional array that is going to be filled and be the output of the program
	
	public abstract void ResultsBasedOnAlgorithm();
	
}