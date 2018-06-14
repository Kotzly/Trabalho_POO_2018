import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ScreenImage.ScreenImage;
import Tools.Eraser;
import Tools.FullOval;
import Tools.FullRect;
import Tools.Oval;
import Tools.Pencil;
import Tools.Rect;
import Tools.Tool;
import Tools.ToolType;
import Tools.Wash;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSplitPane;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawingPalletWindow extends JFrame {

	private JPanel contentPane;
	private Graphics2D pallet;
	private JButton btnLine;
	private JButton btnRect;
	private JButton btnOval;
	private JButton btnText;
	private JButton btnInput;
	private JButton btnOutput;
	private JPanel pnlDrawing;
	private JRadioButton rdbtnFillShape;
	private JLabel lblLineThickness;
	private JSlider slider;
	private JPanel pnlTools;
	private JSplitPane splitPane;
	private JSeparator separator;
	private GroupLayout gl_contentPane;
	private GroupLayout gl_pnlTools;
	private JButton btnChooseColor;
	private Tool drawingTool;
	private JButton btnPencil;
	private boolean filledShape; 
	private int drawingToolThickness;
	private JButton btnEraser;
	private Color drawingToolColor;
	private BufferedImage bImage;
	private JButton btnWash;
	private BasicStroke drawingStroke;
	private JButton btnSave;
	private JPanel pnlRight;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingPalletWindow frame = new DrawingPalletWindow();
					frame.setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	/**
	 * Create the frame.
	 */
	public DrawingPalletWindow() {
		setResizable(false);
		setTitle("Block Creator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 579);
		
		initComponents();

		initGroupLayouts();

		constructWindow();
				
		initActions();
		
		//pallet = (Graphics2D) pnlDrawing.getGraphics();
		
	}
	
	
	private void constructWindow() {

		setContentPane(contentPane);
		
		splitPane.setRightComponent(pnlRight);
		splitPane.setLeftComponent(pnlTools);

		pnlTools.setLayout(gl_pnlTools);
		contentPane.setLayout(gl_contentPane);
		pnlRight.setLayout(null);

		pnlRight.add(pnlDrawing);
	}
	
	private void initComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		drawingTool = new Pencil();
		
		pnlRight = new JPanel();
		
		splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		
		pnlDrawing = new JPanel();
		pnlDrawing.setBounds(154, 150, 150, 150);

		drawingStroke = new BasicStroke(1);	
		
		pnlDrawing.setForeground(Color.BLACK);
		pnlDrawing.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDrawing.setBackground(Color.WHITE);
		pnlDrawing.setLayout(null);
		
		pnlTools = new JPanel();
		pnlTools.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		btnLine = new JButton("Line");
		btnLine.setToolTipText("Draws a Line");
		
		btnRect = new JButton("Rectangle");
		btnRect.setToolTipText("Draws a rectangle");
		
		btnOval = new JButton("Oval");
		btnOval.setToolTipText("Draws a oval form");
		
		btnEraser = new JButton("Eraser");
		btnEraser.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEraser.setToolTipText("Paint with the background color");

		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setToolTipText("Line thickness");
		slider.setValue(5);
		slider.setMaximum(50);
		slider.setMinimum(1);
		
		lblLineThickness = new JLabel("Line Thickness");
		
		btnInput = new JButton("Input");
		btnInput.setToolTipText("Insert an input node");

		btnPencil = new JButton("Pencil");
		btnPencil.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPencil.setToolTipText("Draw with a pencil");
		
		btnOutput = new JButton("Output");
		btnOutput.setToolTipText("Insert an output node");
		
		btnText = new JButton("Text");
		btnText.setToolTipText("Writes a text");
		btnText.setVerticalAlignment(SwingConstants.BOTTOM);
		
		btnChooseColor = new JButton("Color...");	
		btnChooseColor.setToolTipText("Select draw color");

		separator = new JSeparator();
		
		rdbtnFillShape = new JRadioButton("Fill shape");
		
		btnWash = new JButton("Wash");
		btnWash.setToolTipText("Wash the screen");
		
		btnSave = new JButton("Save");
		btnSave.setToolTipText("Save your logic block");
		
		bImage = new BufferedImage(300,300,BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2d = bImage.createGraphics();
		Wash.wash(g2d, Color.WHITE);
		g2d.dispose();
	}
	
	private void initGroupLayouts() {
	
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 321, Short.MAX_VALUE)
		);	
		

		gl_pnlTools = new GroupLayout(pnlTools);
		gl_pnlTools.setHorizontalGroup(
			gl_pnlTools.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlTools.createSequentialGroup()
					.addGroup(gl_pnlTools.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(rdbtnFillShape, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_pnlTools.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRect, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(btnLine, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(btnText, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(btnOval, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPencil, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnOutput, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnInput, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnChooseColor, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLineThickness, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(slider, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnEraser, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnWash, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnlTools.setVerticalGroup(
			gl_pnlTools.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTools.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRect)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOval)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnText)
					.addGap(7)
					.addComponent(btnPencil)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEraser)
					.addGap(8)
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLineThickness)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnFillShape)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnChooseColor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInput)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOutput)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnWash)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSave)
					.addContainerGap(13, Short.MAX_VALUE))
		);
	}
	
	
	private void initActions() {
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	
		
		btnPencil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					drawingToolColor = pnlDrawing.getForeground();
					if(filledShape) {
						drawingTool.setTool(ToolType.Pencil);
						drawingTool=new Pencil();
					}else {
						drawingTool.setTool(ToolType.Pencil);	
						drawingTool=new Pencil();
					}
			}
		});
		
		btnWash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawingToolColor = pnlDrawing.getBackground();
				drawingTool=new Wash();
			}
		});
			
		btnRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(filledShape) {
					drawingTool.setTool(ToolType.FullRect);
					drawingTool = new FullRect();
				}else {
					drawingTool.setTool(ToolType.Rect);	
					drawingTool = new Rect();
				}
			}
		});
	
		btnOval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(filledShape) {
					drawingTool.setTool(ToolType.FullOval);
					drawingTool = new FullOval();
				}else {
					drawingTool.setTool(ToolType.Oval);
					drawingTool = new Oval();
				}
			}
		});
		btnText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(filledShape) {
					drawingTool.setTool(ToolType.Text);
				}else {
					drawingTool.setTool(ToolType.Text);	
				}
			}
		});
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(filledShape) {
					drawingTool.setTool(ToolType.Line);
				}else {
					drawingTool.setTool(ToolType.Line);	
				}
			}
		});
		rdbtnFillShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filledShape= rdbtnFillShape.isSelected();
				fillShapeChangeText();
			}
		});
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				drawingToolThickness = slider.getValue();
				drawingStroke = new BasicStroke(drawingToolThickness,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
			}
		});
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawingTool.setTool(ToolType.Input);	
			}
		});
		btnOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawingTool.setTool(ToolType.Output);	
			}
		});
		btnChooseColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ChangeColorWindow colorWindow= new ChangeColorWindow() {
					@Override
					public void setColor() {
						drawingToolColor=getColor();
					}
				};
				colorWindow.setVisible(true);
	
				
				File outputfile = new File("C:\\Users\\Paulo Augusto\\Desktop\\image.jpg");
				
				try {
					ImageIO.write(bImage, "jpg", outputfile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		
		pnlDrawing.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
		        Graphics2D g2d_image = (Graphics2D) bImage.createGraphics();
		        
		        drawingTool.draw(arg0,g2d_image,drawingStroke,drawingToolColor);
				pnlDrawing.getGraphics().drawImage(bImage,0,0,null);
				
				g2d_image.dispose();
			        
			}
		});
		
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				drawingTool.release();
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
		        Graphics2D g2d_image = (Graphics2D) bImage.createGraphics();	        
		        
		        drawingTool.draw(arg0,g2d_image,drawingStroke,drawingToolColor);
				pnlDrawing.getGraphics().drawImage(bImage,0,0,null);
		      
				g2d_image.dispose();
			}
		});

		btnEraser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {	
				drawingToolColor = pnlDrawing.getBackground();
				drawingTool = new Eraser();
				drawingTool.setTool(ToolType.Eraser);	
				System.out.println(Color.BLUE.getRGB());
				System.out.println(Color.GREEN.getRGB());
				System.out.println(Color.RED.getRed());
			}
		});
		
	}
	
	public void fillShapeChangeText() {
		if(filledShape) {
			btnRect.setText("Filled Rectangle");
			btnOval.setText("Filled Oval");
		}else {
			btnRect.setText("Rectangle");
			btnOval.setText("Oval");	
		}
	}
}
