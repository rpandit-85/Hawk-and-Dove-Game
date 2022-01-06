import java.util.Random; 
public class player 
{
public String playerName;
public String playerType; 
public int playerNumber; 
Random generate = new Random(); 

public player(String x, String y, int z)
{
	playerName = x; 
	playerType = y; 
	playerNumber = generate.nextInt(3) + 1; 
	
}

public void setName(String x)
{
	playerName = x; 
}
public void setType(String x)
{
	playerType = x; 
}

public void setNumber(int x)
{
	playerNumber = x; 
}

public String getName()
{
	return playerName; 
}

public String getType()
{
	return playerType; 
}

public int getNumber()
{
	return playerNumber; 
}
}
