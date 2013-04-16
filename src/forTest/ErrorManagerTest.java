package forTest;

import static org.junit.Assert.assertNotNull;

import needs.ErrorManager;

import needs.Filer;

import org.junit.Test;

public class ErrorManagerTest {

	@Test
	public void testConstructor() {
		assertNotNull(new ErrorManager(new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file1.txt")));
	}

}
