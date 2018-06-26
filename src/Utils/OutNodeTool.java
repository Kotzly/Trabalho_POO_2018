package Utils;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Tools.Tool;
import Tools.ToolType;
/**
 * @author Paulo Augusto
 *	OutNode Tool
 */
public class OutNodeTool {
	
	private boolean isHold;

	private JPanel nodePanel;

	public OutNodeTool(Point p) {
		
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
		nodePanel.setLocation(p);
		
	}

	public void hold() {
		isHold=!isHold;
	}
	
	
}
