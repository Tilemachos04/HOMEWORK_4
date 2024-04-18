package hw4;

import java.util.ArrayList;
import java.util.List;

public class Algorithm1 extends Algorithm {
	
	public Algorithm1(OrderDelivery od, int [][]orders, int num) {
		
		this.od = od;
		
		this.orders = new int[orders.length][8];
		this.deliveries = new int[num][6]; 
		
		for (int r = 0; r < num; r++)
			for (int c = 0; c < 8; c++)
				this.orders[r][c] = orders[r][c];
		
	}
     
	public void ResultsBasedOnAlgorithm() {
		
		int minutes = 330; // total number of steps (minutes, from 18:00 to 23:30)
		int waiting = this.od.getCoalPreparationTime() - 30; // how much time mastros is going to wait for the fuku to be ready after starting to accept orders
		int o = 0; // the order number that is going to be executed
		int k = 0; // will be needed when filling the deliveries array
		
		List<int[]> grilling = new ArrayList<>(); // a list that will have all the orders that are currently getting prepared in the fuku
		List<GrillTimeGenerator> timing = new ArrayList<>(); // a list that will have all the remaining time of all the orders that are currently getting prepared in the fuku
		List<int[]> prepared = new ArrayList<>(); // a list that will have what portion of every order has been prepared at the time
		
	    // Loop through each minute
	    for (int t = 1; t <= minutes; t++) {
	    	
	    	if (t > waiting) { // start doing preparations only if the coal is ready
	    	
	    	int []orderArray = new int[8]; // an array that has the very next order that is going to be prepared 
	    	
	    	for (int r = 0; r < 8; r++) // filling the array from the orders array
	    		orderArray[r] = orders[o][r];
	    	
	    	Errand order = new Errand(orderArray[3], orderArray[4], orderArray[5], orderArray[6], orderArray[7]); // creating an object that will have all the information needed for the order's preparation
	    	
	    	if(od.Availability(order)) { // if there is enough space in the fuku, it starts preparing the order
	    		
	    		GrillTimeGenerator time = new GrillTimeGenerator(order); // generates the time needed to prepare every part of the order
	    		
	    		int ready[] = new int[5];
	    		// creating an array that is going to have how much of the order's requirements have finished preparing
	    		for (int i = 0; i < 5; i++)
	    			ready[i] = 0;
	    		
	    		grilling.add(orderArray); // adding all the data
	    		timing.add(time);         // to the three lists
	    		prepared.add(ready);      // that are parallel
	    		
	    		o++;
	    		
	    	}
	    	
	    	if(t > 1) // this if statement prevents the first order from requiring less time than usual 
	    		for (int i = 0; i < timing.size(); i++) {
	    		
	    		timing.get(i).OneMinutePass(); // a minute passes in all the orders that are getting prepared
	    		
	    		int readyPork = timing.get(i).PorkReady(); // how many pork chisels got ready after the passage of the minute
	    		int readyChicken = timing.get(i).ChickenReady(); // how many chicken chisels got ready after the passage of the minute
	    		int readyShieftalies = timing.get(i).ShieftaliesReady(); // how many shieftalia chisels got ready after the passage of the minute
	    		int readyPittes = timing.get(i).PittesReady(); // how many pittes got ready after the passage of the minute
	    		int readyPotatoes = timing.get(i).PotatoesReady(); // how many potato portions got ready after the passage of the minute
	    		
	    		// removes all the ready order requirements from the fuku and the pans 
	    		od.FukuRemover(readyPork + readyChicken, readyShieftalies, readyPittes, readyPotatoes);
	    		
	    		// adding up everything that got prepared after the passage of the minute into the portion of the order
	    		prepared.get(i)[0] += readyPork;
	    		prepared.get(i)[1] += readyChicken;
	    		prepared.get(i)[2] += readyShieftalies;
	    		prepared.get(i)[3] += readyPittes;
	    		prepared.get(i)[4] += readyPotatoes;
	    		
	    		boolean isAllPorkReady = timing.get(i).IsAllPorkReady(prepared.get(i)[0]); 
	    		boolean isAllChickenReady = timing.get(i).IsAllChickenReady(prepared.get(i)[1]);
	    		boolean AreAllShieftaliesReady = timing.get(i).AreAllShieftaliesReady(prepared.get(i)[2]);
	    		boolean AreAllPittesReady = timing.get(i).AreAllPittesReady(prepared.get(i)[3]);
	    		boolean AreAllPotatoesReady = timing.get(i).AreAllPotatoesReady(prepared.get(i)[4]);
	    		
	    		if (isAllPorkReady && isAllChickenReady && AreAllShieftaliesReady && AreAllPittesReady && AreAllPotatoesReady) {
	    			
	    			// checking if the whole order is ready for delivery
	    			
	    			// filling the output of the program
	    			this.deliveries[k][0] = grilling.get(i)[0];
	    			this.deliveries[k][1] = grilling.get(i)[1];
	    			this.deliveries[k][2] = t;
	    			this.deliveries[k][3] = t - grilling.get(i)[1];
	    			this.deliveries[k][4] = grilling.get(i)[3] + grilling.get(i)[4] + grilling.get(i)[5] + grilling.get(i)[6];
	    			this.deliveries[k][4] = grilling.get(i)[7];
	    			
	    			k++;
	    			
	    			grilling.remove(i);
	    			timing.remove(i);
	    			prepared.remove(i);
	    			// removed the order from all the lists
	    			
	    		}
	    		
	    		}
		
	    	}
	    
	    }
	    
	    
	    
	    
	    // here I will be printing the data 
	    
	    
	    
	    
	    
	    
	}
}