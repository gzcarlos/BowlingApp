package forTest;

import static org.junit.Assert.*;
import needs.Filer;

import org.junit.Test;

public class FilerTest {
	LogsWriter logs = new LogsWriter();

	
	@Test
	public void testConstructor() {
		logs.logThis("("+Filer.class.getName()+"): Constructor - Comenzado a probar...");
		
		assertNotNull(new Filer(""));
		
		logs.logThis("("+Filer.class.getName()+"): Constructor probado.");
	}
	
	@Test
	public void testReadFile(){
		logs.logThis("("+Filer.class.getName()+"): Metodo readFile() - Comenzando a probar...");
		
		String[] res = {"10","0","10","0","10","0","7","3","7","2","6","3","9","1","9","1","10","0","5","5","8","0","7","2","5","5","10","0","9","1","8","2","10","0","9","0","9","1","7","9","1","6"};
		Filer filer = new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file1.txt");
		String[] capturedFile = filer.readFile();
		boolean same = true;
		
		for(int i = 0; i < 42; ++i)
			if(!capturedFile[i].equals(res[i])){
				same = false;
				break;
			}
		assertTrue(same);
		
		logs.logThis("("+Filer.class.getName()+"): Metodo readFile() probado.");
	}

}
