package GUI.Components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CustomizedHeading extends CustomizedLabel {
	
	
	public CustomizedHeading (){
		
		this("", 15);
		
		
	}
	
	public CustomizedHeading (String text, int fontSize){
		
		this.setFont(new Font("Roboto", Font.BOLD, fontSize));
		
		this.setForeground(new Color(0xC9082A));
		
		this.setVerticalTextPosition(JLabel.TOP);
		
		this.setHorizontalTextPosition(JLabel.CENTER);
		
		this.setText(text);
		
		this.setOpaque(true);
		
		
	}

}
