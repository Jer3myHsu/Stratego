package Pieces;
import Pieces.*;
public class Ghast extends PieceTemplate {
	public Ghast(boolean team) {
		setTeam(team);
		setStrength(8);
		setMovement(1);
		setImage(Pieces.Ghast.class.getResource("ghast.png"));
		setTipText("Strength: 8");
	}
}
