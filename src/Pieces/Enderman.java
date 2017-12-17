package Pieces;
import Pieces.*;
public class Enderman extends PieceTemplate {
	public Enderman(boolean team) {
		setTeam(team);
		setStrength(2);
		setMovement(2);
		setImage(Pieces.Enderman.class.getResource("enderman.png"));
		setTipText("Strength: 2 | This is can teleport very far");
	}
}
