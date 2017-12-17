package Pieces;
import Pieces.*;
public class Miner extends PieceTemplate {
	public Miner(boolean team) {
		setTeam(team);
		setStrength(3);
		setMovement(1);
		setImage(Pieces.Miner.class.getResource("miner.png"));
		setTipText("Strength: 3 | This can defuse Tnt");
	}
}
