package forTest;

import static org.junit.Assert.*;

import org.junit.Test;

import needs.Filer;
import needs.GamePlayed;

public class GamePlayedTest {

	@Test
	public void testConstructor() {
		Filer filer = new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file1.txt");
		assertNotNull(new GamePlayed(filer));
	}
	

	@Test
	public void testPlayers(){
		Filer filer = new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file1.txt");
		GamePlayed gp = new GamePlayed(filer);
		int[] p1 = {10,0,10,0,7,2,9,1,10,0,8,0,5,5,9,1,10,0,9,1,7};
		int[] capturedP1 = gp.getPlayer1();
		boolean same = true;
		
		//for(int i = 0; i < 21; ++i)
			//if(capturedP1[i] != p1[i]){
				//System.out.println("Captured[" + i + "]: " +  capturedP1[i] + ", Pointed[" + i + "]: " + p1[i]);
				//same = false;
				//break;
			//}
		
		assertEquals(capturedP1, p1);
		assertTrue(same);
	}

}
