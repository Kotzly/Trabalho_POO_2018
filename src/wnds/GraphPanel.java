package wnds;
import javax.swing.JPanel;

import Utils.Curve;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JButton;

public class GraphPanel extends JPanel {

	/**
	 * Create the panel.
	 */

	ArrayList<Curve> data;
	private int curveHeight;
	private int nCurves;
	private int gap;
	private int hScale;
	
	public GraphPanel() {
		setBackground(Color.WHITE);
		//setLayout(null);
		setBounds(0,0,200,40);
		data = new ArrayList<Curve>();
		gap = 2;
		hScale=5;
		curveHeight=50;
		int []v= {Curve.TOP,Curve.TOP,Curve.TOP,Curve.TOP,Curve.TOP,Curve.BOTTOM,Curve.BOTTOM,Curve.BOTTOM,Curve.TOP,Curve.TOP,Curve.TOP};
		int []v2= {Curve.TOP,Curve.TOP,Curve.TOP,Curve.TOP,Curve.TOP,Curve.TOP,Curve.TOP,Curve.TOP,Curve.BOTTOM,Curve.BOTTOM,Curve.BOTTOM,Curve.BOTTOM,Curve.BOTTOM,Curve.BOTTOM};
		
		Curve curve1= new Curve(v);
		Curve curve2= new Curve(v);
		Curve curve3= new Curve(v2);
		Curve curve4= new Curve(v2);
		
		addCurve(curve1);
		addCurve(curve2);
		addCurve(curve3);
		addCurve(curve4);
		
			
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		System.out.println(nCurves);
		for(int curveNumber = 0 ; curveNumber < nCurves; curveNumber ++) {
			
			int positionAtArray = 0;
			int anterior = 0;
			while(positionAtArray < data.get(curveNumber).getSize()) {
				int valueAtTime=Curve.TOP;
				valueAtTime = data.get(curveNumber).getValue(positionAtArray);
				System.out.println(positionAtArray);
				g.setColor(data.get(curveNumber).getColor());
				if(anterior!= valueAtTime) {
					System.out.println(anterior +""+ valueAtTime);
					g.drawLine(positionAtArray*hScale,curveNumber*curveHeight+gap,positionAtArray*hScale,curveHeight*curveNumber+curveHeight-gap);
				}					
				
				if(valueAtTime==Curve.TOP) {
					g.drawLine(positionAtArray*hScale,curveNumber*curveHeight+gap,positionAtArray*hScale+(hScale-1),curveNumber*curveHeight+gap);
					System.out.println("drawing at top");

				}
				if(valueAtTime==Curve.BOTTOM) {
					g.drawLine(positionAtArray*hScale,curveHeight*curveNumber+curveHeight-gap,positionAtArray*hScale+(hScale-1),curveHeight*curveNumber+curveHeight-gap);
					System.out.println("drawing at bottom");

				}
				
				positionAtArray+=1;
				anterior = valueAtTime;
			}
			
		}

	}
	
	public void addCurve(Curve curve) {
		data.add(curve);
		nCurves+=1;
		setBounds(0, 0, 200, nCurves*curveHeight);
	}

	public void drawCurves(Graphics2D g2d) {
		
//		Graphics2D g2d = (Graphics2D) this.getGraphics();
		for(int curveNumber = 0 ; curveNumber < nCurves; curveNumber ++) {
			int anterior=Curve.TOP;
			int positionAtArray = 0;
			while(positionAtArray < data.get(curveNumber).getSize()) {
				int valueAtTime;
				valueAtTime = data.get(curveNumber).getValue(positionAtArray);
					
					if(valueAtTime==Curve.TOP) {
						g2d.drawLine(positionAtArray*2,curveNumber+1,positionAtArray*2+1,curveNumber+1);
					}
					if(valueAtTime==Curve.BOTTOM) {
						g2d.drawLine(positionAtArray*2,curveHeight+curveNumber-1,positionAtArray*2+1,curveHeight+curveNumber+1);
					}
					anterior=valueAtTime;
				
			}
		}
			
	}

	public boolean setGap(int n) {
		if(n<1) {
			return false;
		}
		this.gap=n;
		return true;
	}
	
	public boolean setScale(int hScale) {
		if(hScale<1) {
			return false;
		}
		this.hScale=hScale;
		return true;
	}
	public int getScale() {
		return hScale;
	}
	public int getGap() {
		return gap;
	}
	
}