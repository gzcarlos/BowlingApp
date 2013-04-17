package forTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class LogsWriter {
	
	private String path;
	private File file;
	private int notifier;
	
	
	public LogsWriter(){
		path = "TestingLog.log";
		file = new File(path);
		
		if(!fileExist()){
			createFile();
			notifier++;
		}
	}
	
	private boolean fileExist() {
		
		if(file.exists())
			return true;
		
		return false;
	}
	
	private void createFile(){
		
		try{
			
			file.createNewFile();
			
		}catch(Exception e){
			System.err.println(e);
		}
		
	}
	
	private int getDayOfMonth(Date actualD){
		Calendar cal = Calendar.getInstance();
		cal.setTime(actualD);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public void logThis(String msg){
		Date dt = new Date();
		
		try{
			FileWriter fwriter = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fwriter);
			
			if(notifier == 1){
				writer.append("###############################");
				writer.newLine();
				writer.append("########## Format");
				writer.newLine();
				writer.append("###############################");
				writer.newLine();
				writer.newLine();
				writer.append("[ dd-mm-yy, hh:mm:ss ] -> Message");
				writer.newLine();
				writer.newLine();
				writer.append("###############################");
				writer.newLine();
				writer.append("########## Logs");
				writer.newLine();
				writer.append("###############################");
				writer.newLine();
				writer.newLine();
				writer.append("[ " + getDayOfMonth(dt) + "-" + dt.getMonth() + "-" + (dt.getYear() + 1900) + ", " + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " ] ");
				writer.append("-> ");
				writer.append(msg);
				writer.newLine();
			}
			else {
				writer.append("[ " + getDayOfMonth(dt) + "-" + (dt.getMonth() + 1) + "-" + (dt.getYear() + 1900) + ", " + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " ] ");
				writer.append("-> ");
				writer.append(msg);
				writer.newLine();
			}
			
			writer.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		notifier = 100;
	}

}
