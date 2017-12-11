package Pieces;
import Pieces.*;
public class Enderman extends PieceTemplate {
	public Enderman(boolean team) {
		setTeam(team);
		setStrength(2);
		setMovement(2);
		//setImage(Enderman.class.getResource(""));
		setTipText("Strength: 2 | This is can teleport very far");
	}
}
