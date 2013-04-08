package needs;

public class GamePlayed {
	
	private Filer filer;
	
	private String[] player1;
	private String[] player2;
	private String[] scores;
	
	public GamePlayed(Filer fr){
		filer = fr;
		
		ErrorManager errors = new ErrorManager(filer);
		
		if(!errors.getErrorAdvisor()){
			player1 = new String[21];
			player2 = new String[21];
			
			scores =  filer.readFile();
			
			setPlayers();
		}
	}
	
	public String[] getPlayer1(){
		return player1;
	}
	
	public String[] getPlayer2(){
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
			if(shot == 1) 
				preValue = value;
			
			//Setting some game rules
			
			//Strike not in Frame10
			if(value == 10 && shot == 1 && actualPlayer == 1)
				player1[p1Counter] = "x";
			if(shot == 1 && value == 10 && actualPlayer == 2)
				player2[p2Counter] = "x";
			
			//Spare not in Frame10
			//modified: not the (preValue != 10) condition
			if(actualFrame != 10 && shot == 2 && preValue != 10 && (preValue + value) == 10 && actualPlayer == 1)
				player1[p1Counter] = "/";
			if(actualFrame != 10 && shot == 2 && preValue != 10 &&  (preValue + value) == 10 &&actualPlayer == 2)
				player2[p2Counter] = "/";
			
			//Strikes Frame10 shots = 1,3
			//need to modify: the Strike in fame != 10 do it in the 1st shot
			if(actualFrame == 10 && shot != 2 && value == 10 && actualPlayer == 1)
				player1[p1Counter] = "x";
			if(actualFrame == 10 && shot != 2 && value  == 10 && actualPlayer == 2)
				player2[p2Counter] = "x";
			
			//Spare Frame10 shot = 2
			//need to modify: the Spare in fame != 10 do it in the 2nd shot
			if(actualFrame == 10 && shot == 2 && (preValue + value) == 10 && actualPlayer == 1)
				player1[p1Counter] = "/";
			if(actualFrame == 10 && shot == 2 && (preValue + value) == 10 && actualPlayer == 2)
				player2[p2Counter] = "/";
			
			//Not Strike
			if(shot == 1 && value != 10 && actualPlayer == 1)
				player1[p1Counter] = "" + value;
			if(shot == 1 && value != 10 && actualPlayer == 2)
				player2[p2Counter] = "" + value;
			
			//Not Spare
			if(shot == 2 && (preValue + value) != 10 && actualPlayer == 1)
				player1[p1Counter] = "" + value;
			if(shot == 2 && (preValue + value) != 10 && actualPlayer == 2)
				player2[p2Counter] = "" + value;
			
			//3rd shot - USELESSSSSSSSSSSSSSSSS
			if(shot == 3 && actualFrame == 10 && actualPlayer == 1)
				player1[p1Counter] = "" + value;
			if(shot == 3 && actualFrame == 10 && actualPlayer == 2)
				player2[p2Counter] = "" + value;
						
						
			
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
