package needs;

public class GamePlayed {
	
	private Filer filer;
	
	private int[] player1;
	private int[] player2;
	private String[] scores;
	
	public GamePlayed(Filer fr){
		filer = fr;
		
		ErrorManager errors = new ErrorManager(filer);
		
		if(!errors.getErrorAdvisor()){
			player1 = new int[21];
			player2 = new int[21];
			
			scores =  filer.readFile();
			
			setPlayers();
		}
	}
	
	public int[] getPlayer1(){
		return player1;
	}
	
	public int[] getPlayer2(){
		return player2;
	}
	
	private void setPlayers(){
		
		int looper = 0, actualFrame = 1,  actualPlayer = 1, shot = 1, value = 0, preValue = -1;
		int p1Counter = 0, p2Counter = 0, reading = 1;
		
		for(looper = 0; looper < 42; ++looper){
			//Set up all the players 
			
			
			//Setting actualPlayer
			if((reading == 1 || reading == 2) && actualFrame != 10) 
				actualPlayer = 1;
			else if((reading == 3 || reading == 4) && actualFrame != 10)
				actualPlayer = 2;
			else if((reading==1||reading==2||reading==3) && actualFrame == 10)
				actualPlayer = 1;
			else if((reading==4||reading==5||reading==6) && actualFrame == 10)
				actualPlayer = 2;
			
			//Setting values
			if(scores[looper] != null)
				value = Integer.parseInt(scores[looper]);
			//if(shot == 1) 
				//preValue = value;
			
			//Setting some game rules
			
			//Strike not in Frame10
			if(actualPlayer == 1)
				player1[p1Counter] = value;
			if(actualPlayer == 2)
				player2[p2Counter] = value;
			
			
			
			//Do ALL INCREMENTALS
			//Last Conditions - Restart, Increment
			
			//related to shots
			if(shot == 2 && actualFrame != 10)
				shot = 1;
			else if (shot == 3 && actualFrame == 10)
				shot = 1;
			else
				++shot;
			
			//related to reading - when is reading the whole scores array
			if(reading == 4 && actualFrame != 10){
				++actualFrame;
				reading = 1;
			}
			else
				++reading;
			
			//increase Counters
			if(actualPlayer == 1)
				++p1Counter;
			else if(actualPlayer == 2)
				++p2Counter;
			
		
		}
		
	}

}
