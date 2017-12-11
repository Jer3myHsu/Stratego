package Pieces;
import Pieces.*;
public class Golem extends PieceTemplate {
	public Golem(boolean team) {
		setTeam(team);
		setStrength(5);
		setMovement(1);
		//setImage();
		setTipText("Strength: 5");
	}
}
