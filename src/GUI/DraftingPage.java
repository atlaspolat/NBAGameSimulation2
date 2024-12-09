package GUI;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import GUI.Components.PlayerCard;
import GUI.Components.PlayerCardTest;
import GUI.Components.SideBar;
import GUI.Components.TopMenuBar;
import MatchSeason.Season;
import Player.Player;

public class DraftingPage extends WindowAdapter implements ActionListener {
	
	
	static Random rd = new Random();
	
	/**
	 * Keeping the userDir in a constant variable
	 * 
	 */
	public static final String userDir = System.getProperty("user.dir");
	
	static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	

		
	static final int xSize = screenSize.width;
	static final int ySize = screenSize.height;
	
	
	
	JFrame frame;

	
	public DraftingPage(ArrayList<Player> draftingSquad, Season season) {
		
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
		
		backgroundImage.setOpaque(true);
			
		
		frame.addWindowListener(this);
		
		
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
		
		panel.setBounds(0,0,xSize, ySize);
		
		panel.setLayout(new GridLayout(4, 8, 10, 10));
		
		
		ArrayList<PlayerCardTest> cardList = new ArrayList<>();
		
		for (int i = 0; i < draftingSquad.size(); i++) {
			
			Player player = draftingSquad.get(i);
			
			PlayerCardTest newCard = new PlayerCardTest(player.getName(), player.getPosition().name() + " -- " + String.valueOf(player.getAge()), player);
			
			cardList.add(newCard);
			
			panel.add(newCard);
			
		}
		
		
		
		
		
		
		
		

		
		
		
		
		JLayeredPane lPane = new JLayeredPane();
		
		
		lPane.add(panel, 2);
		
		lPane.add(backgroundImage, 4);
		
		
		
		frame.add(lPane, BorderLayout.CENTER);
		
		
		frame.setVisible(true);
		
		 SwingUtilities.invokeLater(() -> {
			  
			 
			 
			 for (int i = 0; i < 15; i++) {
					
					int index = rd.nextInt(cardList.size());
					
					cardList.get(index).setVisible(false);
					
					
					// Schedule the task to hide the card after a delay
		            Timer timer = new Timer(1000 * i + 5000, new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	cardList.get(index).setVisible(false);
		                	cardList.get(index).revalidate();
		                	cardList.get(index).repaint();
		                	
		                	frame.revalidate();
		                	frame.repaint();
		                }
		            });
		            timer.setRepeats(false); // Run only once
		            timer.start();
		        }
			 
			 
	        });
		
		
		
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
