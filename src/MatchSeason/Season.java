package MatchSeason;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

import Player.Player;
import Player.Teams;
import Team.Team;

public class Season {
	
		private static Random rd = new Random();
	
		
		private boolean isDraftingDone;
		private boolean isSeasonDone;
		private boolean isPlayOffDone;
		private int weeknumber;

		private String careerName;
	 			

		private Team userTeam;
	    private ArrayList<Team> leagueTeams;
	    private ArrayList<Player> freePlayers;
	    private HashMap<Teams, Integer> scoreTable;

	    // Constructor
	    public Season(Team userTeam, ArrayList<Team> leagueTeams, ArrayList<Player> freePlayers, HashMap<Teams, Integer> scoreTable) {
	        this.userTeam = userTeam;
	        this.leagueTeams = leagueTeams;
	        this.freePlayers = freePlayers;
	        this.scoreTable = scoreTable;
	        
	   
	        this.isDraftingDone = false;
	        this.isSeasonDone = false;
	        this.isPlayOffDone = false;
	        this.weeknumber = 0;
	    }
	    
	    
	    
	    public ArrayList<Player> getDraftingSquad(){
	    	ArrayList<Player> draftingSquad = new ArrayList<Player>();
	    	
	    	for (int i = 0; i < 32; i++) {
	    		int newInd = rd.nextInt(freePlayers.size());
				draftingSquad.add(freePlayers.get(newInd));
				freePlayers.remove(newInd);
			}
	    	
			return draftingSquad;
	    	
	    }

	    // Getter and Setter for userTeam
	    public Team getUserTeam() {
	        return userTeam;
	    }

	    public void setUserTeam(Team userTeam) {
	        this.userTeam = userTeam;
	    }

	    // Getter and Setter for leagueTeams
	    public ArrayList<Team> getLeagueTeams() {
	        return leagueTeams;
	    }

	    public void setLeagueTeams(ArrayList<Team> leagueTeams) {
	        this.leagueTeams = leagueTeams;
	    }

	    // Getter and Setter for freePlayers
	    public ArrayList<Player> getFreePlayers() {
	        return freePlayers;
	    }

	    public void setFreePlayers(ArrayList<Player> freePlayers) {
	        this.freePlayers = freePlayers;
	    }

	    // Getter and Setter for scoreTable
	    public HashMap<Teams, Integer> getScoreTable() {
	        return scoreTable;
	    }

	    public void setScoreTable(HashMap<Teams, Integer> scoreTable) {
	        this.scoreTable = scoreTable;
	    }
	
	    
	    
	    
	    public String getCareerName() {
			return careerName;
		}

		public void setCareerName(String careerName) {
			this.careerName = careerName;
		}
	    
	    
	
	    public boolean isDraftingDone() {
			return isDraftingDone;
		}

		public void setDraftingDone(boolean isDraftingDone) {
			this.isDraftingDone = isDraftingDone;
		}

		public boolean isSeasonDone() {
			return isSeasonDone;
		}

		public void setSeasonDone(boolean isSeasonDone) {
			this.isSeasonDone = isSeasonDone;
		}

		public boolean isPlayOffDone() {
			return isPlayOffDone;
		}

		public void setPlayOffDone(boolean isPlayOffDone) {
			this.isPlayOffDone = isPlayOffDone;
		}
	
		
		public int getWeeknumber() {
			return weeknumber;
		}

		public void setWeeknumber(int weeknumber) {
			this.weeknumber = weeknumber;
		}

}
