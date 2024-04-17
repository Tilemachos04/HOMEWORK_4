package hw4;

public class Fuku {
	
	private int M; // fuku capacity
	private int T; // coal preparation time
	private int NC; // number of totals pans multiplied by the capacity of each pan
	private int X; // the space every chisel of souvlaki occupies
	private int Y; // the space every chisel of shieftalia occupies
	private int Z; // the space every pitta occupies
	
	public Fuku(int M, int T, int N, int C, int X, int Y, int Z) {
		
		this.M = M;
		this.T = T;
		this.NC = N * C;
		this.X = X;
		this.Y = Y;
		this.Z = Z;
		
	}
	
	public void Mastros(Errand order) { 
		
		if (IsFukuAvailable(this.OrderSpace(order), this.PortionsOfPotatoes(order)))
			this.FukuAdder(order);
		
	}
	
	public int OrderSpace(Errand order) {
		
		int orderSpace, souvlakiSpace, shieftaliaSpace, pittaSpace;
		
		souvlakiSpace = (order.getPorkChisels() + order.getChickenChisels())*this.X;
		
		shieftaliaSpace = order.getShieftaliaChisels() * this.Y;
		
		pittaSpace = order.getPittes() * this.Z;
		
		orderSpace = souvlakiSpace + shieftaliaSpace + pittaSpace;
		
		return orderSpace;
		
	}
	
	public int PortionsOfPotatoes(Errand order) {
		
		int portionsOfPotatoes;
		
		portionsOfPotatoes = order.getPotatoes();
		
		return portionsOfPotatoes;
		
	}
	
	public boolean IsFukuAvailable(int orderSpace, int portionsOfPotatoes) {
		
		if (orderSpace <= this.M && portionsOfPotatoes <= this.NC)
			return true;
		
		return false;
		
	}
	
	public void FukuAdder(Errand order) {
		
		this.M -= this.OrderSpace(order);
		this.NC -= this.PortionsOfPotatoes(order);
		
	}
	
}