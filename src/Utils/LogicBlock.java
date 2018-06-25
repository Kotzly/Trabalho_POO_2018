package Utils;
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
import wnds.NodePanel;

/**
 * @author Paulo Augusto
 *	Logic block graphics 
 */
public class LogicBlock extends JPanel implements Serializable{

	public boolean isSelected = false;
	private BufferedImage model;
	private ArrayList<InNodeTool> inNodes;
	private ArrayList<OutNodeTool> outNodes;
//	private ArrayList<elementoLogico> logicElements;
	private String blockName;
	private int blockId;
	private static int blockNumber=0;
	public LogicBlockNodes<NodePanel,NodePanel> nodesList;

	/**
	 * Re draw the block
	 */
	public void draw() {
		this.repaint();
	}
	
	
	/**
	 * @param inNodeList Input node list
	 * @param outNodeList Output node list
	 */
	public void setNodes( ArrayList<NodePanel> inNodeList, ArrayList<NodePanel> outNodeList) {
		nodesList.setInNodeList(inNodeList);
		nodesList.setOutNodeList(outNodeList);
	}
	
	/**
	 * @param imagePath Logic block image path
	 * @param name Name of the logic block
	 */
	public LogicBlock(java.lang.String imagePath, String name) {
		LogicBlock(name);
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
	
	private void LogicBlock(String name) {
		
		blockNumber++;
		this.blockName=name;
		this.blockId=blockNumber;
		nodesList = new LogicBlockNodes<NodePanel,NodePanel>();
		
	}


	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//	System.out.println(g.getClass());
		g.drawImage(model, 0, 0, null);
//		Graphics model = new sun.java2d.SunGraphics2D(null, null, null,null);
		
//		g=model;
	}
	
	/**
	 * Mark this block as selected
	 */
	public void select() {

		isSelected = !isSelected;
		System.out.println(isSelected);
		return;
		
	}	


	/**
	 * @return Returns a BufferedImage object of the block's graphics
	 */
	public BufferedImage getModel() {
		return model;	
	}
	
	/**
	 * @return Sets a BufferedImage object as the block's graphics
	 */
	public void setModel(BufferedImage model) {
		this.model = model;	
		draw();
	}
	
	/**
	 * @return Returns true if block is selected
	 */
	public boolean isSelected() {
		return isSelected;
	}
	
	/**
	 * @returns Return the block's name
	 */
	public String getLogicBLockName() {
		return blockName;
	}
	
}	

