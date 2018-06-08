package Tools;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import Utils.Tool;
import Utils.ToolType;

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
	public Graphics draw(MouseEvent mouse, Graphics pallet,int w) {
		int x = mouse.getX();
		int y = mouse.getY();
		pallet.fillOval(x-w/2, y-w/2, w, w);
		return pallet;
		
	}

}
