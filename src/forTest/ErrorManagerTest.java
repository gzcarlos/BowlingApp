package forTest;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import needs.ErrorManager;

import needs.Filer;

import org.junit.Test;

public class ErrorManagerTest {
	
	LogsWriter logs = new LogsWriter();

	@Test
	public void testConstructorF1() {
		logs.logThis("(" +ErrorManager.class.getName()+"): Constructor (file1) - Comenzado a probar...");
		
		assertNotNull(new ErrorManager(new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file1.txt")));
		
		logs.logThis("(" +ErrorManager.class.getName()+"): Constructor (file1) Probado.");
	}
	
	@Test
	public void testConstructorF2() {
		logs.logThis("(" +ErrorManager.class.getName()+"): Constructor (file2) - Comenzado a probar...");
		
		assertNotNull(new ErrorManager(new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file2.txt")));
		
		logs.logThis("(" +ErrorManager.class.getName()+"): Constructor (file2) Probado.");
	}
	
	@Test
	public void testConstructorF3() {
		logs.logThis("(" +ErrorManager.class.getName()+"): Constructor (file3) - Comenzado a probar...");
		
		assertNotNull(new ErrorManager(new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file3.txt")));
		
		logs.logThis("(" +ErrorManager.class.getName()+"): Constructor (file3) Probado.");
	}
	
	@Test
	public void testFile1NotCorrupted(){
		logs.logThis("(" +ErrorManager.class.getName()+"):  (file1) no corrompido - Comenzado a probar...");
		
		ErrorManager em = new ErrorManager(new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file1.txt"));
		
		assertFalse(em.getErrorAdvisor());
		
		logs.logThis("(" +ErrorManager.class.getName()+"):  (file1) no corrompido - probado.");
		
	}
	
	@Test
	public void testFile2NotCorrupted(){
		logs.logThis("(" +ErrorManager.class.getName()+"):  (file2) no corrompido - Comenzado a probar...");
		
		ErrorManager em = new ErrorManager(new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file2.txt"));
		
		assertFalse(em.getErrorAdvisor());
		
		logs.logThis("(" +ErrorManager.class.getName()+"):  (file2) no corrompido - probado.");
		
	}
	
	@Test
	public void testFile3NotCorrupted(){
		logs.logThis("(" +ErrorManager.class.getName()+"):  (file3) corrompido - Comenzado a probar...");
		
		ErrorManager em = new ErrorManager(new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file3.txt"));
		
		assertTrue(em.getErrorAdvisor());
		
		logs.logThis("(" +ErrorManager.class.getName()+"):  (file3) corrompido - probado.");
		
	}

}
