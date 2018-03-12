package Pieces;
import Pieces.*;
public class Zombie extends PieceTemplate 
{
	public Zombie(boolean team) 
	{
		setTeam(team);
		setStrength(4);
		setMovement(1);
		setImage(Pieces.Zombie.class.getResource("zombie.png"));
		setTipText("Strength: 4");
	}
}//end Zombie class
