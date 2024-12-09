package GUI.Components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class TopMenuBar extends JPanel implements ActionListener{
	
	
	CustomizedButton exitButton; 
	CustomizedButton saveButton;
	CustomizedButton settingsButton;
	CustomizedButton profileButton;
	
	
	JFrame parent;
	
	public JPanel right;
	public JPanel middle;
	public JPanel left;
	
	
	Color backColor = new Color(0x17408B);
	
	public TopMenuBar(JFrame parent) {
		
		
		this.parent = parent;
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
		
		this.setOpaque(false);
		
		JPanel right = new JPanel();
		JPanel middle = new JPanel();
		JPanel left = new JPanel();
		
		right.setOpaque(false);
		middle.setOpaque(false);
		left.setOpaque(false);
		
		
		exitButton = new CustomizedButton("Exit");
		saveButton = new CustomizedButton("Save");
		profileButton = new CustomizedButton("Profile");

		settingsButton = new CustomizedButton("Settings");
		
		exitButton.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		saveButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		profileButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		settingsButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		
		exitButton.addActionListener(this);
		saveButton.addActionListener(this);
		profileButton.addActionListener(this);
		settingsButton.addActionListener(this);
		
		
		profileButton.setVisible(false);
		settingsButton.setVisible(false);
		saveButton.setVisible(false);

		
		
		right.add(settingsButton);
		right.add(saveButton);
		right.add(exitButton);
		
		left.add(profileButton);
		
		
		
		
		
		right.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		left.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		
		
		this.add(left);
		this.add(middle);
		this.add(right);
		
		this.setPreferredSize(new Dimension(100, 70));
		
		
		
	}
	
	public void enableOtherButtons() {
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource() == exitButton) {
			
			/*int a = JOptionPane.showConfirmDialog(parent,"Do you want to exit?", "NBA Game Simulation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);  
		    
			if (a == JOptionPane.YES_OPTION)
			{ */ 
				
			    parent.dispose(); 
			    System.exit(0);
			    
			    
			//} 
			
			
		}
		

		if(e.getSource() == saveButton) {
	
	
	
		}
		
	}

}

