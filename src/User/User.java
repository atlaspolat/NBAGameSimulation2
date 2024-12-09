package User;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

import Utility.CSVReader;

/**
 * Represents a user with basic information.
 */
public class User {

    /**
     * User's nickname.
     */
    private String nickname;

    /**
     * User's first name.
     */
    private String name;

    /**
     * User's last name.
     */
    private String surname;

    /**
     * User's age.
     */
    private int age;

    /**
     * User's email address.
     */
    private String email;

    /**
     * User's password.
     */
    private String password;
    
    
    private String dataFolderPath;
    
    
    public DataLogger userDataLogger;

    /**
     * Constructor for User class with all parameters.
     *
     * @param nickname The user's nickname.
     * @param name     The user's first name.
     * @param surname  The user's last name.
     * @param age      The user's age.
     * @param email    The user's email address.
     * @param password The user's password.
     */
    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
        
        
        getAllInfo(nickname, password);
        
        userDataLogger =  new DataLogger(this);
    }
    
    
    private void getAllInfo(String nickname, String password) {
    	
    	
    	ArrayList<String[]> users = new ArrayList<>();
		
		
		CSVReader.readCSV(users, "userData\\users.csv", ",");
		
		String[] userData = new String[6];
		
		for (String[] data : users) {
			
			
			if(data[0].equals(nickname) && data[5].equals(password)) {
				userData = data.clone();
				break;
			}
			
			
		}
		
		for (String string : userData) {
			System.out.println(string);
		}
		
		setName(userData[1]);
		setSurname(userData[2]);
		
		setAge(Integer.parseInt(userData[3]));
		setEmail(userData[4]);
		
		dataFolderPath = "userData\\" + this.hashCode();
    	
    }
    
    /**
	 * Keeping the userDir in a constant variable
	 * 
	 */
    
	public static final String userDir = System.getProperty("user.dir");
    
    public static void createDataDirectory(String nickname,String email) {
    	
    	File theDir = new File(userDir + "\\userData\\" + Objects.hash(email, nickname));
    	if (!theDir.exists()){
    	    theDir.mkdirs();
    	}
    	
    	File teamsFile = new File(userDir + "\\userData\\" + Objects.hash(email, nickname) + "\\teams.txt");
    	
    	try {
    		teamsFile.createNewFile();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    
    ////////////////////////////////////// hash code and equals ////////////////////////////////////////
    
    @Override
   	public int hashCode() {
   		return Objects.hash(email, nickname);
   	}



   	@Override
   	public boolean equals(Object obj) {
   		if (this == obj)
   			return true;
   		if (obj == null)
   			return false;
   		if (getClass() != obj.getClass())
   			return false;
   		User other = (User) obj;
   		return age == other.age && Objects.equals(email, other.email) && Objects.equals(name, other.name)
   				&& Objects.equals(nickname, other.nickname) && Objects.equals(password, other.password)
   				&& Objects.equals(surname, other.surname);
   	}

    
    
    
    ////////////////////////////////////// getter & setters ///////////////////////////////////////////////

    /**
     * Get the user's nickname.
     *
     * @return The user's nickname.
     */
    public String getNickname() {
        return nickname;
    }

   
    public String getDataFolderPath() {
    	return dataFolderPath;
    	
    }


	/**
     * Set the user's nickname.
     *
     * @param nickname The new nickname to set.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Get the user's first name.
     *
     * @return The user's first name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the user's first name.
     *
     * @param name The new first name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the user's last name.
     *
     * @return The user's last name.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set the user's last name.
     *
     * @param surname The new last name to set.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Get the user's age.
     *
     * @return The user's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the user's age.
     *
     * @param age The new age to set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the user's email address.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email address.
     *
     * @param email The new email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the user's password.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password.
     *
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
