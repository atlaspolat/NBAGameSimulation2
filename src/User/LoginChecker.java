package User;

import java.util.ArrayList;

import Utility.CSVReader;

/**
 * 
 * This class checks if the given password and user name
 * corresponce to already existing user
 * 
 */

public class LoginChecker {
	
	
	public static String checkUser(String username, String password){
		
		ArrayList<String[]> users = new ArrayList<>();
		
		
		CSVReader.readCSV(users, "userData\\users.csv", ",");
		
		for (String[] data : users) {
			
			
			if(data[0].equals(username) && data[5].equals(password)) {
				return "Valid";
				
			}
			
			
		}
		
		
		
		return "No User with given username and password!";


	}

}
