package Pieces;

import java.net.URL;

import javax.swing.ImageIcon;

/* Jeremy Hsu
 * 
 */
public class PieceTemplate
{
	private boolean alive = false, team;
	private int strength, moveSpeed, numOfPieces;
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
	public boolean getTeam() {
		return team;
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
	public void setImage(URL imagePath) {
		this.image = new ImageIcon(imagePath);
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setTipText(String text) {
		this.tips = text;
	}
	public String getTipText() {
		return tips;
	}
	public int getNumOfPiecesAvailable() {
		return numOfPieces;
	}
	public void setNumOfPieces(int num) {
		this.numOfPieces = num;
	}
}
