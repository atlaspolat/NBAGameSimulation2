package Player;

/**
 * Represents a basketball player with basic information, including ID, name,
 * position, team, and statistics.
 */
public class Player {

    private int id;
    private String name;
    private Position position;
    private int age;
  

	private Teams team;
    private double[] stats;

    /**
     * Default constructor for the Player class.
     */
    public Player() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor to initialize a Player with specific information.
     *
     * @param id       The unique identifier for the player.
     * @param name     The name of the player.
     * @param position The player's position (e.g., Point Guard, Shooting Guard, etc.).
     * @param team     The team to which the player belongs.
     * @param stats    An array representing the player's statistics.
     */
    public Player(int id, String name, Position position, int age,Teams team, double[] stats) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
        this.team = team;
        this.stats = stats;
    }
    
    
    public Player(String[] data) {
        this.id = Integer.valueOf(data[0]);
        this.name = data[1];
        this.position = Position.valueOf(data[2]);
        this.age = Integer.valueOf(data[3]);
        this.team = Teams.valueOf(data[4]);
        
        double[] stats = {Double.valueOf(data[5]), Double.valueOf(data[6]), Double.valueOf(data[7]), Double.valueOf(data[8]), Double.valueOf(data[9]) };
        
        this.stats = stats;
    }
    
    
    public String[] getPlayersData() {
    	
    	String[] data = new String[10];
    	
    	data[0] = Integer.toString(id);
    	data[1] = name;
    	data[2] = position.toString();
    	data[3] = Integer.toString(age);
    	data[4] = team.toString();
    	data[5] = Double.toString(stats[0]);
    	data[6] = Double.toString(stats[1]);
    	data[7] = Double.toString(stats[2]);
    	data[8] = Double.toString(stats[3]);
    	data[9] = Double.toString(stats[4]);
    	
    	
    	
    	return data;
    }

    /**
     * Gets the unique identifier of the player.
     *
     * @return The player's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the player.
     *
     * @param id The player's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the player.
     *
     * @return The player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player.
     *
     * @param name The player's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the position of the player.
     *
     * @return The player's position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the position of the player.
     *
     * @param position The player's position.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Gets the team to which the player belongs.
     *
     * @return The player's team.
     */
    public Teams getTeam() {
        return team;
    }

    /**
     * Sets the team to which the player belongs.
     *
     * @param team The player's team.
     */
    public void setTeam(Teams team) {
        this.team = team;
    }

    /**
     * Gets the statistics of the player.
     *
     * @return An array representing the player's statistics.
     */
    public double[] getStats() {
        return stats;
    }

    /**
     * Sets the statistics of the player.
     *
     * @param stats An array representing the player's statistics.
     */
    public void setStats(double[] stats) {
        this.stats = stats;
    }
    
    
    public int getAge() {
  		return age;
  	}

  	public void setAge(int age) {
  		this.age = age;
  	}
}