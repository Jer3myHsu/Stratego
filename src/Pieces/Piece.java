package Pieces;

import javax.swing.ImageIcon;

/* Jeremy Hsu
 * 
 */
public class Piece
{
	private boolean alive, team;
	private int strength, moveSpeed;
	private String tips;
	private ImageIcon image = new ImageIcon();
	public void isAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean checkIfAlive() {
		return alive;
	}
	public void setTeam(boolean team) {
		this.team = team;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getStrength() {
		return strength;
	}
	public void setMovement(int pattern) {
		//0 = Unmoveable
		//1 = regular one set
		//2 = Rook-like
		this.moveSpeed = pattern;
	}
	public int getMovement() {
		return moveSpeed;
	}
	public void setImage(ImageIcon image) {
		this.image = new ImageIcon(image.getImage());
	}
	public int getImage() {
		return moveSpeed;
	}
	public void setTipText(String text) {
		this.tips = text;
	}
	public String getTipText() {
		return tips;
	}
}
