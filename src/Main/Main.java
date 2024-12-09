package Main;

import javax.swing.JOptionPane;

/************** Pledge of Honor ******************************************
I hereby certify that I have completed this programming project on my own
without any help from anyone else. The effort in the project thus belongs
completely to me. I did not search for a solution, or I did not consult any
program written by others or did not copy any program from other sources. I
read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Muhammed Polat, 80480>
*************************************************************************/

import javax.swing.SwingUtilities;

import GUI.*;
import User.User;

/**
 * 
 * Main Class to execute the program
 * 
 * 
 */



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initializing a launch page;
		
		
		
		try {
			
			LaunchPage lp = new LaunchPage(() -> {
				
				LoginPage pg = new LoginPage();
				
			});
			
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(null, "An error occured", "NBA Game Simulation", JOptionPane.WARNING_MESSAGE);
		}
		
		/*User user = new User("PolathanGames", "mupo123*");
		
		
		GameController.initializeGame(user);
		
		  SwingUtilities.invokeLater(() -> {
			  new MainGamePage();
	        });*
		
		
		/*DraftingIntro lp = new DraftingIntro(() -> {
			
			LoginPage pg = new LoginPage();
			
		});*/

	}

}
