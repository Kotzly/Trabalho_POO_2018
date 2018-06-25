package Tools;
import java.awt.*;
import java.awt.event.MouseEvent;
/**
 * @author Paulo Augusto
 *	Oval tool
 */
public class Oval extends Tool {
	
	private boolean isHold;
	private Point lastPoint;
	private boolean second;
	
	public Oval() {
		super(ToolType.Rect);
		isHold=false;
		lastPoint= new Point();
		second=false;
	}

	public void hold() {
		isHold=!isHold;
	}
	
	@Override
	public Graphics draw(MouseEvent mouse, Graphics2D pallet,BasicStroke w, Color color) {

		int x1 = mouse.getX();
		int y1 = mouse.getY();
		int x2 = (int) lastPoint.getX();
		int y2 = (int) lastPoint.getY();
		
	//	Point p = new Point(x1,y1);
		
		pallet.setStroke(w);
		pallet.setColor(color);
		
		
		if(lastPoint == null) {
			lastPoint.setLocation(x1,y1);
		}
		
		if(second) {
			if(x1 == x2 && y1 == y2){
				return pallet;
			}else {
				int a,b,c,d,h,v;
				if(x1<x2) {
					a=x1;
					c=x2;
					h=x2-x1;
				}else {
					c=x1;
					a=x2;
					h=x2-x1;
				}
				if(y1<y2) {
					b=y1;
					d=y2;
					v=y2-y1;
				}else {
					d=y1;
					b=y2;
					v=y2-y1;
				}
				pallet.drawOval(a-h/2,b-v/2,c-a,d-b);
				second=false;
				return pallet;
			}
		}else {	
			lastPoint.setLocation(x1,y1);
			second=true;
			return pallet;

		}

	}
	@Override
	public Tool copy() {
		return new Oval();
	}
}
