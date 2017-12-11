package Pieces;
import Pieces.*;
public class Skeleton extends PieceTemplate {
	public Skeleton(boolean team) {
		setTeam(team);
		setStrength(7);
		setMovement(1);
		setImage(Pieces.Skeleton.class.getResource("skeleton.png"));
		setTipText("Strength: 7");
	}
}
