package bowling;
import javax.swing.*;

import java.awt.*;
@SuppressWarnings("serial")
public class GUI extends JFrame{

	/**
	 * @param args
	 * @author Teodoro
	 */
	
	private JPanel organizemiddle (){
		
		JLabel P1Tag,P2Tag;
		Frame Points[] = new Frame[10];
		JPanel Player1 = new JPanel();
		JPanel Player2 = new JPanel();
		JPanel organize = new JPanel();
		
		//GridBagConstraints j = new GridBagConstraints();
		Player1.setLayout(new GridLayout(0,10));
		for (int i=0; i<10;++i){
			if (i == 9){
				Points[i] = new Frame(true);
				Player1.add(Points[i]);
			}
			else {
				Points[i] = new Frame();
				Player1.add(Points[i]);
			}
		}
		
		Player2.setLayout(new GridLayout(0,10));
		for (int i=0; i<10;++i){
			if (i == 9){
				Points[i] = new Frame(true);
				Player2.add(Points[i]);
			}
			else {
				Points[i] = new Frame();
				Player2.add(Points[i]);
			}
		}
		
		
		organize.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		P1Tag = new JLabel("Jugador 1: ");
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		organize.add(P1Tag,c);
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10, 0, 10, 0);
		organize.add(Player1,c);
		
		P2Tag = new JLabel("Jugador 2: ");
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 2;
		organize.add(P2Tag,c);
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 9;
		organize.add(Player2,c);
		
		return organize;
	}
	
	@SuppressWarnings("unused")
	public void UI(){
		
		GridBagLayout bag = new GridBagLayout() ;
		Container cont = new Container();
		cont.setSize(5, 5);
		
		JPanel Background = new JPanel(bag);
		this.getContentPane().add(Background);
		JLabel sentence;
		JButton explore,prior,next;
		
		JPanel top = new JPanel();
		top.add(sentence = new JLabel("Seleccione un Archivo"));
		top.add(explore = new JButton("Explorar"));
		
		JPanel middle = new JPanel();
		middle.add(organizemiddle());
		
		JPanel bottom = new JPanel();
		bottom.add(prior = new JButton("Atras"));
		bottom.add(next = new JButton("Siguiente"));
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		Background.add(top,c);
		
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		Background.add(middle,c);
		
		c.gridx = 0;
		c.gridy = 3;
		Background.add(bottom,c);
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public GUI(){
		int[] Score1 = {10,0,5,5,4,6,1,2,3,4,5,5,10,0,1,9,0,3,3,7,3};
		int[] Score2 = {10,0,5,5,4,6,1,2,3,4,5,5,10,0,1,9,0,3,3,7,3};
		
		Ruler Playr1 = new Ruler();
		Ruler Playr2 = new Ruler();
		LogicFrame P1[] = new LogicFrame[10];
		LogicFrame P2[] = new LogicFrame[10];
		GameLog Reg = new GameLog();
		P1 = Playr1.Points(Score1);
		P2 = Playr2.Points(Score2);
		
		Reg.Log(P1, P2);
		UI();
	}
	
}


