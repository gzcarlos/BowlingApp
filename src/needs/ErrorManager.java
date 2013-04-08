package needs;

public class ErrorManager {
	
	private String errorMessage;
	private boolean gotError;
	private String[] lines;
	
	public ErrorManager(Filer fil){
		errorMessage = "";
		gotError = false;
		lines = fil.readFile();
		
		fileNotComplete();
		noNumbers();
		lineSizeExceeded();
		scoreOver10();
	}
	
	public void fileNotComplete(){
		
		if(lines.length == 42){
			for(int i = 0; i < 42; ++i){
				//never use "==" to compare strings, use String.equals()
				if(lines[i] == null || lines[i].equals("")){
					errorMessage = "The File line [" + (i+1) + "] have no Value!";
					gotError = true;
					break;
				}
			}
		}
		else{
			errorMessage = "The File don't have the specified quantity of lines!";
			gotError = true;
		}
		
	}
	
	public void scoreOver10(){
		
		if(!gotError){
			int currentPlayer = 1, currentFrame = 1, shot = 1, preValue = 0, value, currentLine = 1;
			
			for(int i = 0; i < 42; ++i){
			
				value = Integer.parseInt(lines[i]);
				
				if(shot == 1)
					preValue = value;
				
				
				//identifying player
				if(currentLine == 1 || currentLine == 2) currentPlayer = 1;
				else if(currentLine == 3 || currentLine == 4) currentPlayer = 2;
				else if(currentFrame == 10 && (currentLine == 1 || currentLine == 2 || currentLine == 3)) currentPlayer = 1;
				else if(currentFrame == 10 && (currentLine == 4 || currentLine == 5 || currentLine == 6)) currentPlayer = 2;
				
				//Error Conditions
				if(currentFrame != 10 && shot == 2 && (preValue + value) > 10){
					errorMessage = "The Frame [" + currentFrame + "] for the Player" + currentPlayer + " in [shot = "+shot+
							" in line "+(i+1)+"] contain a value out" +
							" of the Bowling Rules (It's over 10)!";
					gotError = true;
					break;
				}
				
				//to do = < 0
				if(shot == 2 && (value + preValue) < 0){
					errorMessage = "The Player" + currentPlayer + " int Frame [" + currentFrame + "] (line = "+(i+1)+") has a score below \'0\'!.";
					gotError = true;
					break;
				}
				// over 10 in frame10
				if(currentFrame == 10 && value > 10){
					errorMessage = "The Frame [10] int the Player" + currentPlayer + "  have a value over 10 (not according to the Bowling Rules)!";
					gotError = true;
					break;
				}
			
				//Last Conditions - Restarting, Increasing
				if(shot == 2 && currentFrame != 10)
					shot = 1;
				else if(shot == 3 && currentFrame == 10)
					shot = 1;
				else
				++shot;
				
				if((i + 1) % 4 == 0 && currentFrame  != 10){
					currentLine = 1;
					++currentFrame;
				}
				else
					++currentLine;
			}
		}
		
	}
	
	public void lineSizeExceeded(){
		
		if(!gotError){
			int currentPlayer = 1, currentFrame = 1, shot = 1, value, currentLine = 1;
			
			for(int i = 0; i < 42; ++i){
			
				//Error Conditions
				if(lines[i].length() > 2){
					errorMessage = "The Player" + currentPlayer + " in Frame ["  + currentFrame+ "]" +
							"  (shot = " + shot + ", line = "+(i+1)+") have more characters than spected!.";
					gotError = true;
					break;
				}
				
				//Start of looping
				
				
				//identifying player
				if(currentLine == 1 || currentLine == 2) currentPlayer = 1;
				else if(currentLine == 3 || currentLine == 4) currentPlayer = 2;
				else if(currentFrame == 10 && (currentLine == 0 || currentLine == 1 || currentLine == 2)) currentPlayer = 1;
				else if(currentFrame == 10 && (currentLine == 3 || currentLine == 4 || currentLine == 5)) currentPlayer = 2;
				
				
				
			
				//Last Conditions - Restarting, Increasing
				if(shot == 2 && currentFrame != 10)
					shot = 1;
				else if(shot == 3 && currentFrame == 10)
					shot = 1;
				else
				++shot;
			
				if((i + 1) % 4 == 0 && currentFrame  != 10){
					++currentFrame;
					currentLine = 1;
				}
				else
					++currentLine;
				
			}
		}
		
	}
	
	public void noNumbers(){
		
		if (!gotError){
			
			String characters = "1234567890";
			
			for(int i = 0; i < 42; ++i){
			
				//Error Conditions
				if(lines[i].length() <= 2 && lines[i] != null && i != 41){
					
					for(int j = 0; j < lines[i].length(); ++j){
						if(isNotANumber(lines[i].charAt(j))){
							errorMessage = "The File contains a letter in line [" + (i + 1) + "]!.";
							gotError = true;
							break;
						}// end if isANumber
					}//end loop for a single line
					
				}//end if for lines
				
				
			}//end for the loop in all lines
			
		}//end of if !gotError
		
	}//end of method
	
	public String getErrorMessage(){
		return this.errorMessage;
	}
	
	public boolean getErrorAdvisor(){
		return this.gotError;
	}
	
	private boolean isNotANumber(char c){
		String nums = "1234567890";
		boolean contains = true;
		
		for(int i = 0; i < nums.length(); ++i)
			if(nums.charAt(i) == c){
				contains = false;
				break;
			}
		
		return contains;
	}

}
