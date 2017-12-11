package Pieces;
import Pieces.*;
public class Tnt extends PieceTemplate {
	public Tnt(boolean team) {
		setTeam(team);
		setStrength(11);
		setMovement(0);
		setImage(Pieces.Tnt.class.getResource("tnt.png"));
		setTipText("Strength: 11 | This defeats anyone it touches... usually");
	}
}
