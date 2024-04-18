package hw4;

public class Errand { 
	
	private int []order; // an array that will have every detail of the order that is going to be prepared

	public Errand(int npp, int npc, int nps, int npm, int npf) {
		
		order = new int[5];
		
		this.order[0] = npp; // the number of pork pittes 
		this.order[1] = npc; // the number of chicken pittes
		this.order[2] = nps; // the number of shieftalia pittes
		this.order[3] = npm; // the number of mix pittes
		this.order[4] = npf; // the number of potato portions
		
	}
	
	public int getPorkChisels() { // returns the total number of pork chisels in the order
		
		return this.order[0]*2 + this.order[3];
		
	}
	
	public int getChickenChisels() { // returns the total number of chicken chisels in the order
		
		return this.order[1]*2;
		
	}
	
	public int getShieftaliaChisels() { // returns the total number of shieftalia chisels in the order
		
		return this.order[2]*2 + this.order[3];
		
	}
	
	public int getPittes() { // returns the total number of pittes in the order
		
		return this.order[0] + this.order[1] + this.order[2] + this.order[3];
		
	}
	
	public int getPotatoes() { // returns the total number of potato portions in the order
		
		return this.order[4];
		
	}
	
}