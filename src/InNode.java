
import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Tools.Tool;
import Tools.ToolType;
public class InNode extends Tool {
	
	private boolean isHold;
	private Point lastPoint;
	private boolean second;
	private JPanel nodePanel;

	public InNode() {
		super(ToolType.Input);
		isHold=false;
		nodePanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawOval(0, 0, 10, 10);
			}
		};
		nodePanel.setBounds(0, 0, 10, 10);
		
	}

	public void hold() {
		isHold=!isHold;
	}
	
	
	
	@Override
	public Graphics draw(MouseEvent mouse, Graphics2D pallet,BasicStroke w, Color color) {

		int x = mouse.getX();
		int y = mouse.getY();

		
	//	Point p = new Point(x1,y1);
		
		pallet.setStroke(w);
		pallet.setColor(Color.BLUE);
		
		pallet.drawOval(x-5,y-5,10,10);
		return pallet;

	}
	@Override
	public Tool copy() {
		return new InNode();
	}
}
