package Pieces;
import Pieces.*;
public class Flag extends PieceTemplate {
	public Flag(boolean team) {
		setTeam(team);
		setStrength(0);
		setMovement(0);
		setImage(Pieces.Flag.class.getResource("flag.png"));
		setTipText("Flag | Don't let your enemy destroy this flag");
	}
}
