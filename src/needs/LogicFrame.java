package bowling;

public class LogicFrame {
	private int FirstShoot;		// Player First Attempt Puntuation
	private int SecondShoot;	// Player Second Attempt Puntuation
	private int ThirdShoot;		// Player Third Attempt Puntuation
	@SuppressWarnings("unused")
	private int TotalPoints;	// Player Total Points in the actual frame
	
	public LogicFrame(int FS, int SS) {
		this.FirstShoot = FS;
		this.SecondShoot =SS;
	}
	public LogicFrame (int FS, int SS, int TS){
		this.FirstShoot = FS;
		this.SecondShoot = SS;
		this.ThirdShoot = TS;
	}
	
	public int getFirstShoot() {
		return FirstShoot;
	}
	
	public int getSecondShoot() {
		return SecondShoot;
	}
	public int getThirdShoot() {
		return ThirdShoot;
	}
	
	public void setTotalPoints(int totalPoints) {
		this.TotalPoints = totalPoints;
	}

}
