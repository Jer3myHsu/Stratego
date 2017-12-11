import Pieces.*;

public class Piece {
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
	private int numOfZombies = 4;
	public Piece(boolean team) {
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
	public void resetPieces() {
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
		this.numOfZombies = 4;
	}
	public usePiece(PieceTemplate piece) {
		
	}
}
