package bowling;

public class Ruler {
	
	public LogicFrame[] Points (int[] Score){
		int CurrentTotal=0;
		LogicFrame[] Player = new LogicFrame[10];
		for (int i=0;i<21;i+=2){
			if (i==20){
				if ((Score.length == 21)){
					CurrentTotal += Score[i]+Score[i+1]+Score[+2];
					Player[i]= new LogicFrame(Score[i], Score[i+1], Score[i+2]);
					Player[i].setTotalPoints(CurrentTotal);
					break;
				}
				else {
					CurrentTotal += Score[i]+Score[i+1];
					Player[i] = new LogicFrame(Score[i], Score[i+1], 0);
					Player[i].setTotalPoints(CurrentTotal);
					break;
				}
			}
			
			if (Score[i]==10){
				CurrentTotal += 10 + Score[i+1]+Score[i+2];
				Player[i] = new LogicFrame(Score[i], Score[i+1]);
				Player[i].setTotalPoints(CurrentTotal);
			}
			else if (Score[i]+Score[i+1]==10){
				CurrentTotal += 10 + Score[i+2];
				Player[i] = new LogicFrame(Score[i], Score[i+1]);
				Player[i].setTotalPoints(CurrentTotal);
			}
			else{
				CurrentTotal += Score[i]+Score[i+1];
				Player[i]=new LogicFrame(Score[i], Score[i+1]);
				Player[i].setTotalPoints(CurrentTotal);
			}
			
		}
		return Player;
		
	}
}
