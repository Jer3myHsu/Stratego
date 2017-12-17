package Pieces;
import Pieces.*;
public class Witch extends PieceTemplate {
	public Witch(boolean team) {
		setTeam(team);
		setStrength(6);
		setMovement(1);
		setImage(Pieces.Witch.class.getResource("witch.png"));
		setTipText("Strength: 6");
	}
}
