package wnds;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Utils.LogicBlock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimulationPanel extends JPanel implements Serializable{

		private ArrayList<LogicBlock> logicBlockArray;
		private Clock clock;
		private Timer timer;
		private Time time;
		BufferedImage backGroundImage;
		NodePanel selectedNode;
//		private GraphPanel graph;
		
		/**
		 * @param imagePath Path of the image, as string
		 */
		public SimulationPanel(String imagePath) {
		
			File path= new File(imagePath);
			try {
				backGroundImage = ImageIO.read(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				backGroundImage=null;
				System.out.println("Arquivo não existe!: " + e.getMessage());
			};

			this.setBounds(0, 0, backGroundImage.getWidth(),backGroundImage.getHeight() );
			
			_SimulationPanel();
					
		}
		
		/**
		 *  Constructor
		 */
		public SimulationPanel() {

			_SimulationPanel();
		}
		
		
		/**
		 * Constructor helper
		 */
		private void _SimulationPanel() {
		
			setBackground(Color.WHITE);
			setLayout(null);
			
			JPanel panel = new JPanel();
			panel = new GraphPanel();

			time = new Time(0);
			timer = new Timer();
			logicBlockArray = new ArrayList<LogicBlock>();
			
			
		}
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			
			for(LogicBlock lb: logicBlockArray) {
				for(NodePanel inNode: (ArrayList<NodePanel>)lb.nodesList.getInNodeList()) {
					for(NodePanel connection: inNode.getConnections()) {
						g2d.drawLine(inNode.getX(), inNode.getY(),connection.getX(),connection.getY());
					}
				}
				for(NodePanel outNode: (ArrayList<NodePanel>)lb.nodesList.getOutNodeList()) {
					for(NodePanel connection: outNode.getConnections()) {
						g2d.drawLine(outNode.getX(), outNode.getY(), connection.getX(),connection.getY());			
					}			
				}
			}
		}
		
		/**
		 * Update the panels graphics
		 */
		public void updatePanel() {
			for(LogicBlock block: logicBlockArray) {
				block.repaint();
			}
		}
		
		/**
		 * @param block add the LogicBlock block to the array of blocks
		 */
		public void addLogicBlock(LogicBlock block) {
			logicBlockArray.add(block);
		}
		
		public void addLogicBlock(int position, LogicBlock block) {
			logicBlockArray.add(position,block);
		}
		/**
		 * @param block block to be removed
		 */
		public void removeLogicBlock(LogicBlock block) {
			logicBlockArray.remove(block);
		}
		/**
		 * @param position position to be removed
		 */
		public void removeLogicBlock(int position) {
			logicBlockArray.remove(position);
		}
		
		/**
		 * Add events to the SimulationPanel
		 */
		public void addEvents() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JPanel node = (JPanel) getComponentAt(arg0.getPoint()); 
					if(node instanceof NodePanel) {
						if(selectedNode == null) {
							
								selectedNode= (NodePanel) node;
							
						}else {
							connect((NodePanel) node,selectedNode);
							selectedNode=null;
						}
					}
				}


			});
		}
		
		/**
		 * @param node Node to be connected
		 * @param selectedNode Another node to be connected
		 */
		private void connect(NodePanel node, NodePanel selectedNode) {
			// TODO Auto-generated method stub
			selectedNode.addConnection(node);
			node.addConnection(selectedNode);
			
		}
		
}
