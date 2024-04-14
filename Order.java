package hw4;

import java.util.Random;

public class Order {
	private int torder, treq;
	private int num ;
	private static int n = 1 ;
	private int npp=0 , npc=0 , nps=0 , npm=0 ,npf=0 ;
	private int pittes;
	
	public Order() {
		numberOfpittes();
		num = n ++;
		randomTorder();
		randomTreq( torder , pittes );
	}
	
	private void numberOfpittes() {
		double n = Math.random();
		int pittes;
		
		if( n < 0.20 )
			pittes = 1;
		else if ( n < 0.55 )
			pittes = 2;
		else if ( n < 0.65 )
			pittes = 3;
		else if ( n < 0.85 )
			pittes = 4;
		else {
			pittes = (int) (Math.random() * 16 ) + 5;
		}
		
		diaxorismos(pittes);
		patates(pittes);
	}
	
	private void diaxorismos ( int pittes) {
		double n = Math.random();
		
		for ( int i=0; i < pittes; i++ ) {
			if( n < 0.25 ) 
				npp++;
			else if ( n < 0.50 )
				npc++;
			else if ( n < 0.75 )
				nps++;
			else if ( n < 1 )
				npm++;
			n = Math.random();
		}
	}
	
	private void patates ( int pittes ) {
		double n = Math.random();
		
		if( n < 0.60 )
			npf++;
		else if ( n < 0.95 ) {}
		else if ( n < 1 )
			npf+=2;
	}
	
	private  void randomTorder() {
		double mean = 180;
        double standardDeviation = Math.sqrt(60); 

        Random random = new Random();

        double randomNumber = random.nextGaussian() * standardDeviation + mean;
        int roundedNumber = (int) Math.round(randomNumber);
        int finalNumber = roundedNumber % 360;
        torder = finalNumber;
	}
	
	private  void randomTreq( int torder , int pittes ) {
		
		do {
		if( pittes > 10 )
			 treq = (int) ( Math.random() * 121 ) + 60;
		else 
			 treq = (int) ( Math.random() * 151 ) + 30;
		
		treq += torder;
		} while (treq > 360);
		
	}
	public String toString () {
		String order="";
		
		order+= "< " + num + " " + torder + "," + treq + "," + npp + "," + npc + "," + nps + "," + npm + "," + npf +" >";
		return order;
	}
	
	public int getTorder() {
		return torder;
	}
	
}