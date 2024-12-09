package GUI.Components;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;

import Player.Player;

import java.awt.Color;
import javax.swing.Box;
import java.awt.Dimension;

public class PlayerCardTest extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PlayerCardTest(String name, String agePos, Player player) {
		setBackground(new Color(201, 8, 42));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		add(rigidArea_2);
		
		JLabel lblNewLabel = new JLabel(name);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Gobold Bold", Font.PLAIN, 20));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblNewLabel);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		add(rigidArea_1);
		
		JLabel lblNewLabel_1 = new JLabel(agePos);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Gobold Uplow", Font.BOLD, 20));
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblNewLabel_1);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		add(rigidArea);
		
		Component glue = Box.createGlue();
		add(glue);
		
		JButton btnNewButton = new JButton("See Statistics");
		btnNewButton.setFont(new Font("Gobold Bold", Font.BOLD, 25));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(23, 64, 139));
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setOpaque(false);
		
		
		btnNewButton.addActionListener((e) -> {
			
			new PlayerInfo(player);
			
		});

		add(btnNewButton);
		
		btnNewButton.setHorizontalTextPosition(JButton.CENTER);
		
		btnNewButton.setVerticalTextPosition(JButton.CENTER);
		
		// Disable border change on click
		btnNewButton.setBorderPainted(false);
				
				 // Disable border painting
		btnNewButton.setBorderPainted(false);
				
		btnNewButton.setFocusable(false);
				

				
		btnNewButton.setBorder(null);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		add(rigidArea_5);
		
		
		
		
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		add(rigidArea_4);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		add(rigidArea_3);
		
		
		

	}

}
