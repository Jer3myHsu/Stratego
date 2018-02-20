import javax.swing.JButton;

import Pieces.*;

public class Piece 
{
	public EnderDragon enderDragon;
	public Enderman enderman[];
	public Flag flag;
	public Ghast ghast[];
	public Golem golem[];
	public Herobrine herobrine;
	public Miner miner[];
	public Skeleton skeleton[];
	public Tnt tnt[];
	public Witch witch[];
	public Wither wither;
	public Zombie zombie[];
	private int numOfEnderDragon = 1;
	private int numOfEnderman = 8;
	private int numOfFlag = 1;
	private int numOfGhast = 2;
	private int numOfGolem = 4;
	private int numOfHerobrine = 1;
	private int numOfMiner = 5;
	private int numOfSkeleton = 3;
	private int numOfTnt = 6;
	private int numOfWitch = 4;
	private int numOfWither = 1;
	private int numOfZombie = 4;
	private int numOfTotal = 40;
	
	//Idk if we need this
	private int x,y;
	private int strength;
	private int movement;
	//private boolean team;
	public Piece(boolean team) 
	{
		enderDragon = new EnderDragon(team);
		wither = new Wither(team);
		herobrine = new Herobrine(team);
		flag = new Flag(team);
		ghast = new Ghast[2];
		skeleton = new Skeleton[3];
		witch = new Witch[4];
		golem = new Golem[4];
		zombie = new Zombie[4];
		miner = new Miner[5];
		enderman = new Enderman[8];
		tnt = new Tnt[6];
		for (int i = 0; i < enderman.length; i++) {
			enderman[i] = new Enderman(team);
			if (i >= 6) {
				continue;
			}
			tnt[i] = new Tnt(team);
			if (i >= 5) {
				continue;
			}
			miner[i] = new Miner(team);
			if (i >= 4) {
				continue;
			}
			witch[i] = new Witch(team);
			golem[i] = new Golem(team);
			zombie[i] = new Zombie(team);
			if (i >= 3) {
				continue;
			}
			skeleton[i] = new Skeleton(team);
			if (i >= 2) {
				continue;
			}
			ghast[i] = new Ghast(team);
		}
	}
	//Getter methods
	public boolean getTeam()
	{
		return herobrine.getTeam();
	}
	public int getStrength()
	{
		return strength;
	}
	public int getXCoor()
	{
		return x;
	}
	public int getYCoor()
	{
		return y;
	}
	//Setter methods
	/*public void setTeam(boolean team)
	{
		this.team = team;
	}*/
	public void setStrength(int strength)
	{
		this.strength = strength;
	}
	public void setXCoor(int x)
	{
		this.x = x;
	}
	public void setYCoor(int y)
	{
		this.y = y;
	}
	public void resetPieces() 
	{
		this.numOfEnderDragon = 1;
		this.numOfEnderman = 8;
		this.numOfFlag = 1;
		this.numOfGhast = 2;
		this.numOfGolem = 4;
		this.numOfHerobrine = 1;
		this.numOfMiner = 5;
		this.numOfSkeleton = 3;
		this.numOfTnt = 6;
		this.numOfWitch = 4;
		this.numOfWither = 1;
		this.numOfZombie = 4;
		this.numOfTotal = 40;
	}
	public boolean isAllPiecesOnBoard() 
	{
		if (numOfTotal == 0) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	public void usePiece(String piece)
	{
		numOfTotal--;
		switch (piece) {
		case "Ender Dragon": numOfEnderDragon--;
		break;
		case "Enderman": numOfEnderman--;
		break;
		case "Flag": numOfFlag--;
		break;
		case "Ghast": numOfGhast--;
		break;
		case "Golem": numOfGolem--;
		break;
		case "Herobrine": numOfHerobrine--;
		break;
		case "Miner": numOfMiner--;
		break;
		case "Skeleton": numOfSkeleton--;
		break;
		case "Tnt": numOfTnt--;
		break;
		case "Witch": numOfWitch--;
		break;
		case "Wither": numOfWither--;
		break;
		case "Zombie": numOfZombie--;
		break;
		}
	}
	public boolean isAmountValid(String piece) 
	{
		int amountLeft = 0;
		switch (piece) 
		{
		case "Ender Dragon": amountLeft = numOfEnderDragon;
		break;
		case "Enderman": amountLeft = numOfEnderman;
		break;
		case "Flag": amountLeft = numOfFlag;
		break;
		case "Ghast": amountLeft = numOfGhast;
		break;
		case "Golem": amountLeft = numOfGolem;
		break;
		case "Herobrine": amountLeft = numOfHerobrine;
		break;
		case "Miner": amountLeft = numOfMiner;
		break;
		case "Skeleton": amountLeft = numOfSkeleton;
		break;
		case "Tnt": amountLeft = numOfTnt;
		break;
		case "Witch": amountLeft = numOfWitch;
		break;
		case "Wither": amountLeft = numOfWither;
		break;
		case "Zombie": amountLeft = numOfZombie;
		break;
		}
		if (amountLeft > 0)
		{
			return true;
		} else 
		{
			return false;
		}
	}
	public void setButton(String piece, JButton button)
	{// Need to create an object every time the character is placed
		switch (piece) 
		{
		case "Ender Dragon": button.setIcon(enderDragon.getImage());
		button.setToolTipText(enderDragon.getTipText());
		break;
		case "Enderman": button.setIcon(enderman[numOfEnderman].getImage());
		button.setToolTipText(enderman[numOfEnderman].getTipText());
		break;
		case "Flag": button.setIcon(flag.getImage());
		button.setToolTipText(flag.getTipText());
		break;
		case "Ghast": button.setIcon(ghast[numOfGhast].getImage());
		button.setToolTipText(ghast[numOfGhast].getTipText());
		break;
		case "Golem": button.setIcon(golem[numOfGolem].getImage());
		button.setToolTipText(golem[numOfGolem].getTipText());
		break;
		case "Herobrine": button.setIcon(herobrine.getImage());
		button.setToolTipText(herobrine.getTipText());
		break;
		case "Miner": button.setIcon(miner[numOfMiner].getImage());
		button.setToolTipText(miner[numOfMiner].getTipText());
		break;
		case "Skeleton": button.setIcon(skeleton[numOfSkeleton].getImage());
		button.setToolTipText(skeleton[numOfSkeleton].getTipText());
		break;
		case "Tnt": button.setIcon(tnt[numOfTnt].getImage());
		button.setToolTipText(tnt[numOfTnt].getTipText());
		break;
		case "Witch": button.setIcon(witch[numOfWitch].getImage());
		button.setToolTipText(witch[numOfWitch].getTipText());
		break;
		case "Wither": button.setIcon(wither.getImage());
		button.setToolTipText(wither.getTipText());
		break;
		case "Zombie": button.setIcon(zombie[numOfZombie].getImage());
		button.setToolTipText(zombie[numOfZombie].getTipText());
		break;
		}
	}//end setButton
}//end Piece class