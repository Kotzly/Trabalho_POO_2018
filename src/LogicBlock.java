import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import ScreenImage.ScreenImage;

public class LogicBlock extends JPanel implements Serializable{

	boolean isSelected = false;
	private BufferedImage model;
	private ArrayList<InNodeTool> inNodes;
	private ArrayList<OutNodeTool> outNodes;
//	private ArrayList<elementoLogico> logicElements;
	private String blockName;
	private int blockId;
	private static int blockNumber=0;
	public LogicBlockNodes<NodePanel,NodePanel> nodesList;
	/**
	 * 
	 */
	

	public void draw() {
		this.repaint();
	}
	
	
	public void setNodes( ArrayList<NodePanel> inNodeList, ArrayList<NodePanel> outNodeList) {
		nodesList.setInNodeList(inNodeList);
		nodesList.setOutNodeList(outNodeList);
	}
	
	public LogicBlock(java.lang.String imagePath, String name) {
		blockNumber++;
		this.blockName=name;
		this.blockId=blockNumber;
		nodesList = new LogicBlockNodes<NodePanel,NodePanel>();
		File path= new File(imagePath);
		

		try {
			model = ImageIO.read(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			model=null;
			System.out.println("Arquivo não existe!: " + e.getMessage());
		};

		this.setBounds(0, 0, model.getWidth(),model.getHeight() );
		this.setLayout(null);
		

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//	System.out.println(g.getClass());
		g.drawImage(model, 0, 0, null);
//		Graphics model = new sun.java2d.SunGraphics2D(null, null, null,null);
		
//		g=model;
	}
	
	public void select() {

		isSelected = !isSelected;
		System.out.println(isSelected);
		return;
		
	}	


	public BufferedImage getModel() {
		return model;	
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public String getName() {
		return blockName;
	}
	
}	

