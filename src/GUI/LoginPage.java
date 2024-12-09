package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GUI.Components.CustomizedButton;
import GUI.Components.CustomizedLabel;
import GUI.Components.CustomizedPasswordField;
import GUI.Components.CustomizedTextField;
import Main.GameController;
import User.LoginChecker;
import User.User;

public class LoginPage extends WindowAdapter implements ActionListener   {
	
	/**
	 * Keeping the userDir in a constant variable
	 * 
	 */
	public static final String userDir = System.getProperty("user.dir");
	
	JFrame frame;
	CustomizedButton loginButton; 
	CustomizedButton signupButton;
	
	ImageIcon pageIcon;
	
	
	CustomizedTextField userNameField;
	CustomizedPasswordField userPasswordField;
	
	/**
	 * 
	 * Constructor for the Launch Page
	 *
	 * 
	 */

	public LoginPage() {
		// TODO Auto-generated constructor stub
		
		
		//Assign page icon
		pageIcon = new ImageIcon(userDir + "\\img\\NBA_Logo.png");
		ImageIcon gameLogo = new ImageIcon(pageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH));
	
		
		frame = new JFrame();
		
		//frame.addWindowListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // I will change it later
		frame.setLayout(new BorderLayout());
		
		
		frame.setResizable(false);
		
		frame.setLocationRelativeTo(null);
		
		frame.setIconImage(pageIcon.getImage());
		
		
		JLabel logoLabel = new JLabel();
		
		logoLabel.setIcon(gameLogo);
		
		logoLabel.setBounds(75, 25, 500, 200);
		
		frame.add(logoLabel);
		
	
	
		loginButton = new CustomizedButton("Log In");
		signupButton = new CustomizedButton("no account sign up now");
		userNameField = new CustomizedTextField();
		userPasswordField = new CustomizedPasswordField();
		CustomizedLabel userIDLabel = new CustomizedLabel("User Name:");
		CustomizedLabel userPasswordLabel = new CustomizedLabel("Password:");
		CustomizedLabel messageLabel = new CustomizedLabel();

		
			
			userIDLabel.setBounds(100,250,150,30);
			userPasswordLabel.setBounds(100,300,150,30);
			
			messageLabel.setBounds(250,500,250,35);
			messageLabel.setFont(new Font(null,Font.ITALIC,25));
			
			userNameField.setBounds(250,250,200,30);
			userPasswordField.setBounds(250,300,200,30);
			
			

		
			
			loginButton.setBounds(100,350,350,40);
			loginButton.setFocusable(false);
			loginButton.addActionListener(this);
			
			signupButton.setBounds(100,400,350,40);
			signupButton.setFocusable(false);
			signupButton.addActionListener(this);
			
			
			
			
			frame.add(userIDLabel);
			frame.add(userPasswordLabel);
			frame.add(messageLabel);
			frame.add(userNameField);
			frame.add(userPasswordField);
			frame.add(loginButton);
			frame.add(signupButton);
			
			

			frame.setSize(550,600);
			frame.setLayout(null);
			frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==signupButton) {
			
			new SignupPage();
			frame.dispose();
			
			
		}
		
		if(e.getSource()==loginButton) {
			
			String answer  = LoginChecker.checkUser(userNameField.getText(), String.valueOf(userPasswordField.getPassword()));
			
			if(!answer.equals("Valid")) {
				
				JOptionPane.showMessageDialog(frame, answer, "NBA Game Simulation", JOptionPane.WARNING_MESSAGE);
			}else {
				
				
				User user = new User(userNameField.getText(), String.valueOf(userPasswordField.getPassword()));
				
				
				GameController.initializeGame(user);
				
				
				new MainGamePage();
				frame.dispose();
				
			}
			
			

			}
		}
	
	
	public void windowClosing(WindowEvent e) {
		
	    int a = JOptionPane.showConfirmDialog(frame,"Do you want to exit?", "NBA Game Simulation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);  
	    
	if (a == JOptionPane.YES_OPTION)
	{  
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	} 
	
	
	}	
}






