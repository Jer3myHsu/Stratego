package Pieces;

import javax.swing.ImageIcon;

/* Jeremy Hsu
 * 
 */
public class Piece
{
	private boolean alive = false, team;
	private int strength, moveSpeed;
	private String tips;
	private ImageIcon image = new ImageIcon();
	private String position;
	public void setPosition(int x, int y) {
		this.position = x + "," + y;
	}
	public String getPosition() {
		return position;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean isAlive() {
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
