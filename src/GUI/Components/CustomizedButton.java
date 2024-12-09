package GUI.Components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class CustomizedButton extends JButton {

	public CustomizedButton() {
		// TODO Auto-generated constructor stub
		this("");
	}
	
	
	public CustomizedButton(String text) {
		// TODO Auto-generated constructor stub
		
		this.setFont(new Font("Gobold High", Font.PLAIN, 25));
		
		this.setHorizontalTextPosition(JButton.CENTER);
		
		this.setVerticalTextPosition(JButton.CENTER);

		this.setForeground(new Color(0xFFFFFF));
		
		this.setBackground(new Color(0xC9082A));
		
		// Disable border change on click
		this.setBorderPainted(false);
		
		 // Disable border painting
		this.setBorderPainted(false);
		
		this.setFocusable(false);
		
		this.setText(text);
		
		this.setBorder(null);
	}

}
