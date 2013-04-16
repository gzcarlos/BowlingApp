package forTest;

import static org.junit.Assert.*;
import needs.Filer;

import org.junit.Test;

public class FilerTest {

	@Test
	public void testConstructor() {
		assertNotNull(new Filer(""));
	}
	
	@Test
	public void testReadFile(){
		String[] res = new String[42];
		assertEquals(res, 
				new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file1.txt").readFile());
	}

}
