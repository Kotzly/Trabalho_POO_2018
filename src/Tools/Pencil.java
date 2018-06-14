package Tools;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


public class Pencil extends Tool {
	
	public boolean isHold;
	
	public Pencil() {
		super(ToolType.Pencil);

		isHold=false;
	}

	public void hold() {
		isHold=!isHold;
	}
	
	@Override
	public Graphics draw(MouseEvent mouse, Graphics2D pallet,BasicStroke w, Color color) {

		Point p = new Point(mouse.getX(),mouse.getY());
		
		pallet.setColor(color);
		pallet.setStroke(w);
		
		pointList.add(mouse.getPoint());
		
		if(pointList.size()<2) {
			System.out.println("first");
			
		}
		
        if (pointList.size() >= 2) {
            for (int i = 1; i < pointList.size(); i++) {
               int x1 = pointList.get(i - 1).x;
               int y1 = pointList.get(i - 1).y;
               int x2 = pointList.get(i).x;
               int y2 = pointList.get(i).y;
               pallet.drawLine(x1, y1, x2, y2);
            }
        }

		return pallet;
		
	}

	@Override
	public Tool copy() {
		return new Pencil();
	}
	
	

}
