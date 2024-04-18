package hw4;

public class Algorithm1 extends Algorithm {
	
	public Algorithm1(OrderDelivery od, int [][]orders, int num) {
		
		this.od = od;
		
		for (int r = 0; r < num; r++)
			for (int c = 0; c < 8; c++)
				this.orders[r][c] = orders[r][c];
		
	}

	public void ResultsBasedOnAlgorithm() {
		
		int minutes = 330; // Total number of steps (minutes, from 18:00 to 23:30)		
		int o = 0; // the order number that is going to be executed
		
	    // Loop through each minute
	    for (int t = 1; t <= minutes; t++) {
	    	
	    	int []orderArray = new int[8];
	    	
	    	for (int r = 0; r < 8; r++) // creating an array that has the order that is going to be executed
	    		orderArray[r] = orders[o][r];
	    	
	    	Errand order = new Errand(orderArray[3], orderArray[4], orderArray[5], orderArray[6], orderArray[7]);
	    	
	    	if(od.Availability(order)) {
	    		
	    		GrillTimeGenerator time = new GrillTimeGenerator(order);
	    	}
	    	
	    	
	    		
	    }
		
	}

}	