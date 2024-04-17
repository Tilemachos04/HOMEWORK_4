package hw4;

public class Fuku {
	
	private int M; // xoritikotita fukus
	private int T; // karvouna time
	private int N; // tiania
	private int C; // xoritikotita tianion
	private int X; // xoros smilas souvlaki
	private int Y; // xoros smilas sieftalias
	private int Z; // xoros pittas
	
	public Fuku(int M, int T, int N, int C, int X, int Y, int Z) {
		
		this.M = M;
		this.T = T;
		this.N = N;
		this.C = C;
		this.X = X;
		this.Y = Y;
		this.Z = Z;
		
	}
	
//	public void FukuATM() {
//		
//		
//		
//	}
	
	public int OrderSpace(Order order) {
		
		int orderSpace, souvlakiSpace, shieftaliaSpace, pittaSpace;
		
		souvlakiSpace = (order.getPorkChisels() + order.getChickenChisels())*this.X;
		
		shieftaliaSpace = order.getShieftaliaChisels() * this.Y;
		
		pittaSpace = order.getPittes() * this.Z;
		
		orderSpace = souvlakiSpace + shieftaliaSpace + pittaSpace;
		
		return orderSpace;
		
	}
	
}
