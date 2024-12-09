package GUI.Components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MenuButton extends JButton {
	
	
	public static final String userDir = System.getProperty("user.dir");

	public MenuButton(String text)  {
		// TODO Auto-generated constructor stub
		
		
		this.setFont(new Font("Gobold High", Font.PLAIN, 45));
		
		this.setHorizontalTextPosition(JButton.CENTER);
		
		this.setVerticalTextPosition(JButton.CENTER);

		this.setForeground(new Color(0xFFFFFF));
		
		this.setBackground(new Color(0,0,0,0));
		
		this.setFocusable(false);
		
		 // Disable border painting
		this.setBorderPainted(false);
		
		// Disable background change on hover
		this.setContentAreaFilled(false);
        
        // Disable border change on click
		this.setBorderPainted(false);
		
		this.setText(text);
		
		this.setBorder(null);
		
		
		ImageIcon defaultIcon = new  ImageIcon(userDir + "\\img\\sButton.png");
		
		ImageIcon hoverIcon = new ImageIcon(userDir + "\\img\\shButton.png");
		
		this.setIcon(defaultIcon);
		
		JButton myself = this;
		
		 // Add a mouse listener to handle hover events
		this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the background image when hovered
                
                myself.setIcon(hoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restore the default background image when not hovered
            	myself.setIcon(defaultIcon);
            }

        });
	}

}
