package Tools;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @author Paulo Augusto
 *	Abstract class for a Tool in the DrawingPallet
 */
public abstract class Tool implements Cloneable {

	protected ArrayList<Point> pointList;
	private ToolType tool;
	private Color color;
	
	/**
	 * @return return the ToolType (for debugging, not used)
	 */
	public ToolType getTool() {
		return tool;
	}

	/**
	 * @param tool Set this object's ToolType to "tool"
	 */
	public void setTool(ToolType tool) {
		this.tool = tool;
	}

	/**
	 * @return return this Tool's color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color Color to set this Tool
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/** Constructor
	 * @param tool ToolType of this Tool
	 */
	public Tool(ToolType tool) {
		this.tool = tool;
		color = Color.BLACK;
		pointList = new ArrayList<Point>();
	}
	
	/** Constructor with ToolType and Color
	 * @param tool ToolType of this Tool
	 * @param color Color.COLOR
	 */
	public Tool(ToolType tool, Color color) {
		
		this.tool = tool;
		this.color = color;
		
	}
	
	/** Draw something with this tool at pallet
	 * @param mouse MouseEvent object
	 * @param pallet Graphics object to draw
	 * @param stroke Stroke to paint
	 * @param color Color.COLOR
	 * @return return a Graphics instance of the drawings made
	 */
	public abstract Graphics draw(MouseEvent mouse, Graphics2D pallet,BasicStroke stroke, Color color);
	public abstract Tool copy();
	
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
	/**
	 * clear the point list (for lines)
	 */
	public void release() {
		pointList.clear();
		
	}
	
}
