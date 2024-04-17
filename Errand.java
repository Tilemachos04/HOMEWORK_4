package hw4;

public class Errand {
	
	private int []order;

	public Errand(int npp, int npc, int nps, int npm, int npf) {
		
		int []order = new int[5];
		
		this.order[0] = npp;
		this.order[1] = npc;
		this.order[2] = nps;
		this.order[3] = npm;
		this.order[4] = npf;
		
	}
	
	public int getPorkChisels() {
		
		return this.order[0]*2 + this.order[3];
		
	}
	
	public int getChickenChisels() {
		
		return this.order[1]*2;
		
	}
	
	public int getShieftaliaChisels() {
		
		return this.order[2]*2 + this.order[3];
		
	}
	
	public int getPittes() {
		
		return this.order[0] + this.order[1] + this.order[2] + this.order[3];
		
	}
	
	public int getPotatoes() {
		
		return this.order[4];
		
	}
	
}