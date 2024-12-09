package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GUI.Components.CustomizedButton;
import GUI.Components.CustomizedHeading;
import GUI.Components.CustomizedLabel;
import GUI.Components.CustomizedPasswordField;
import GUI.Components.CustomizedTextField;
import User.User;
import User.UserCreater;
import User.UserInfoFilter;



public class SignupPage extends WindowAdapter implements ActionListener {
	
	/**
	 * Keeping the userDir in a constant variable
	 * 
	 */
	public static final String userDir = System.getProperty("user.dir");
	
	
	JFrame frame;
	
	CustomizedButton loginButton; 
	CustomizedButton signupButton;
	
	
	CustomizedTextField userNameField;
	CustomizedTextField nameField;
	CustomizedTextField surnameField;
	CustomizedTextField ageField;
	CustomizedTextField emailField;
	
	CustomizedPasswordField userPasswordField;
	CustomizedPasswordField repeatPasswordField;
	
	ImageIcon pageIcon;
	
	
	CustomizedLabel messageLabel;
	/**
	 * 
	 * Constructor for the Launch Page
	 *
	 * 
	 */

	public SignupPage() {
		// TODO Auto-generated constructor stub
		
		
		//Assign page icon
		pageIcon = new ImageIcon(userDir + "\\img\\NBA_Logo.png");

	
		
		frame = new JFrame();
		
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // I will change it later
		frame.setLayout(new BorderLayout());
		
		//frame.addWindowListener(this);
		
		
		
		frame.setSize(750, 750);
		frame.setLocationRelativeTo(null);
		
		frame.setIconImage(pageIcon.getImage());
		
		CustomizedHeading heading = new CustomizedHeading("Sign-Up", 35);
		
		heading.setBounds(100,10,350, 80);
		
		heading.setHorizontalAlignment(JLabel.CENTER);
		
		frame.add(heading);
		
	
	
		loginButton = new CustomizedButton("Log In");
		signupButton = new CustomizedButton("Sign Up");
		
		 userNameField = new CustomizedTextField();
		 nameField = new CustomizedTextField();
		 surnameField = new CustomizedTextField();
		 ageField = new CustomizedTextField();
		 emailField = new CustomizedTextField();
		
		 userPasswordField = new CustomizedPasswordField();
		 repeatPasswordField = new CustomizedPasswordField();
		
		
		CustomizedLabel userNameLabel = new CustomizedLabel("Nickname:");
		CustomizedLabel nameLabel = new CustomizedLabel("Name:");
		CustomizedLabel surnameLabel = new CustomizedLabel("Surname:");
		CustomizedLabel ageLabel = new CustomizedLabel("Age:");
		CustomizedLabel emailLabel = new CustomizedLabel("Email:");
		
		CustomizedLabel userPasswordLabel = new CustomizedLabel("Password:");
		CustomizedLabel repeatPasswordLabel = new CustomizedLabel("Repeat Password:");
		
		messageLabel = new CustomizedLabel();

		
			
			userNameLabel.setBounds(100,100,150,30);
			nameLabel.setBounds(100,150,150,30);
			surnameLabel.setBounds(100,200,150,30);
			ageLabel.setBounds(100,250,150,30);
			emailLabel.setBounds(100,300,150,30);
			userPasswordLabel.setBounds(100,350,150,30);
			repeatPasswordLabel.setBounds(100,400,150,30);
			
			
			
			messageLabel.setBounds(50,500,425,35);
			messageLabel.setFont(new Font(null,Font.ITALIC,15));
			messageLabel.setHorizontalTextPosition(JLabel.CENTER);
			
			
			userNameField.setBounds(250,100,200,30);
			nameField.setBounds(250,150,200,30);
			surnameField.setBounds(250,200,200,30);
			ageField.setBounds(250,250,200,30);
			emailField.setBounds(250,300,200,30);
			userPasswordField.setBounds(250,350,200,30);
			repeatPasswordField.setBounds(250,400,200,30);
	
			

		
			
			loginButton.setBounds(100,450,150,40);
			loginButton.setFocusable(false);
			loginButton.addActionListener(this);
			
			signupButton.setBounds(300,450,150,40);
			signupButton.setFocusable(false);
			signupButton.addActionListener(this);
			
			
			
			
			frame.add(userNameLabel);
			frame.add(nameLabel);
			frame.add(surnameLabel);
			frame.add(ageLabel);
			frame.add(emailLabel);
			frame.add(userPasswordLabel);
			frame.add(repeatPasswordLabel);
			
			
			frame.add(userNameField);
			frame.add(nameField);
			frame.add(surnameField);
			frame.add(ageField);
			frame.add(emailField);
			frame.add(userPasswordField);
			frame.add(repeatPasswordField);
			
			
			frame.add(loginButton);
			frame.add(signupButton);
			
			frame.add(messageLabel);
			
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(550,600);
			frame.setLayout(null);
			frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==signupButton) {
			
			
			 
			
			String answer = UserInfoFilter.validateUserInfo(nameField.getText(), surnameField.getText(), userNameField.getText(), ageField.getText(), emailField.getText(), userPasswordField.getPassword(), repeatPasswordField.getPassword());
			
			
			if(answer.equals("Valid")) {
				
				
				String result = UserCreater.CreateUser(nameField.getText(),  surnameField.getText(), userNameField.getText(), ageField.getText(), emailField.getText(), userPasswordField.getPassword());
				
				
				if(!result.equals("Valid")) {
					
					JOptionPane.showMessageDialog(frame, result, "NBA Game Simulation", JOptionPane.WARNING_MESSAGE);
					
				}else {
					
					JOptionPane.showMessageDialog(frame, "Succesfully Signed Up", "NBA Game Simulation", JOptionPane.PLAIN_MESSAGE);
					
					User.createDataDirectory(userNameField.getText(), emailField.getText());
					
					new LoginPage();
					frame.dispose();
				}
				
				
				
				
			}else {
				
				JOptionPane.showMessageDialog(frame, answer, "NBA Game Simulation", JOptionPane.WARNING_MESSAGE);
		
			}
			
			
			System.out.println(answer);
			
			
			
			
			
		}
		
		if(e.getSource()==loginButton) {
			
			new LoginPage();
			frame.dispose();
			
			

			}
		}
	
	
	public void windowClosing(WindowEvent e) {
		
	    int a = JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "NBA Game Simulation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);  
	    
	if (a == JOptionPane.YES_OPTION)
	{  
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	} 
	
	
	}	
	}	