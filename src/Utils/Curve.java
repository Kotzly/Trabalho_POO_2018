package Utils;
import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Paulo Augusto
 * Class for drawing graphics 
 */
public class Curve {

	private ArrayList<Integer> curveData;
	public final static int TOP = 10;
	public final static int BOTTOM = 0;
	private Color color;
	
	/** Constructor
	 * @param data Curve data
	 */
	public Curve(ArrayList<Integer> data) {
		curveData = data;
		
	}
	
	/** Constructor
	 * @param data Curve data
	 */
	public Curve(int [] data) {
		curveData =new ArrayList<Integer>();
		for(Integer point: data) {
			 curveData.add(point);
		}
		 
	}
	
	/**
	 * @param point adds a point of data
	 */
	public void addPoint(Integer point) {
		curveData.add(point);
	}
	
	/**
	 *  remove the last data point
	 */
	public void removePoint() {
		curveData.remove(curveData.size());
	}

	/** Remove a point
	 * @param index index to be removed
	 */
	public void removePoint(int index) {
		curveData.remove(index);
	}
	
	/**
	 * @return Return the data size
	 */
	public int getSize() {
		return curveData.size();
	}
	
	/**
	 * @param index index to get the value
	 * @return returns the value of the data atindex
	 */
	public int getValue(int index) {
		return curveData.get(index);
	}
	/**
	 * @param color color to set the drawing
	 */
	public void setColor(Color color) {
		this.color=color;
	}
	/**
	 * @return Return the color
	 */
	public Color getColor() {
		return color;
	}
	
}
