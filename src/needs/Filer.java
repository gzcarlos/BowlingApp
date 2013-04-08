package needs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Filer {
	private File file;
	private String takenFile = "";
	
	public Filer(String archivo){
		file = new File(archivo);
	}
	
	public String[] readFile(){
		String[] lines = new String[42];
		int linesPointer = 0;
		
		try{
			
			FileReader freader = new FileReader(file);
			BufferedReader reader = new BufferedReader(freader);
			String line = "";
			
			while((line = reader.readLine()) != null){
				lines[linesPointer] = line;
				++linesPointer;
			}
			
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		return lines;
	}
	
}
