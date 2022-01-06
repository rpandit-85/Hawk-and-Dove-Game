import java.util.ArrayList;

import java.util.Random; 
import javax.swing.JFrame; 
import java.awt.*;
 

public class hawkAndDoveGame extends player
{
	public static int numsims = 10000; 
	public static int[] leopardArray = new int[numsims]; 
	public static int[] pandaArray = new int[numsims];
public hawkAndDoveGame(String x, String y, int z) {
		super(x, y, z);
	}
public static int encounters = 0; 
public static int PandaPopulation = 1000; 
public static int LeopardPopulation = 1000; 
public static int PandaBabies = 0; 
public static int LeopardBabies = 0; 
public static int DeadPandas = 0; 
public static int DeadLeopards = 0; 
public static int PandaCalories = 0; 
public static int LeopardCalories = 0; 
public static int leopardsquared = 0; 

public static int currentsim = 0; 
public static GraphingData pandaData = new GraphingData(); 
public static GraphingData leopardData = new GraphingData(); 

public static void main(String [] args) {
	
 
	
	for(int i =0; i <  numsims - 1; i++)
	{
		currentsim++; 
		player player1 = new player("Player 1,", "x", 0);
		
		player player2 = new player ("Player 2", "x", 2); 
		
		System.out.println(player1.getNumber()); 
		if (player1.getNumber() == 1)
			player1.setType("Panda");
		else
			player1.setType("Snow Leopard");
		
		if (player2.getNumber() == 1)
			player2.setType("Panda");
		else 
			player2.setType("Leopard");
		
		String player1Type = player1.getType(); 
		String player2Type = player2.getType(); 
		
		if (player1Type.equals("Leopard") && player2Type.equals("Leopard"))
		{
			System.out.println("Player 1 is a snow leopard, and Player 2 is a snow leopard. Player 1's payoff is 2, and Player 2's payoff is 2"); 
			leopardsquared++; 
			encounters++; 
			LeopardPopulation -= 2; 
			DeadLeopards += 2; 
			Random rand = new Random(); 
			int x = rand.nextInt(3) + 1; 
			if (x == 1)
			{
				System.out.println("One of the leopards died from it's wounds"); 
				LeopardPopulation -= 1; 
				DeadLeopards += 1; 
			}
			leopardArray[currentsim] = LeopardPopulation; 
			pandaArray[currentsim] = PandaPopulation; 
		}	
		
		if (player1Type.equals("Panda") && player2Type.equals("Panda"))
		{
			System.out.println("Player 1 is a panda, and Player 2 is a panda. Player 1's payoff is 5, Player 2's payoff is 5"); 
			encounters++; 
			PandaPopulation += 2; 
			PandaBabies += 2; 
			PandaCalories += 6500; 
			leopardArray[currentsim] = LeopardPopulation; 
			pandaArray[currentsim] = PandaPopulation; 
		}
		if(player1Type.equals("Panda") && player2Type.equals("Leopard")) 
		{
			System.out.println("Player 1 is a panda, and Player 2 is a Snow Leopard. Player 1's payoff is 0, and Player 2's payoff is 9"); 
			encounters++; 
			PandaPopulation -= 1; 
			LeopardPopulation += 2; 
			DeadPandas += 1; 
			LeopardBabies += 2; 
			LeopardCalories += 400; 
			leopardArray[currentsim] = LeopardPopulation;
			pandaArray[currentsim] = PandaPopulation; 
		}
		if(player1Type.equals("Leopard") && player2Type.equals("Panda"))
		{
			System.out.println("Player 1 is a snow leopard, and Player 2 is a panda. Player 1's payoff is 9, and Player 2's payoff is 0"); 
			encounters++; 
			PandaPopulation -= 1; 
			LeopardPopulation += 2; 
			DeadPandas += 1; 
			LeopardBabies += 2; 
			LeopardCalories += 400; 
			leopardArray[currentsim] = LeopardPopulation; 
			pandaArray[currentsim] = PandaPopulation; 
		}	
	
		
		
		
		double TotalPopulation = PandaPopulation + LeopardPopulation; 

		double LeopardPercent = LeopardPopulation / TotalPopulation; 
		double PandaPercent = PandaPopulation / TotalPopulation; 

		System.out.println("There were " + encounters + " encounters recorded"); 
		System.out.println("Calories gained by snow leopards: " + LeopardCalories); 
		System.out.println("Calories gained by pandas: " + PandaCalories); 
		System.out.println(PandaBabies + " panda babies were born"); 
		System.out.println(LeopardBabies + " snow leopard babies were born"); 
		System.out.println(DeadPandas + " pandas died"); 
		System.out.println(DeadLeopards + " snow leopards died"); 
		System.out.println("The snow leopard population is now " + LeopardPopulation); 
		System.out.println("The panda population is now " + PandaPopulation); 
		System.out.println("The total population is now " + TotalPopulation); 
		System.out.println(LeopardPercent * 100 + "% of the population is snow leopards"); 
		System.out.println(PandaPercent * 100 + "% of the population is pandas");
		
	}
	 
	 
	
	pandaData.setData(pandaArray); 
	
	JFrame f = new JFrame(); 
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	f.add(pandaData); 
	f.setSize(400,400); 
	f.setLocation(200,200);
	f.setVisible(true); 
	
	leopardData.setData(leopardArray); 
	
	JFrame j = new JFrame(); 
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	j.add(leopardData); 
	j.setSize(400,400); 
	j.setLocation(200,200);
	j.setVisible(true); 
	
	
	

}
}
