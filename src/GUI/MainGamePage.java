package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import GUI.Components.SideBar;
import GUI.Components.TopMenuBar;

public class MainGamePage extends WindowAdapter implements ActionListener {
	
	
	/**
	 * Keeping the userDir in a constant variable
	 * 
	 */
	public static final String userDir = System.getProperty("user.dir");
	
	static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	

		
	static final int xSize = screenSize.width;
	static final int ySize = screenSize.height;
	
	
	
	JFrame frame;

	
	public MainGamePage() {
		
		/// frame
		
		//Assign page icon
		ImageIcon pageIcon = new ImageIcon(userDir + "\\img\\NBA_Logo.png");
		
		frame = new JFrame();
		
		frame.setIconImage(pageIcon.getImage());
		
		frame.setLayout(new BorderLayout());
		

	
		
		
		
		
		
		

		JLabel backgroundImage = new JLabel();
		
		//userDir + "\\img\\main_page_back.jpeg",
		String[] backGrounds = { userDir + "\\img\\main_back.jpg"};
		
		Random rd = new Random();
		
		int image = 0;
		
		ImageIcon pageBck = new ImageIcon(backGrounds[image]);
		
		
		backgroundImage.setIcon(new ImageIcon(pageBck.getImage().getScaledInstance(2000, 1200, Image.SCALE_SMOOTH)));
		
		
		// Set the bounds for the backgroundImage label
		backgroundImage.setBounds(0, 0, 2000, 1200);
		
		backgroundImage.setBackground(new Color(0x000000));
		
		/*backgroundImage.setForeground(new Color(0xFFFFFF));
		
		backgroundImage.setVerticalTextPosition(JLabel.CENTER);
		
		backgroundImage.setHorizontalTextPosition(JLabel.CENTER);
		
		backgroundImage.setFont(new Font("Gobold", Font.BOLD, 100));
		
		backgroundImage.setText("nba game simulation");*/
		
		backgroundImage.setOpaque(true);
		
		
		
		
		
		
		frame.addWindowListener(this);
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // I will change it later
		
		// Upper buttons disabled
		frame.setUndecorated(true); // change it
		
	
		
		//frame.setSize(1600, 1600); // Set the frame size to match the image size
		
		frame.setLocationRelativeTo(null);
		
		// Full Page
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		//frame.setBackground(new Color(0xDCE6F9));
		
		
		
		
		//////
		
		JPanel panel = new JPanel();
		
		panel.setOpaque(false);
		
		panel.setLayout(new BorderLayout());
		
		panel.setBounds(0,0,xSize, ySize);
		

		
		TopMenuBar tmb = new TopMenuBar(frame);
		
		
		
		
		SideBar sb = new SideBar(frame);
		
		
		
		
		
		
		
		JLayeredPane lPane = new JLayeredPane();
		
		panel.add(tmb, BorderLayout.NORTH);
		panel.add(sb, BorderLayout.WEST);
		
		lPane.add(panel, 2);
		
		lPane.add(backgroundImage, 4);
		
		
		
		frame.add(lPane, BorderLayout.CENTER);
		
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
