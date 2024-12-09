package GUI.Components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Player.Player;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerInfo extends JFrame {
	
	/**
	 * Keeping the userDir in a constant variable
	 * 
	 */
	public static final String userDir = System.getProperty("user.dir");

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PlayerInfo(Player player) {
		setBackground(new Color(201, 8, 42));
		setIconImage(Toolkit.getDefaultToolkit().getImage(userDir + "\\img\\NBA_Logo.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		contentPane.add(rigidArea);
		
		JLabel lblNewLabel = new JLabel(player.getName());
		lblNewLabel.setForeground(new Color(23, 64, 139));
		lblNewLabel.setFont(new Font("Gobold", Font.BOLD, 20));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNewLabel);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		contentPane.add(rigidArea_1);
		
		JLabel lblNewLabel_1 = new JLabel(String.format("%s -- %d", player.getPosition().name(), player.getAge()));
		lblNewLabel_1.setForeground(new Color(201, 8, 42));
		lblNewLabel_1.setFont(new Font("Gobold", Font.BOLD, 16));
		lblNewLabel_1.setAlignmentX(0.5f);
		contentPane.add(lblNewLabel_1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		contentPane.add(rigidArea_2);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		JLabel lblNewLabel_1_1 = new JLabel(String.format("%s:%f", "RBT" ,player.getStats()[0]));
		lblNewLabel_1_1.setFont(new Font("Gobold", Font.BOLD, 16));
		lblNewLabel_1_1.setAlignmentX(0.5f);
		panel.add(lblNewLabel_1_1);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_3);
		
		JLabel lblNewLabel_1_1_1 =  new JLabel(String.format("%s:%f", "ATC" ,player.getStats()[1]));
		lblNewLabel_1_1_1.setFont(new Font("Gobold", Font.BOLD, 16));
		lblNewLabel_1_1_1.setAlignmentX(0.5f);
		panel.add(lblNewLabel_1_1_1);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_4);
		
		JLabel lblNewLabel_1_1_1_1 =  new JLabel(String.format("%s:%f", "STL" ,player.getStats()[2]));
		lblNewLabel_1_1_1_1.setFont(new Font("Gobold", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setAlignmentX(0.5f);
		panel.add(lblNewLabel_1_1_1_1);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_5);
		
		JLabel lblNewLabel_1_1_1_1_1 =  new JLabel(String.format("%s:%f", "FRC" ,player.getStats()[3]));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Gobold", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setAlignmentX(0.5f);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_6);
		
		JLabel lblNewLabel_1_1_1_1_1_1 =  new JLabel(String.format("%s:%f", "ORC" ,player.getStats()[4]));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Gobold", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1_1.setAlignmentX(0.5f);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		contentPane.add(rigidArea_7);
		
		JButton btnNewButton = new JButton("get the player");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Gobold Bold", Font.PLAIN, 23));
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(btnNewButton);
		
		
		
		btnNewButton.setHorizontalTextPosition(JButton.CENTER);
		
		btnNewButton.setVerticalTextPosition(JButton.CENTER);

		btnNewButton.setForeground(new Color(0xFFFFFF));
		
		btnNewButton.setBackground(new Color(0,0,0,0));
		
		btnNewButton.setFocusable(false);
		
		 // Disable border painting
		btnNewButton.setBorderPainted(false);
		
		// Disable background change on hover
		btnNewButton.setContentAreaFilled(false);
        
        // Disable border change on click
		btnNewButton.setBorderPainted(false);
		
		
		btnNewButton.setBorder(null);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		contentPane.add(rigidArea_8);
		
		
		this.setVisible(true);
	}

}
