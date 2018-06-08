import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Tools.*;
import Utils.Tool;
import Utils.ToolType;

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

public class DrawingPalletWindow extends JFrame {

	private JPanel contentPane;
	private Graphics2D pallet;
	private JButton btnmkLine;
	private JButton btnmkRect;
	private JButton btnOval;
	private JButton btnText;
	private JButton btnInput;
	private JButton btnOutput;
	private JTextField txtField;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingPalletWindow frame = new DrawingPalletWindow();
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
		setTitle("Block Creator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 475);
		
		initComponents();

		initGroupLayouts();

		constructWindow();
				
		initActions();
		
		pallet = (Graphics2D) pnlDrawing.getGraphics();
		
	}
	
	private void constructWindow() {

		setContentPane(contentPane);
		
		pnlDrawing.add(txtField);
		
		splitPane.setRightComponent(pnlDrawing);
		splitPane.setLeftComponent(pnlTools);

		pnlTools.setLayout(gl_pnlTools);
		contentPane.setLayout(gl_contentPane);

	}
	
	private void initComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		drawingTool = new Pencil();
		
		splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		
		pnlDrawing = new JPanel();

		pnlDrawing.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDrawing.setBackground(Color.WHITE);
		pnlDrawing.setLayout(null);

		txtField = new JTextField();
		txtField.setBounds(274, 11, 194, 23);
		txtField.setEditable(false);
		txtField.setColumns(10);
		
		pnlTools = new JPanel();
		pnlTools.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		btnmkLine = new JButton("Line");
		btnmkLine.setToolTipText("Draws a Line");
		
		btnmkRect = new JButton("Rectangle");
		btnmkRect.setToolTipText("Draws a rectangle");
		
		btnOval = new JButton("Oval");
		btnOval.setToolTipText("Draws a oval form");
		
		btnEraser = new JButton("Eraser");
		btnEraser.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEraser.setToolTipText("Paint with the background color");

		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setToolTipText("Line thickness");
		slider.setValue(1);
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
							.addComponent(rdbtnFillShape, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
						.addGroup(gl_pnlTools.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_pnlTools.createParallelGroup(Alignment.LEADING)
								.addComponent(btnmkRect, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(btnmkLine, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(btnText, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(btnOval, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
						.addGroup(gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPencil, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnOutput, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnInput, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnChooseColor, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLineThickness, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(slider, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(gl_pnlTools.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnEraser, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnlTools.setVerticalGroup(
			gl_pnlTools.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTools.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnmkLine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnmkRect)
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
					.addGap(34))
		);
	}
	
	
	private void initActions() {
		
		btnPencil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(filledShape) {
					drawingTool.setTool(ToolType.Pencil);
				}else {
					drawingTool.setTool(ToolType.Pencil);	
				}
			}
		});
		
		btnmkRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(filledShape) {
					drawingTool.setTool(ToolType.FullRect);
				}else {
					drawingTool.setTool(ToolType.Rect);	
				}}
		});
		btnOval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(filledShape) {
					drawingTool.setTool(ToolType.FullOval);
				}else {
					drawingTool.setTool(ToolType.Oval);	
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
		btnmkLine.addActionListener(new ActionListener() {
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
			}
		});
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				drawingToolThickness = slider.getValue();
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
//				drawingTool.setColor(getColorGUI());
			}
		});
		
		pnlDrawing.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				pnlDrawing.paintComponents(drawingTool.draw(arg0,pnlDrawing.getGraphics(),drawingToolThickness));
			}
		});
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				((Pencil) drawingTool).hold();
				
			}
		});
		btnEraser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
	}
}
