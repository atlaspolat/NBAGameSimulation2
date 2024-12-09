package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import GUI.DraftingIntro;
import GUI.DraftingPage;
import MatchSeason.Season;
import Player.Player;
import User.User;

public class GameController {
	
	
	private static User user;
	
	private static Season season;
	
	private static String carrName;
	
	
	public static void initializeGame(User userIns) {
		user = userIns;
		
	
	}
	
	public static void startNewGame(String careerName) {
		
		
		
		
	
			
		
		
		
		Season season = user.userDataLogger.createNewGame(careerName);
		
		ArrayList<Player> draftingSquad = season.getDraftingSquad(); 
		
		
		Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new DraftingPage(draftingSquad, season);
            }
        });
        timer.setRepeats(false); // Execute only once
        timer.start();
		
		
		
		carrName = careerName;
		
	
	}
	
	

	public static Season getSeason() {
		return season;
	}

	public static void setSeason(Season season) {
		GameController.season = season;
	}

	public static String getCarrName() {
		return carrName;
	}

	public static void setCarrName(String carrName) {
		GameController.carrName = carrName;
	}
	
	
	

}
