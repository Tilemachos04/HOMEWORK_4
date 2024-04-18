package hw4;

public class GrillTimeGenerator { // an object that generates how much time every part of an order is going to need to be ready
	
	// the length of the following arrays
	private int porkChisels;
	private int chickenChisels;
	private int shieftaliaChisels;
	private int pittes;
	private int potatoes;
	
	// all arrays have a number on each filed
	private int []porkTime; // each number represents how much time each pork chisel is going to require to be ready 
	private int []chickenTime; // each number represents how much time each chicken chisel is going to require to be ready
	private int []shieftaliaTime; // each number represents how much time each shieftalia chisel is going to require to be ready
	private int []pittaTime; // each number represents how much time each pitta is going to require to be ready
	private int []potatoesTime; // each number represents how much time each potato portion is going to require to be ready
	
	public GrillTimeGenerator(Errand order) {
		
		porkChisels = order.getPorkChisels();
		chickenChisels = order.getChickenChisels();
		shieftaliaChisels = order.getShieftaliaChisels();
		pittes = order.getPittes();
		potatoes = order.getPotatoes();
		
		// the length of each array depends on the order's requirements
		if (porkChisels > 0)
			porkTime = new int[porkChisels];
		
		if (chickenChisels > 0)
			chickenTime = new int[chickenChisels];
		
		if (shieftaliaChisels > 0)
			shieftaliaTime = new int[shieftaliaChisels];
		
		if (pittes > 0)
			pittaTime = new int[pittes];
		
		if (potatoes > 0)
			potatoesTime = new int[potatoes];
		
		for (int i = 0; i < porkChisels; i++)
			porkTime[i] = PorkChiselTime(); // each pork chisel requires 20-25 minutes to be ready
		
		for (int i = 0; i < chickenChisels; i++)
			chickenTime[i] = ChickenChiselTime(); // each chicken chisel requires 15-20 minutes to be ready
		
		for (int i = 0; i < shieftaliaChisels; i++)
			shieftaliaTime[i] = 25; // each shieftalia chisel requires 25 minutes to be ready
			
		for (int i = 0; i < pittes; i++)
			pittaTime[i] = 5; // each pitta requires 5 minutes to be ready
		
		for (int i = 0; i < potatoes; i++)
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
		
		for (int i = 0; i < porkChisels; i++)
			porkTime[i] -= 1;
		
		for (int i = 0; i < chickenChisels; i++)
			chickenTime[i] -= 1;
		
		for (int i = 0; i < shieftaliaChisels; i++)
			shieftaliaTime[i] -= 1;
			
		for (int i = 0; i < pittes; i++)
			pittaTime[i] -= 1;
		
		for (int i = 0; i < potatoes; i++)
			potatoesTime[i] -= 1;
		
	}
	
	public int PorkReady() {
		
		// returns how many pork chisels are ready after one minute passed
		
		int emptyPork = 0;
		
		for (int i = 0; i < porkChisels; i++)
			if (porkTime[i] == 0)
				emptyPork++;
		
		return emptyPork;
		
	}
	
	public int ChickenReady() {
		
		// returns how many chicken chisels are ready after one minute passed
		
		int emptyChicken = 0;
		
		for (int i = 0; i < chickenChisels; i++)
			if (chickenTime[i] == 0)
				emptyChicken++;
		
		return emptyChicken;
		
	}
	
	public int ShieftaliesReady() {
		
		// returns how many shieftalia chisels are ready after one minute passed
		
		int emptyShieftalia = 0;
		
		for (int i = 0; i < shieftaliaChisels; i++)
			if (shieftaliaTime[i] == 0)
				emptyShieftalia++;
		
		return emptyShieftalia;
		
	}
	
	public int PittesReady() {
		
		// returns how many pittes are ready after one minute passed
		
		int emptyPitta = 0;
		
		for (int i = 0; i < pittes; i++)
			if (pittaTime[i] == 0)
				emptyPitta++;
		
		return emptyPitta;
		
	}
	
	public int PotatoesReady() {
		
		// returns how many potato portions are ready after one minute passed
		
		int emptyPotatoes = 0;
		
		for (int i = 0; i < potatoes; i++)
			if (potatoesTime[i] == 0)
				emptyPotatoes++;
		
		return emptyPotatoes;
		
	}
	
	public boolean IsAllPorkReady(int num) {
		
		// returns if all the pork chisels of the order are finished
		
		if (porkChisels < 1)
			return true;
		
		if (num == porkTime.length)
			return true;
		
		return false;
		
	}
	
	public boolean IsAllChickenReady(int num) {
		
		// returns if all the chicken chisels of the order are finished
		
		if (chickenChisels < 1)
			return true;
		
		if (num == chickenTime.length)
			return true;
		
		return false;
		
	}
	
	public boolean AreAllShieftaliesReady(int num) {
		
		// returns if all the shieftalia chisels of the order are finished
		
		if (shieftaliaChisels < 1)
			return true;
		
		if (num == shieftaliaTime.length)
			return true;
		
		return false;
		
	}
	
	public boolean AreAllPittesReady(int num) {
		
		// returns if all the pittes of the order are finished
		
		if (pittes < 1)
			return true;
		
		if (num == pittaTime.length)
			return true;
		
		return false;
		
	}
	
	public boolean AreAllPotatoesReady(int num) {
		
		// returns if all the potato portions of the order are finished
		
		if (potatoes < 1)
			return true;
		
		if (num == potatoesTime.length)
			return true;
		
		return false;
		
	}
}