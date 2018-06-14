import java.awt.Color;
import java.util.ArrayList;

public class Curve {

	private ArrayList<Integer> curveData;
	public final static int TOP = 10;
	public final static int BOTTOM = 0;
	private Color color;
	
	public Curve(ArrayList<Integer> data) {
		curveData = data;
		
	}
	
	public Curve(int [] data) {
		curveData =new ArrayList<Integer>();
		for(Integer point: data) {
			 curveData.add(point);
		}
		 
	}
	
	public void addPoint(Integer point) {
		curveData.add(point);
	}
	
	public void removePoint() {
		curveData.remove(curveData.size());
	}

	public void removePoint(int index) {
		curveData.remove(index);
	}
	
	public int getSize() {
		return curveData.size();
	}
	
	public int getValue(int index) {
		return curveData.get(index);
	}
	public void setColor(Color color) {
		this.color=color;
	}
	public Color getColor() {
		return color;
	}
	
}
