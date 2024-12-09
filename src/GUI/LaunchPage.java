package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Main.NextPageLaunch;

public class LaunchPage {
	
	/**
	 * Keeping the userDir in a constant variable
	 * 
	 */
	public static final String userDir = System.getProperty("user.dir");
	
	
	/**
	 * 
	 * Constructor for the Launch Page
	 *
	 * 
	 */
	public LaunchPage (NextPageLaunch npl){
		
		
		
		//Assign page icon
		ImageIcon pageIcon = new ImageIcon(userDir + "\\img\\PolathanGamesLogo.png");
		
		
		// Create a standart frame
		JFrame frame = new JFrame();
		
		
		
		
		// Full Page
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		// Upper buttons disabled
		frame.setUndecorated(true);
		
		// Page Icon
		frame.setIconImage(pageIcon.getImage());
		
		
		frame.setLayout(new BorderLayout());
		
		JLabel label = new JLabel();
		
		label.setIcon(pageIcon);
		
		//label.setText("ea sports cooperated with polathan Games \n 2024");
		
		label.setVerticalTextPosition(JLabel.BOTTOM);
		
		label.setHorizontalTextPosition(JLabel.CENTER);
		
		label.setHorizontalAlignment(JLabel.CENTER);
		
		label.setIconTextGap(25);
		
		label.setBackground(new Color(0xC9082A));
		
		label.setForeground(new Color(0xFFFFFF));
		
		
		label.setFont(new Font("Gobold", Font.BOLD, 50));
		
		frame.add(label, BorderLayout.CENTER);
		
		// Visibility turned on
		frame.setVisible(true);
		
		label.setOpaque(true);
		
		try {
			Thread.sleep(4000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ImageIcon pageBck = new ImageIcon(userDir + "\\img\\polathanGamesBack.jpg");
		
		label.setIcon(new ImageIcon(pageBck.getImage().getScaledInstance(2100, 2100, Image.SCALE_SMOOTH)));
		
		label.setBackground(new Color(0xC9082A));
		
		label.setForeground(new Color(0xFFFFFF));
		
		label.setVerticalTextPosition(JLabel.CENTER);
		
		label.setHorizontalTextPosition(JLabel.CENTER);
		
		label.setFont(new Font("Gobold", Font.BOLD, 100));
		
		label.setText("nba game simulation");
		
		label.setOpaque(true);
		
		
		try {
			Thread.sleep(4000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		// close the window
		frame.dispose();
		
		npl.startPage();
		
		
		
		
	}

}
