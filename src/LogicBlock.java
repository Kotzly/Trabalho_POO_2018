import java.awt.*;
import javax.swing.*;

public class LogicBlock extends JPanel{
	
	boolean isSelected = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void draw() {
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawRect(10,10, 100, 100);
		g.fillOval(5, 20, 10, 10);
		g.fillOval(5, 90, 10, 10);

	}
	
	public void select() {
		isSelected = true;
		System.out.println(isSelected);
		
	}	
	public void deselect() {
		isSelected = false;
		System.out.println(isSelected);

	}
	public boolean isSelected() {
		return isSelected;
	}
}	

