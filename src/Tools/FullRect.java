package Tools;
import java.awt.*;
import java.awt.event.MouseEvent;
public class FullRect extends Tool {
	
	private boolean isHold;
	private Point lastPoint;
	private boolean second;
	
	public FullRect() {
		super(ToolType.FullRect);
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
				int a,b,c,d;
				if(x1<x2) {
					a=x1;
					c=x2;
				}else {
					c=x1;
					a=x2;
				}
				if(y1<y2) {
					b=y1;
					d=y2;
				}else {
					d=y1;
					b=y2;
				}
				pallet.fillRect(a,b,c-a,d-b);
				second=false;
				return pallet;
			}
		}else {	
			lastPoint.setLocation(x1,y1);
			second=true;
			return pallet;

		}

	}

	public int abs(int x) {
		if(x<0) {
			return -x;
		}
		else return x;
	}
	@Override
	public Tool copy() {
		return new FullRect();
	}
}
