package User;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

import MatchSeason.Season;
import Player.Player;
import Player.Teams;
import Team.Team;
import Utility.CSVReader;
import Utility.CSVWriter;
import Utility.Permutation;

public class DataLogger {
	
	
	private Random rd;

	

	/**
	 * Keeping the userDir in a constant variable
	 * 
	 */
	public static final String userDir = System.getProperty("user.dir");
	
	
	private User owner;
	 
	 
	public DataLogger(User user) {
		// TODO Auto-generated constructor stub
		
		owner = user;
	}
	
	public void saveTeams() {
		
		
		// bla blas
	}
	
	public Season createNewGame(String careerName) {
		
  		File theDir = new File(userDir + "\\" + owner.getDataFolderPath() + "\\" + careerName);
		
    	if (!theDir.exists()){
    	    theDir.mkdirs();
    	}
		
		File file = new File(userDir + "\\" + owner.getDataFolderPath() + "\\" + careerName + "\\freePlayers.csv");

		
		if(!file.exists()) {
			try {
	    		file.createNewFile();
	    		
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		file = new File(userDir + "\\" + owner.getDataFolderPath() + "\\" + careerName + "\\scoreTable.csv");

		
		if(!file.exists()) {
			try {
	    		file.createNewFile();
	    		
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		file = new File(userDir + "\\" + owner.getDataFolderPath() + "\\" + careerName + "\\seasonInfo.csv");
		

		if(!file.exists()) {
			try {
	    		file.createNewFile();
	    		
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		theDir = new File(userDir + "\\" + owner.getDataFolderPath() + "\\" + careerName + "\\Teams");
		
    	if (!theDir.exists()){
    	    theDir.mkdirs();
    	}
		
		
		ArrayList<String[]> arr = new ArrayList<>();
		
		
		
		try {
			CSVReader.readCSV(arr, "data\\2022-2023NBA PlayerStats3.csv", ",");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		ArrayList<Player> allPlayer = new ArrayList<Player>();
		
		for (int i = 1; i < arr.size(); i++) {
			
			Player pl = new Player(arr.get(i));
			
			allPlayer.add(pl);
			
		}
		
		
		HashSet<Integer> teamIndeces = Permutation.permutate(30, 15);
		
		ArrayList<Team> teams = new ArrayList<>(); 
		
		
		
		int index = 0;
		
		for (Teams team : Teams.values()) {
			
			if(teamIndeces.contains(Integer.valueOf(index))) {
				
				
				teams.add(new Team(team));
			}
					

			
			index++;
		}
		

		
		
		HashSet<Player> freePlayersSet = new HashSet<Player>();
		
		
		
		for(Player player: allPlayer) {
			
			boolean isFree = true;
			
			
			for(Team team: teams) {

		
			
			
			
				
				if(player.getTeam().name().equals(team.getTeamAbr().name())) {
					
					if(team.getPlayers().size() < 13) {
						
						team.addPlayer(player);
						isFree = false;
						break;
											
					}
					
				}
				
				
				
				
			}
			
			if(isFree) {
				player.setTeam(Teams.FREE);
				freePlayersSet.add(player);
			}
			
		}
		
		
		ArrayList<Player> freePlayers = new ArrayList<>(freePlayersSet);
		
		
		
		Team userTeam = new Team(Teams.USERTEAM);
		
		
		rd = new Random();
		
		for (int i = 0; i < 13; i++) {
			
			int randPlayerIndex = rd.nextInt(freePlayers.size());
			
			userTeam.addPlayer(freePlayers.get(randPlayerIndex));
			
			freePlayers.get(randPlayerIndex).setTeam(Teams.USERTEAM);
			
			freePlayers.remove(randPlayerIndex);
			
		}
		
		
		
		teams.add(userTeam);
		
		
		saveFreePlayers(careerName, freePlayers);
	
		saveTeams(careerName, teams);
		
		
		
		HashMap<Teams, Integer> scoreTable = new HashMap<>();
		
		for (Team team : teams) {
			
			scoreTable.put(team.getTeamAbr(), 0);
		}
		
		saveScoreTable(careerName, scoreTable);
		
		saveInfo(careerName, false, false, false, 0);
		
		
		
		Season season = new Season(userTeam, teams, freePlayers, scoreTable);
		return season;
  	
		
	}
	
	
	public void saveFreePlayers(String careerName, ArrayList<Player> freePlayers) {
		
		ArrayList<String[]> newArr = new ArrayList<String[]>();
		
		
		for (Player player : freePlayers) {
			
			newArr.add(player.getPlayersData());
			
		}
			
		
		CSVWriter.writeCSV(newArr,  owner.getDataFolderPath() + "\\" + careerName + "\\freePlayers.csv", ",");
		
		
	}
	
	public void saveTeams(String careerName, ArrayList<Team> teams) {
		
		
		for(Team team: teams) {
			
			
			ArrayList<String[]> teamPlayerData = new ArrayList<String[]>();
		
			
			for (Player player : team.getPlayers()) {
				
				teamPlayerData.add(player.getPlayersData());
				
			}
			
			File file = new File(userDir + "\\" + owner.getDataFolderPath() + "\\" +careerName + "\\Teams\\" + team.getTeamAbr().toString() + ".csv");
			
			if(!file.exists()) {
				try {
		    		file.createNewFile();
		    		
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
				
			
			CSVWriter.writeCSV(teamPlayerData,  owner.getDataFolderPath() + "\\" +careerName + "\\Teams\\" + team.getTeamAbr().toString() + ".csv", ",");
			
			
			
		}
		
	}
	
	public void saveScoreTable(String careerName, HashMap<Teams, Integer> teams) {
		
		
		StringBuilder builder = new StringBuilder();
		
		for (Teams teamAbr : teams.keySet()) {
			
			
			builder.append(String.format("%s,%d\n", teamAbr.toString(), teams.get(teamAbr)));
		}
		
		

		CSVWriter.writeCSV(builder.toString(),  owner.getDataFolderPath() + "\\" + careerName + "\\scoreTable.csv", ",");
		
	}
	
	public void saveInfo(String careerName,  boolean isDraftingDone, boolean isSeasonDone, boolean isPlayOffDone, int weeknumber) {
		
		
	
		StringBuilder builder = new StringBuilder();
		
		
			
			
			builder.append(String.format("%s,%s\n", "isDraftingDone", String.valueOf(isDraftingDone)));
			builder.append(String.format("%s,%s\n", "isSeasonDone", String.valueOf(isSeasonDone)));
			builder.append(String.format("%s,%s\n", "isPlayOffDone", String.valueOf(isPlayOffDone)));
			builder.append(String.format("%s,%s\n", "weeknumber", String.valueOf(weeknumber)));
			
		
		
		

		CSVWriter.writeCSV(builder.toString(), owner.getDataFolderPath() + "\\" + careerName + "\\seasonInfo.csv", ",");
		
	}
	
	
	
	

}
