package bowling;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Frame extends javax.swing.JPanel {
	

	private JLabel FS;				// First Shoot Label
	private JLabel SS;				//Second Shoot Label
	private JLabel TS;				// Third Shoot Label
	private JLabel TP;				// Total points Label
	boolean addsapce = true;
	private GridBagConstraints c = new GridBagConstraints();		//Initializes  the gridbagcosntraints to locate the labels in the panel
	
	public Frame (boolean add){
		setPreferredSize(new Dimension(100,100));
		
		setLayout(new GridBagLayout());
		FS = new JLabel("X");
		c.gridx = 1;
		c.gridy = 1;
		add(FS,c);
		
		SS = new JLabel("X");
		c.gridx = 5;
		c.gridy = 1;
		add(SS,c);
		
		TS = new JLabel("X");
		c.gridx = 5;
		c.gridy = 3;
		add(TS,c);
	}
	
	public Frame (){
		setPreferredSize(new Dimension(85,85));
		
		setLayout(new GridBagLayout());
		FS = new JLabel("X");
		c.gridx = 1;
		c.gridy = 1;
		add(FS,c);
		SS = new JLabel("X");
		c.gridx = 3;
		c.gridy = 1;
		add(SS,c);
		TP = new JLabel("X");
		c.gridx = 2;
		c.gridy = 3;
		add(TP,c);
		
		
	}
}
