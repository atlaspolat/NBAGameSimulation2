package GUI.Components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * Creating our own label desing and keeping it in
 * GUI.Components for later use
 * 
 * 
 */

public class CustomizedLabel extends JLabel{ 

	/**
	 *  Necessary implementation
	 */
	private static final long serialVersionUID = 1L;

	public CustomizedLabel (){
		
		this("");
		
		
	}
	
	public CustomizedLabel (String text){
		
		this.setFont(new Font("Roboto LT", Font.PLAIN, 15));
		
		this.setForeground(new Color(0x17408B));
		
		this.setVerticalTextPosition(JLabel.TOP);
		
		this.setHorizontalTextPosition(JLabel.CENTER);
		
		this.setBounds(150, 25, 200, 200);
		
		this.setText(text);
		
		this.setOpaque(true);
		
		
	}
	
	
	
}
