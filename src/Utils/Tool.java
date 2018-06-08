package Utils;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public abstract class Tool {

	ToolType tool;
	Color color;
	
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
	}
	
	public Tool(ToolType tool, Color color) {
		
		this.tool = tool;
		this.color = color;
		
	}
	
	public abstract Graphics draw(MouseEvent mouse, Graphics pallet,int thickness);
	
}
