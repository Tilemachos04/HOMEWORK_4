package hw4;

public class GrillTimeGenerator { // an object that generates how much time every part of an order is going to need to be ready
	
	// all arrays have a number on each filed
	private int []porkTime; // each number represents how much time each pork chisel is going to require to be ready 
	private int []chickenTime; // each number represents how much time each chicken chisel is going to require to be ready
	private int []shieftaliaTime; // each number represents how much time each shieftalia chisel is going to require to be ready
	private int []pittaTime; // each number represents how much time each pitta is going to require to be ready
	private int []potatoesTime; // each number represents how much time each potato portion is going to require to be ready
	
	public GrillTimeGenerator(Errand order) {
		
		// the length of each array depends on the order's requirements
		int []porkTime = new int[order.getPorkChisels()];
		int []chickenTime = new int[order.getChickenChisels()];
		int []shieftaliaTime = new int[order.getShieftaliaChisels()];
		int []pittaTime = new int[order.getPittes()];
		int []potatoesTime = new int[order.getPotatoes()];
		
		for (int i = 0; i < porkTime.length; i++)
			porkTime[i] = PorkChiselTime(); // each pork chisel requires 20-25 minutes to be ready
		
		for (int i = 0; i < porkTime.length; i++)
			chickenTime[i] = ChickenChiselTime(); // each chicken chisel requires 15-20 minutes to be ready
		
		for (int i = 0; i < shieftaliaTime.length; i++)
			shieftaliaTime[i] = 25; // each shieftalia chisel requires 25 minutes to be ready
			
		for (int i = 0; i < pittaTime.length; i++)
			pittaTime[i] = 5; // each pitta requires 5 minutes to be ready
		
		for (int i = 0; i < potatoesTime.length; i++)
			potatoesTime[i] = 20; // each potato portion requires 20 minutes to be ready
		
	}

	public static int PorkChiselTime() {

		int min = 20;
        int max = 25;

        // Generate a random number within the specified range
        int porkChiselTime = (int) (Math.random() * (max - min + 1)) + min;

        return porkChiselTime;

	}

	public static int ChickenChiselTime() {

		int min = 15;
        int max = 20;

        // Generate a random number within the specified range
        int chickenChiselTime = (int) (Math.random() * (max - min + 1)) + min;

        return chickenChiselTime;
        
	}
	
	public void OneMinutePass() {
		
		// decreases the time of each of the order's requirements by one, one minute passed
		
		for (int i = 0; i < porkTime.length; i++)
			porkTime[i] -= 1;
		
		for (int i = 0; i < chickenTime.length; i++)
			chickenTime[i] -= 1;
		
		for (int i = 0; i < shieftaliaTime.length; i++)
			shieftaliaTime[i] -= 1;
			
		for (int i = 0; i < pittaTime.length; i++)
			pittaTime[i] -= 1;
		
		for (int i = 0; i < potatoesTime.length; i++)
			potatoesTime[i] -= 1;
		
	}
	
	public int PorkReady() {
		
		// returns how many pork chisels are ready after one minute passed
		
		int emptyPork = 0;
		
		for (int i = 0; i < porkTime.length; i++)
			if (porkTime[i] == 0)
				emptyPork++;
		
		return emptyPork;
		
	}
	
	public int ChickenReady() {
		
		// returns how many chicken chisels are ready after one minute passed
		
		int emptyChicken = 0;
		
		for (int i = 0; i < chickenTime.length; i++)
			if (chickenTime[i] == 0)
				emptyChicken++;
		
		return emptyChicken;
		
	}
	
	public int ShieftaliesReady() {
		
		// returns how many shieftalia chisels are ready after one minute passed
		
		int emptyShieftalia = 0;
		
		for (int i = 0; i < shieftaliaTime.length; i++)
			if (shieftaliaTime[i] == 0)
				emptyShieftalia++;
		
		return emptyShieftalia;
		
	}
	
	public int PittesReady() {
		
		// returns how many pittes are ready after one minute passed
		
		int emptyPitta = 0;
		
		for (int i = 0; i < pittaTime.length; i++)
			if (pittaTime[i] == 0)
				emptyPitta++;
		
		return emptyPitta;
		
	}
	
	public int PotatoesReady() {
		
		// returns how many potato portions are ready after one minute passed
		
		int emptyPotatoes = 0;
		
		for (int i = 0; i < potatoesTime.length; i++)
			if (potatoesTime[i] == 0)
				emptyPotatoes++;
		
		return emptyPotatoes;
		
	}
	
	public boolean IsAllPorkReady(int num) {
		
		// returns if all the pork chisels of the order are finished
		
		if (num == porkTime.length)
			return true;
		
		return false;
		
	}
	
	public boolean IsAllChickenReady(int num) {
		
		// returns if all the chicken chisels of the order are finished
		
		if (num == chickenTime.length)
			return true;
		
		return false;
		
	}
	
	public boolean AreAllShieftaliesReady(int num) {
		
		// returns if all the shieftalia chisels of the order are finished
		
		if (num == shieftaliaTime.length)
			return true;
		
		return false;
		
	}
	
	public boolean AreAllPittesReady(int num) {
		
		// returns if all the pittes of the order are finished
		
		if (num == pittaTime.length)
			return true;
		
		return false;
		
	}
	
	public boolean AreAllPotatoesReady(int num) {
		
		// returns if all the potato portions of the order are finished
		
		if (num == potatoesTime.length)
			return true;
		
		return false;
		
	}
}