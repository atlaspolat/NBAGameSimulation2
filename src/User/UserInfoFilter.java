package User;


/**
 * 
 * Validate user info on the signup page
 * 
 * 
 */
public class UserInfoFilter {
	
	
	/**
	 * 
	 * Validates each field and if there 
	 * is a problem with the user info
	 * returns the error message
	 * 
	 * @param name string
	 * @param surname
	 * @param username
	 * @param age
	 * @param email
	 * @param password1
	 * @param password2
	 * @return the error message
	 */
	
	public static String validateUserInfo(String name, String surname, String username, String age, String email, char[] password1, char[] password2) {
        // Add validation logic for each field
        if (!checkName(name)) {
            return "Invalid name, name should have at least three characters (only letters).";
        }

        if (!checkSurname(surname)) {
            return "Invalid surname, surname should have at least three characters (only letters).";
        }

        if (!checkUsername(username)) {
            return "Invalid username. Username can only include letter and number characters.";
        }
        
        try {       	
        	
        	if (!checkAge(Integer.parseInt(age))) {
            return "Invalid age, age must be at least 12 and should be a reasonable number.";
        }
			
		} catch (NumberFormatException  e) {
			// TODO: handle exception
			return "Invalid age, age must consist of digits";
		}

       

        if (!checkEmail(email)) {
            return "Invalid email, the email address should be in the correct format. (e.g., name@domain.com)";
        }
        
        

        if (!checkPassword(String.valueOf(password1), String.valueOf(password2))) {
        	
        	System.out.println(String.valueOf(password1));
            return "Invalid password, password should be at least eight characters, including letters, numbers, and " 
            		+ "special characters.";
        }

        return "Valid";
    }
	
	
	
	/**
	 * check if the name has more than 3 characters
	 * and consist of only letters
	 * 
	 * @param name string name
	 * @return
	 */
	
	public static boolean checkName(String name) {
		
		
		return name.length() >= 3 && name.matches("[A-Za-z]+");
		
	}
	
	/**
	 * check if the surname has more than 3 characters
	 * and consist of only letters
	 * 
	 * @param surname string name
	 * @return
	 */
	
	public static boolean checkSurname(String surname) {
		
		return checkName(surname);
		
	}
	
	
	/**
	 * check if the user name only contains letters and digits
	 * 
	 * @param user name
	 * @return 
	 */
	
	public static boolean checkUsername(String username) {
		
		
		return username.length() > 0 && username.matches("[A-Za-z0-9]+");
		
	}
	
	/**
	 * check if the age is over 12 or so
	 * 
	 * @param age int age of the user
	 * @return
	 */
	
	
	public static boolean checkAge(int age) {
		
		
		return age >= 12 && age <= 99;
	}
	
	
	/**
	 * 
	 * check if the given string is a valid email address
	 * using regex expressions
	 * 
	 * @param email a valid email string
	 * @return
	 */
	
	
	public static boolean checkEmail(String email) {
		
		
		return email.length() >= 5 && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
		
	}
	
	/**
	 * 
	 * check the validity of the passwords
	 * 
	 * @param password
	 * @return
	 */
	
	
	public static boolean checkPassword(String password1, String password2) {
		
		if(!password1.equals(password2))
		{
			System.out.println("Pss doesnt match");
			return false;
		}
		
		return password1.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&.:])[A-Za-z\\d@$!%*#?&.:]{8,}$");
		
	}
	
	

}
