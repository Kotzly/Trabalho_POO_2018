import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class SimulationPanel extends JPanel implements Serializable{

		private ArrayList<LogicBlock> logicBlockArray;
		private Clock clock;
		private Timer timer;
		private Time time;
		BufferedImage backGroundImage;
//		private GraphPanel graph;
		
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
		
		public SimulationPanel() {
			_SimulationPanel();
		}
		private void _SimulationPanel() {
		
			setBackground(Color.WHITE);
			setLayout(null);
			
			JPanel panel = new JPanel();
			panel = new GraphPanel(5);
			add(panel);
			((GraphPanel) panel).drawCurves();
			time = new Time(0);
			timer = new Timer();
			logicBlockArray = new ArrayList<LogicBlock>();
//			graph = new GraphPanel();
			
			
		}
		
		public void updatePanel() {
			for(LogicBlock block: logicBlockArray) {
				block.repaint();
			}
		}
		
		public void addLogicBlock(LogicBlock block) {
			logicBlockArray.add(block);
		}
		
		public void addLogicBlock(int position, LogicBlock block) {
			logicBlockArray.add(position,block);
		}
		public void removeLogicBlock(LogicBlock block) {
			logicBlockArray.remove(block);
		}
		public void removeLogicBlock(int position) {
			logicBlockArray.remove(position);
		}
}
