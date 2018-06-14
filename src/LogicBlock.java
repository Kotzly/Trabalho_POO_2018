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
	public Graphics myg;
	boolean isSelected = false;
	private BufferedImage model;
	private ArrayList<InNode> inNodes;
	private ArrayList<OutNode> outNodes;
//	private ArrayList<elementoLogico> logicElements;
	/**
	 * 
	 */
	

	public void draw() {
		this.repaint();
	}
	
	
	public LogicBlock(java.lang.String imagePath) {

		
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
	
}	

