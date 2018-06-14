package Tools;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Tool implements Cloneable {

	protected ArrayList<Point> pointList;
	private ToolType tool;
	private Color color;
	
	public ToolType getTool() {
		return tool;
	}

	public void setTool(ToolType tool) {
		this.tool = tool;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Tool(ToolType tool) {
		this.tool = tool;
		color = Color.BLACK;
		pointList = new ArrayList<Point>();
	}
	
	public Tool(ToolType tool, Color color) {
		
		this.tool = tool;
		this.color = color;
		
	}
	
	public abstract Graphics draw(MouseEvent mouse, Graphics2D pallet,BasicStroke stroke, Color color);
	public abstract Tool copy();
	
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
	public void release() {
		pointList.clear();
		
	}
	
}
