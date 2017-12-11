package Pieces;
import Pieces.*;
public class Flag extends PieceTemplate {
	public Flag(boolean team) {
		setTeam(team);
		setStrength(0);
		setMovement(0);
		//setImage();
		setTipText("Flag | Don't let your enemy destroy this flag");
	}
}
