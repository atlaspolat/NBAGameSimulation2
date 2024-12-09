package GUI.Components;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Player.Player;

public class PlayerCard extends JPanel {
	
	

	public PlayerCard(Player player)  {
		// TODO Auto-generated constructor stub
		
		JLabel nameTag = new JLabel();
		
		this.setOpaque(false);
		
		nameTag.setText(player.getName());
		
		JLabel ageTag = new JLabel();
		
		nameTag.setText(player.getPosition().name() + "  --  " + String.valueOf(player.getAge()));
		
		CustomizedButton infoButton = new CustomizedButton("See Statistics");
		
		this.add(nameTag);
		this.add(ageTag);
		this.add(infoButton);
		
		
		
		
	}

}
