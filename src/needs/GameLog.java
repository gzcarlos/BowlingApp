package bowling;

//import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameLog {
	
	static ArrayList<String> log = new ArrayList<>();
	
	public ArrayList<String> Log(LogicFrame[] Player1, LogicFrame Player2 []){
		boolean exit = false;
		boolean flag = true, initxcouter2 = false,initcouter2=false, initxcouter = false,initcouter = false;
		Queue<String> waiting = new LinkedList<>();
		Queue<String> wait = new LinkedList<>();
		Queue<String> waiting2 = new LinkedList<>();
		Queue<String> wait2 = new LinkedList<>();
		int i = 0, xcouter1 = 0,xcouter2 = 0, couter1 = 0, couter2 = 0, Player1index = 0, Player2index = 0;
		while (exit == false){
			if (flag == false){
				if (Player2index == 9){
					
					log.add("P2" + String.valueOf(Player2[Player2index].getFirstShoot()));
					if (Player2[Player2index-1].getFirstShoot() + Player2[Player2index-1].getSecondShoot() ==10) {String Points = wait2.poll(); log.add("-"+ "P2" + Points.substring(3)); couter2 = 0; if (wait2.isEmpty()){initcouter2 = false;}}
					log.add("P2" + String.valueOf(Player2[Player2index].getSecondShoot()));
					log.add("P2" + String.valueOf(Player2[Player2index].getThirdShoot()));
					log.add("P2" + String.valueOf(Player2[Player2index].getTotalPoints()));
					break;
				}
				if (Player2[Player2index].getFirstShoot() == 10){
					if (initxcouter2){++xcouter2;}
					initxcouter2 = true;
					log.add("P2" + String.valueOf(Player2[Player2index].getFirstShoot()));
					if (xcouter2 == 2) {String Points = waiting2.poll(); log.add("-"+ "P2" + Points.substring(3)); xcouter2 = 0; if (waiting2.isEmpty()){initxcouter2 = false;++xcouter2;}}
					if (initcouter2) {String Points = wait2.poll(); log.add("-"+ "P2" + Points.substring(3)); couter2 = 0; if (wait2.isEmpty()){initcouter2 = false;}}
					log.add("P2" + String.valueOf(Player2[Player2index].getSecondShoot()));
					waiting2.add(String.valueOf(i) + "P2" + String.valueOf(Player2[Player2index].getTotalPoints()));
					++Player2index;
				}
				else if (Player2[Player2index].getFirstShoot() + Player2[Player2index].getSecondShoot() ==10){
					if (initcouter2){++couter2;}
					initcouter2 =true;
					log.add("P2" + String.valueOf(Player2[Player2index].getFirstShoot()));
					if (couter2 == 1) {String Points = wait2.poll(); log.add("-"+ "P2" + Points.substring(3)); couter2 = 0; if (wait2.isEmpty()){initcouter2 = false;}}
					log.add("P2" + String.valueOf(Player2[Player2index].getSecondShoot()));
					if (initxcouter2) {String Points = waiting2.poll(); log.add("-"+ "P2" + Points.substring(3)); xcouter2 = 0; if (waiting2.isEmpty()){initxcouter2 = false;++xcouter2;}}
					wait2.add(String.valueOf(i) +"P2" + String.valueOf(Player2[Player2index].getTotalPoints()));
					++Player2index;
				}
				else {
					log.add("P2" + String.valueOf(Player2[Player2index].getFirstShoot()));
					if (Player2[Player2index-1].getFirstShoot() + Player2[Player2index-1].getSecondShoot() ==10) {String Points = wait2.poll(); log.add("-"+ "P2" + Points.substring(3)); couter2 = 0; if (wait2.isEmpty()){initcouter2 = false;}}
					log.add("P2" + String.valueOf(Player2[Player2index].getSecondShoot()));
					if (Player2[Player2index-1].getFirstShoot() == 10) {String Points = waiting2.poll(); log.add("-"+ "P2" + Points.substring(3)); xcouter2 = 0; if (waiting2.isEmpty()){initxcouter2 = false;++xcouter2;}}
					log.add("P2" + String.valueOf(Player2[Player2index].getTotalPoints()));
					++Player2index;
					//if (Player2index == 9){Player2index =10;}
				}
				
				flag = true;
			}
			
			if (flag == true){
				if (Player1index == 9){
					log.add("P1" + String.valueOf(Player1[Player1index].getFirstShoot()));
					if (Player1[Player1index-1].getFirstShoot() + Player1[Player1index-1].getSecondShoot() ==10) {String Points = wait2.poll(); log.add("-"+ "P1" + Points.substring(3)); couter1 = 0; if (wait.isEmpty()){initcouter = false;}}
					log.add("P1" + String.valueOf(Player1[Player1index].getSecondShoot()));
					log.add("P1" + String.valueOf(Player1[Player1index].getThirdShoot()));
					log.add("P1" + String.valueOf(Player1[Player1index].getTotalPoints()));
				}
				else if (Player1[Player1index].getFirstShoot() == 10){
					if (initxcouter){++xcouter1;}
					initxcouter = true;
					log.add("P1" + String.valueOf(Player1[Player1index].getFirstShoot()));
					if (initcouter) {String Points = wait.poll(); log.add("-"+ "P1" + Points.substring(3)); couter1 = 0; if (wait.isEmpty()){initcouter = false;}}
					if (xcouter1 == 2) {String Points = waiting.poll(); log.add("-"+ "P1" + Points.substring(3)); xcouter1 = 0; if (waiting.isEmpty()){initxcouter = false;++xcouter1;}}
					log.add("P1" + String.valueOf(Player1[Player1index].getSecondShoot()));
					waiting.add(String.valueOf(i) + "P1" + String.valueOf(Player1[Player1index].getTotalPoints()));
					++Player1index;
				}
				else if (Player1[Player1index].getFirstShoot() + Player1[Player1index].getSecondShoot() ==10){
					if (initcouter){++couter1;}
					initcouter = true;
					log.add("P1" + String.valueOf(Player1[Player1index].getFirstShoot()));
					if (couter1 == 1) {String Points = wait.poll(); log.add("-"+ "P1" + Points.substring(3)); couter1 = 0; if (wait.isEmpty()){initcouter = false;}}
					log.add("P1" + String.valueOf(Player1[Player1index].getSecondShoot()));
					if (initxcouter) {String Points = waiting.poll(); log.add("-"+ "P1" + Points.substring(3)); xcouter1 = 0; if (waiting.isEmpty()){initxcouter = false;++xcouter1;}}
					wait.add(String.valueOf(i) +"P1" + String.valueOf(Player1[Player1index].getTotalPoints()));
					++Player1index;
				}
				else {
					log.add("P1" + String.valueOf(Player1[Player1index].getFirstShoot()));
					if (Player1[Player1index-1].getFirstShoot() + Player1[Player1index-1].getSecondShoot() ==10) {String Points = wait.poll(); log.add("-"+ "P1" + Points.substring(3)); couter1 = 0; if (wait.isEmpty()){initcouter = false;}}
					log.add("P1" + String.valueOf(Player1[Player1index].getSecondShoot()));
					if (Player1[Player1index-1].getFirstShoot() == 10) {String Points = waiting.poll(); log.add("-"+ "P1" + Points.substring(3)); xcouter1 = 0; if (waiting.isEmpty()){initxcouter = false;++xcouter1;}}
					log.add("P1" + String.valueOf(Player1[Player1index].getTotalPoints()));
					++Player1index;
				}
				flag = false;
			}
		}
		return log;
		
	}

}
