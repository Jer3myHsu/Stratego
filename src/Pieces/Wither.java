package Pieces;
import Pieces.*;
public class Wither extends PieceTemplate {
	public Wither(boolean team) {
		setTeam(team);
		setStrength(9);
		setMovement(1);
		setImage(Wither.class.getResource("wither.png"));
		setTipText("Strength: 9");
	}
}
