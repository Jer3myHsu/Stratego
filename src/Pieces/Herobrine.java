package Pieces;
import Pieces.*;
public class Herobrine extends PieceTemplate {
	public Herobrine(boolean team) {
		setTeam(team);
		setStrength(1);
		setMovement(1);
		setImage(Pieces.Herobrine.class.getResource("herobrine.png"));
		setTipText("Strength: S | This can potentially defeat an Ender Dragon but will lose to everything else");
	}
}
