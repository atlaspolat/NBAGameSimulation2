package User;

import java.util.ArrayList;

import Utility.CSVReader;
import Utility.CSVWriter;

public class UserCreater {
	
	/**
	 * Keeping the userDir in a constant variable
	 * 
	 */
	public static final String userDir = System.getProperty("user.dir");
	
	public static String CreateUser(String name, String surname, String username, String age, String email, char[] password){
		
		
		if (!IsAlreadyExist(username, email).equals("Valid")) {
			return IsAlreadyExist(username, email);
		}
		
		
		String userData = String.format("%s,%s,%s,%s,%s,%s",username, name, surname, age, email, String.valueOf(password));
		
		CSVWriter.appendCSV(userData, "userData\\users.csv" , ",");
		
		
		return "Valid";
	}
	
	public static String IsAlreadyExist(String username, String email) {
		
		
		ArrayList<String[]> users = new ArrayList<>();
		
		
		CSVReader.readCSV(users, "userData\\users.csv", ",");
		
		for (String[] data : users) {
			
			
			if(data[0].equals(username)) {
				return "Existing username";
				
			}
			
			if(data[4].equals(email)) {
				
				return "Existing email";
			}
			
			
			
		}
		
		
		
		return "Valid";
		
	}

}
