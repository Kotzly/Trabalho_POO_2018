package wnds;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;

public class ChangeColorWindow extends JDialog {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnBlack;
	private JButton btnWhite;
	private JButton btnRed;
	private JButton btnGreen;
	private JButton btnBlue;
	private JButton btnGrey;
	private JSlider sldrRed;
	private JSlider sldrGreen;
	private JSlider sldrBlue;
	private Canvas canvas;
	private JRadioButton rdbtnBackground;
	private JRadioButton rdbtnForeground;
	private int R,G,B;
	private Color color;
	private boolean colorIsSet;
	private JButton btnSet;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangeColorWindow frame = new ChangeColorWindow();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor() {
	
	}
	/**
	 * Create the frame.
	 */
	public ChangeColorWindow() {
		colorIsSet=false;
		setTitle("Choose Color");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setAlwaysOnTop(true);
		setModal(true);
		setBounds(100, 100, 371, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		
		initComponents();

		constructWindow();
				
		initActions();
	
	}

	private void constructWindow() {
		// TODO Auto-generated method stub
		contentPane.setLayout(null);
		contentPane.add(btnBlack);
		contentPane.add(btnWhite);
		contentPane.add(btnRed);
		contentPane.add(rdbtnBackground);
		contentPane.add(rdbtnForeground);
		contentPane.add(btnGreen);
		contentPane.add(btnBlue);
		contentPane.add(btnGrey);
		contentPane.add(sldrRed);
		contentPane.add(sldrGreen);
		contentPane.add(sldrBlue);
		contentPane.add(canvas);
		
		buttonGroup.add(rdbtnBackground);

		buttonGroup.add(rdbtnForeground);
	
		contentPane.add(btnSet);

	}

	private void initComponents() {
		btnSet = new JButton("Set");
		btnSet.setToolTipText("Set color");
		btnSet.setBounds(193, 249, 75, 23);
		
		rdbtnBackground = new JRadioButton("Background Color");
		rdbtnBackground.setBounds(15, 12, 109, 23);
				
		rdbtnForeground = new JRadioButton("Foreground Color");
		rdbtnForeground.setSelected(true);
		rdbtnForeground.setBounds(126, 12, 109, 23);
		
		btnBlack = new JButton("Black");
		btnBlack.setBounds(15, 62, 75, 23);
		
		btnWhite = new JButton("White");
		btnWhite.setBounds(15, 91, 75, 23);
		
		btnRed = new JButton("Red");
		btnRed.setBounds(15, 120, 75, 23);
		
		btnGreen = new JButton("Green");
		btnGreen.setBounds(15, 149, 75, 23);
		
		btnBlue = new JButton("Blue");
		btnBlue.setBounds(15, 178, 75, 23);
		
		btnGrey = new JButton("Grey");
		btnGrey.setBounds(15, 207, 75, 23);
		
		sldrRed = new JSlider();

		sldrRed.setToolTipText("Red component");
		
		sldrRed.setMaximum(255);
		sldrRed.setBounds(119, 164, 226, 26);
		
		sldrGreen = new JSlider();
		sldrGreen.setToolTipText("Green Component");
		sldrGreen.setMaximum(255);
		sldrGreen.setBounds(119, 193, 226, 26);
	
		sldrBlue = new JSlider();
		sldrBlue.setToolTipText("Blue component");
		sldrBlue.setMaximum(255);
		sldrBlue.setBounds(119, 222, 226, 26);
		
		canvas = new Canvas();
		canvas.setBackground(Color.DARK_GRAY);
		canvas.setForeground(Color.CYAN);
		canvas.setBounds(182, 41, 100, 100);
	
	}
	
	private void initActions() {
		// TODO Auto-generated method stub

		btnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canvas.setBackground(Color.BLACK);
			}
		});
	
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColor();
				
			}
		});
		
		sldrRed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				R=sldrRed.getValue();
				refreshCanvas();
				color= new Color(R,G,B);
			}
		});
		sldrGreen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				G=sldrGreen.getValue();
				refreshCanvas();
				color= new Color(R,G,B);

			}
		});
		sldrBlue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				B=sldrBlue.getValue();
				refreshCanvas();
				color= new Color(R,G,B);

			}
		});
	}
	
	public void refreshCanvas() {
		System.out.println(R+""+G+""+B);
		color = new Color(R, G, B);
		canvas.setBackground(color);
		canvas.repaint();
	}
	
}


