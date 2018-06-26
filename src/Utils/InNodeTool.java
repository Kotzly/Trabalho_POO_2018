package Utils;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Tools.Tool;
import Tools.ToolType;
/**
 * @author Paulo Augusto
 * InNode Tool
 */
public class InNodeTool{
	
	private boolean isHold;
	private JPanel nodePanel;

	public InNodeTool() {
		
		isHold=false;
		nodePanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawOval(0, 0, 10, 10);
			}
		};
		nodePanel.setBounds(0, 0, 10, 10);
		nodePanel.repaint();
		
		
	}

	public void hold() {
		isHold=!isHold;
	}
	
	
	
}
