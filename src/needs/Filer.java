package needs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Filer {
	private File file;
	private boolean archivoWorks = true;
	
	public Filer(String archivo){
		if(archivo != null || !archivo.equals(""))
			file = new File(archivo);
		else
			archivoWorks = false;
	}
	
	public String[] readFile(){
		String[] lines = new String[42];
		if(archivoWorks){
			
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
		}
		
		return lines;
	}
	
}
