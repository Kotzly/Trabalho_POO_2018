package Tools;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;


public class Wash extends Tool {
	
	public boolean isHold;
	
	public Wash() {
		super(ToolType.Eraser);
		isHold=false;
	}

	public void hold() {
		isHold=!isHold;
	}
	
	@Override
	public Graphics draw(MouseEvent mouse, Graphics2D pallet,BasicStroke w, Color color) {

		if(JOptionPane.showConfirmDialog(null, "Clique Confirmar para continuar")==JOptionPane.YES_OPTION) {
			int x = mouse.getX();
			int y = mouse.getY();
			pallet.setColor(color);
			pallet.fillRect(0, 0, 5000, 5000);
			
			return pallet;
		}
		return pallet;
		
	}
	
	
	public static Graphics wash(Graphics pallet, Color color) {

		pallet.setColor(color);
		pallet.fillRect(0, 0, 5000, 5000);
		return pallet;
		
	}
		
	@Override
	public Tool copy() {
		return new Wash();
	}



}
