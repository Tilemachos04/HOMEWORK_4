package hw4;

public class GrillTimeGenerator {
	
	private int []porkTime;
	private int []chickenTime;
	private int []shieftaliaTime;
	private int []pittaTime;
	private int []potatoesTime;
	
	public GrillTimeGenerator(Errand order) {
		
		int []porkTime = new int[order.getPorkChisels()];
		int []chickenTime = new int[order.getChickenChisels()];
		int []shieftaliaTime = new int[order.getShieftaliaChisels()];
		int []pittaTime = new int[order.getPittes()];
		int []potatoesTime = new int[order.getPotatoes()];
		
		for (int i = 0; i < porkTime.length; i++)
			porkTime[i] = PorkChiselTime();
		
		for (int i = 0; i < porkTime.length; i++)
			chickenTime[i] = ChickenChiselTime();
		
		for (int i = 0; i < shieftaliaTime.length; i++)
			shieftaliaTime[i] = 25;
			
		for (int i = 0; i < pittaTime.length; i++)
			pittaTime[i] = 5;
		
		for (int i = 0; i < potatoesTime.length; i++)
			potatoesTime[i] = 20;
		
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
	
	public int GrillReady() {
		
		int emptyPork = 0, emptyChicken = 0, emptyShieftalia = 0, emptyPitta = 0;
		
		for (int i = 0; i < porkTime.length; i++)
			if (porkTime[i] == 0)
				emptyPork++;
		
		for (int i = 0; i < chickenTime.length; i++)
			if (chickenTime[i] == 0)
				emptyChicken++;
		
		for (int i = 0; i < shieftaliaTime.length; i++)
			if (shieftaliaTime[i] == 0)
				emptyShieftalia++;
			
		for (int i = 0; i < pittaTime.length; i++)
			if (pittaTime[i] == 0)
				emptyPitta++;
		
	}
}