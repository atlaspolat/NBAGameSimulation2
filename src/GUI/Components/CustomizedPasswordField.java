package GUI.Components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;

public class CustomizedPasswordField extends JPasswordField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomizedPasswordField() {
		// TODO Auto-generated constructor stub
		
		this.setFont(new Font("Gobold High", Font.PLAIN, 25));
		
		this.setForeground(new Color(0xC9082A));
		
		this.setCaretColor(new Color(0x9082A));
		
		this.setBackground(new Color(0xFFFFFF));
		
		this.setBorder(null);
		
		
		
	}

}
