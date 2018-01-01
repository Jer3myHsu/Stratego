package Pieces;
import Pieces.*;
public class EnderDragon extends PieceTemplate {
	public EnderDragon(boolean team) {
		setTeam(team);
		setStrength(10);
		setMovement(1);
		setImage(Pieces.EnderDragon.class.getResource("enderDragon.png"));
		setTipText("Strength: 10 | This can only be defeated by the herobrine");
	}
	public int getStrenth()
	{
		return 10;
		
	}
}
