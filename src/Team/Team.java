package Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Player.Player;
import Player.Teams;

public class Team {
	
	
	private ArrayList<Player> players;
	private Teams teamAbr;
	
	
	
	


	


	private String teamName;
	
	private static Map<Teams, String> fullNameMap() {
        Map<Teams, String> teamFullNameMap = new HashMap<>();

        teamFullNameMap.put(Teams.ATL, "Atlanta Hawks");
        teamFullNameMap.put(Teams.BOS, "Boston Celtics");
        teamFullNameMap.put(Teams.BRK, "Brooklyn Nets");
        teamFullNameMap.put(Teams.CHI, "Chicago Bulls");
        teamFullNameMap.put(Teams.CHO, "Charlotte Hornets");
        teamFullNameMap.put(Teams.CLE, "Cleveland Cavaliers");
        teamFullNameMap.put(Teams.DAL, "Dallas Mavericks");
        teamFullNameMap.put(Teams.DEN, "Denver Nuggets");
        teamFullNameMap.put(Teams.DET, "Detroit Pistons");
        teamFullNameMap.put(Teams.GSW, "Golden State Warriors");
        teamFullNameMap.put(Teams.HOU, "Houston Rockets");
        teamFullNameMap.put(Teams.IND, "Indiana Pacers");
        teamFullNameMap.put(Teams.LAC, "Los Angeles Clippers");
        teamFullNameMap.put(Teams.LAL, "Los Angeles Lakers");
        teamFullNameMap.put(Teams.MEM, "Memphis Grizzlies");
        teamFullNameMap.put(Teams.MIA, "Miami Heat");
        teamFullNameMap.put(Teams.MIL, "Milwaukee Bucks");
        teamFullNameMap.put(Teams.MIN, "Minnesota Timberwolves");
        teamFullNameMap.put(Teams.NOP, "New Orleans Pelicans");
        teamFullNameMap.put(Teams.NYK, "New York Knicks");
        teamFullNameMap.put(Teams.OKC, "Oklahoma City Thunder");
        teamFullNameMap.put(Teams.ORL, "Orlando Magic");
        teamFullNameMap.put(Teams.PHI, "Philadelphia 76ers");
        teamFullNameMap.put(Teams.PHO, "Phoenix Suns");
        teamFullNameMap.put(Teams.POR, "Portland Trail Blazers");
        teamFullNameMap.put(Teams.SAC, "Sacramento Kings");
        teamFullNameMap.put(Teams.SAS, "San Antonio Spurs");
        teamFullNameMap.put(Teams.TOR, "Toronto Raptors");
        teamFullNameMap.put(Teams.TOT, "Two Other Teams");
        teamFullNameMap.put(Teams.UTA, "Utah Jazz");
        teamFullNameMap.put(Teams.WAS, "Washington Wizards");
        teamFullNameMap.put(Teams.USERTEAM, "Polathan Games Raptors");

        return teamFullNameMap;
    }

	
	public Team(Teams teamAbr) {
		// TODO Auto-generated constructor stub
		
		this.teamAbr = teamAbr;
		this.teamName = fullNameMap().get(teamAbr);
		
		this.players = new ArrayList<Player>();
		
		
	}
	
		public void addPlayer(Player player) {
		
			players.add(player);
		}
	
	///////////////////////////////////////////////////////////////// getter and setters
		
		
		public int getNumPlayer() {
			return players.size();
		}

	
		public ArrayList<Player> getPlayers() {
			return players;
		}


		public void setPlayers(ArrayList<Player> players) {
			this.players = players;
		}


		public Teams getTeamAbr() {
			return teamAbr;
		}


		public void setTeamAbr(Teams teamAbr) {
			this.teamAbr = teamAbr;
		}


		public String getTeamName() {
			return teamName;
		}


		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}

}
