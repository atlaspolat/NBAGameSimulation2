package GUI.Components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.DraftingIntro;
import GUI.DraftingPage;
import Main.GameController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;




@SuppressWarnings("serial")
public class SideBar extends JPanel implements ActionListener{
	
	
	MenuButton newGameButton; 
	MenuButton continueButton;
	MenuButton profileButton;
	MenuButton settingsButton;
	
	
	JFrame parent;
	
	
	Color backColor = new Color(0x17408B);

	public SideBar(JFrame parent) {
		// TODO Auto-generated constructor stub
		
		this.parent = parent;
		
		this.setLayout(new GridLayout(5,1, 10, 10));
		
		this.setBackground(new Color(0x0004CF));
		
		this.setOpaque(false);
		
		this.setBounds(0,100, 500, 1000);
		
		
	
		
		
		newGameButton = new MenuButton("New Career");
		continueButton = new MenuButton("Load Career");
		profileButton = new MenuButton("Profile");
		settingsButton = new MenuButton("Settings");
		
		
		
		newGameButton.addActionListener(this);
		continueButton.addActionListener(this);
		settingsButton.addActionListener(this);
		profileButton.addActionListener(this);
		
		JLabel empty = new JLabel();
		
		
		empty.setBounds(0,  0, 100, 100);
		
		
		this.add(empty);
		this.add(newGameButton);
		this.add(continueButton);
		this.add(profileButton);
		this.add(settingsButton);
	
		
		this.setPreferredSize(new Dimension(500, 1000));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource() == newGameButton) {
			
			String answer = JOptionPane.showInputDialog(null, "Give a name to your Team and start", "NBA Game Simulation", JOptionPane.PLAIN_MESSAGE);
			
			if(answer!=null) {
				
				DraftingIntro dI = new DraftingIntro();
				
				parent.dispose();
				GameController.startNewGame(answer);
				
			}
			
			
			
		}
		
		if(e.getSource() == settingsButton) {
			
			
			
		}

		if(e.getSource() == continueButton) {
	
	
	
		}
		
	}

}
