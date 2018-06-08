import java.awt.*;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.*;

public class LogicBlock extends JPanel implements Serializable{
	public Graphics myg;
	boolean isSelected = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void draw() {
		this.repaint();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//	System.out.println(g.getClass());
		
//		Graphics model = new sun.java2d.SunGraphics2D(null, null, null,null);
		g.drawRect(10,10, 100, 100);
		g.fillOval(5, 20, 10, 10);
		g.fillOval(5, 90, 10, 10);
//		g=model;
	}
	

	
	public void select() {

		isSelected = !isSelected;
		System.out.println(isSelected);
		return;
		
	}	



	public boolean isSelected() {
		return isSelected;
	}
	
}	

