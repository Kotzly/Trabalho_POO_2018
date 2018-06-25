package wnds;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.BasicStroke;
import java.awt.Color;

/**
 * @author Paulo Augusto
 * Node panel class
 */
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
	
	
	/**
	 * @param p Point where this node will be
	 * @param in True if this panel is for an input
	 */
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
	
	/**
	 * @return return if this block is for an input
	 */
	public boolean isInput() {
		return in;
	}
	
	/**
	 * @return return if this block is for an output
	 */
	public boolean isOutput() {
		return !in;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
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
	
	/**
	 * @param nodes Set the ArrayList to which this node is connected to
	 */
	public void setConnections(ArrayList<NodePanel> nodes) {
		connectedTo = nodes;
	}
	
	/**
	 * @param node Node to be added
	 */
	public void addConnection(NodePanel node) {
		connectedTo.add(node);
	}
	
	/**
	 * @return return the ArrayList of this block's connections
	 */
	public ArrayList<NodePanel> getConnections(){
		return connectedTo;
	}
}
