import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NodePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public NodePanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		this.setBounds(0,0,10,10);
		this.setLayout(null);
		repaint();
	
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(0,0,10,10);
	}
}
