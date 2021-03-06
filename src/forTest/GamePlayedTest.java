package forTest;

import static org.junit.Assert.*;

import org.junit.Test;

import needs.ErrorManager;
import needs.Filer;
import needs.GamePlayed;

public class GamePlayedTest {
	
	LogsWriter logs = new LogsWriter();

	Filer f1 = new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file1.txt");
	Filer f2 = new Filer("C:/Users/Carlos/Documents/Workspace/BowlingTextFile/file2.txt");
	
	GamePlayed gp1 = new GamePlayed(f1);	
	GamePlayed gp2 = new GamePlayed(f2);
	
	@Test
	public void testConstructor1() {
		logs.logThis("(" +GamePlayed.class.getName()+"): Constructor - Comenzado a probar...");
		
		assertNotNull(new GamePlayed(f1));
	
		logs.logThis("(" +GamePlayed.class.getName()+"): Constructor probado con el archivo \"file1\".");
	}
	
	@Test
	public void testCostructor2(){
		logs.logThis("(" +GamePlayed.class.getName()+"): Constructor - Comenzado a probar...");
		
		assertNotNull(new GamePlayed(f2));
		
		logs.logThis("(" +GamePlayed.class.getName()+"): Constructor probado con el archivo \"file2\".");
	}
	
	//Tests for F1
	
	@Test
	public void testPlayer1F1(){
		logs.logThis("(" +GamePlayed.class.getName()+"): Player1 con (file1) - Comenzado a probar...");

		int[] p1 = {10,0,10,0,7,2,9,1,10,0,8,0,5,5,9,1,10,0,9,1,7};
		int[] capturedP1 = gp1.getPlayer1();
		boolean same = true;
		
		for(int i = 0; i < 21; ++i)
			if(capturedP1[i] != p1[i]){
				same = false;
				break;
			}
		
		assertTrue(same);
		logs.logThis("(" +GamePlayed.class.getName()+"): Player1 probado con el archivo \"file1\".");
	}
	
	@Test
	public void testPlayer2F1(){
		logs.logThis("(" +GamePlayed.class.getName()+"): Player2 con (file1) - Comenzado a probar...");
		
		int[] p2 = {10,0,7,3,6,3,9,1,5,5,7,2,10,0,8,2,9,0,9,1,6};
		int[] capturedP2 = gp1.getPlayer2();
		boolean same = true;
		
		for (int i = 0; i < 21; ++i)
			if(capturedP2[i] != p2[i]){
				same = false;
				break;
			}
		
		assertTrue(same);
		
		logs.logThis("(" +GamePlayed.class.getName()+"): Player2 probado con el archivo \"file1\".");
	}
	
	//Tests for F2
	
	@Test
	public void testPlayer1F2(){
		logs.logThis("(" +GamePlayed.class.getName()+"): Player1 con (file2) - Comenzado a probar...");
		
		int[] p1 = {9,1,10,0,7,3,8,2,9,0,3,5,10,0,8,0,7,3,10,0,9};
		int[] capturedP1 = gp2.getPlayer1();
		boolean same = true;
		
		for(int i = 0; i < 21; ++i)
			if(capturedP1[i] != p1[i]){
				same = false;
				break;
			}
		
		assertTrue(same);
		
		logs.logThis("(" +GamePlayed.class.getName()+"): Player1 probado con el archivo \"file2\".");
	}
	
	@Test
	public void testPlayer2F2(){
		logs.logThis("(" +GamePlayed.class.getName()+"): Player2 con (file2) - Comenzado a probar...");
		
		int[] p2 = {6,4,5,5,10,0,5,0,4,3,7,2,10,0,1,9,6,3,1,9,10};
		int[] capturedP2 = gp2.getPlayer2();
		boolean same = true;
		
		for(int i = 0; i < 21; ++i)
			if(capturedP2[i] != p2[i]){
				same = false;
				break;
			}
		
		assertTrue(same);
		
		logs.logThis("(" +GamePlayed.class.getName()+"): Player2 probado con el archivo \"file2\".");
	}
	
	//Tests for F2 Failed
	
	@Test
	public void testPlayer1F2Failed(){
		logs.logThis("(" +GamePlayed.class.getName()+"): Player1 con (file2) (Error esperado) - Comenzado a probar...");
		
		int[] p1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] capturedP1 = gp2.getPlayer1();
		boolean same = true;
		
		for(int i = 0; i < 21; ++i)
			if(p1[i] != capturedP1[i]){
				same = false;
				break;
			}
		
		assertFalse(same);
		
		logs.logThis("(" +GamePlayed.class.getName()+"): Player1 (Error esperado) probado con el archivo \"file2\".");
	}
	
	@Test
	public void TestPlayer2F2Failed(){
		logs.logThis("(" +GamePlayed.class.getName()+"): Player2 con (file2) (Error esperado) - Comenzado a probar...");
		
		int[] p2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] capturedP2 = gp2.getPlayer2();
		boolean same = true;
		
		for(int i = 0; i < 21; ++i)
			if(capturedP2[i] != p2[i]){
				same = false;
				break;
			}
		
		assertFalse(same);
		
		logs.logThis("(" +GamePlayed.class.getName()+"): Player2 (Error esperado) probado con el archivo \"file2\".");
	}

}
