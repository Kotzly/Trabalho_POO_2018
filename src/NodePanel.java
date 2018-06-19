import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.BasicStroke;
import java.awt.Color;

public class NodePanel extends JPanel {

	/**
	 * Create the panel.
	 *
	 */
	private int number;
	private final int width=15;
	private final int height=15;
	private boolean in;
	private ArrayList<NodePanel> connectedTo;
	
	
	public NodePanel(Point p, boolean in) {
		setBackground(Color.RED);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		this.setBounds(0,0,width,height);
		this.setLayout(null);
		this.setLocation(p);
		System.out.println(in);
		this.in=in;
		repaint();
		
	
	}
	
	public boolean isInput() {
		return in;
	}
	public boolean isOutput() {
		return !in;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(2));
		if(in) {
			g2d.setColor(Color.GREEN);
		}else {
			g2d.setColor(Color.BLUE);
		}
		g2d.drawOval(0,0,width,height);
	}
	
	public void setConnections(ArrayList<NodePanel> nodes) {
		connectedTo = nodes;
	}
	
	public void addConnection(NodePanel node) {
		connectedTo.add(node);
	}
	
}
