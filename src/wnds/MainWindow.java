package wnds;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JToggleButton;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Rectangle;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;

import Utils.LogicBlock;

import javax.swing.event.ListSelectionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabsPane;
	private JPanel simPanel;
	private LogicBlock rect2;
	private LogicBlock selectedBlock;
	private JPanel panel;
	private JMenu mnFile;
	private JMenu mnProperties;
	private JMenu mntmAboutUs;
	private JMenuItem mntmOpenSimulation;
	private JMenuItem mntmSettings;
	private JMenuItem mnItemLoad;
	private JMenuBar menuBar;
	private GroupLayout gl_contentPane;
	private GroupLayout gl_simPanel;
	private JScrollPane scrollPane;
	private ArrayList<JPanel> blocks;
	private JPanel block;
	private JPanel pnlSimulationButtons;
	private JButton btnPause;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnStep;
	private JButton btnStopClock;
	private JScrollPane pnlLogicBlocks;
	private JScrollPane pnlOtherBlocks;
	private JMenuItem mntmLoadLogicBlocks;
	private JMenuItem mntmSaveSimulation;
	private JMenuItem mntmNewSimulation;
	private ArrayList<LogicBlock> blockDictionary;
	private GraphPanel gp;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		
		setForeground(Color.DARK_GRAY);
		setType(Type.UTILITY);
		setTitle("Digital Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 487);
		
		gp = new GraphPanel();
		gp.setVisible(true);
		
		initComponents();

		initGroupLayouts();

		constructWindow();
				
		initActions();		
		
		DrawingPalletWindow janela= new DrawingPalletWindow();
		janela.setVisible(true);
		
	}
	
	private void constructWindow() {
		setJMenuBar(menuBar);
		
		tabsPane.addTab("New tab", null, scrollPane, null);
		scrollPane.setViewportView(simPanel);
		
		
		
		menuBar.add(mnFile);
		menuBar.add(mnProperties);
		menuBar.add(mntmAboutUs);
		
		setContentPane(contentPane);				
		contentPane.setLayout(gl_contentPane);
		pnlSimulationButtons.setLayout(new GridLayout(0, 5, 0, 0));
		
		pnlSimulationButtons.add(btnPause);
		pnlSimulationButtons.add(btnStart);
		pnlSimulationButtons.add(btnStop);
		pnlSimulationButtons.add(btnStep);
		pnlSimulationButtons.add(btnStopClock);
		
	}

	private void initComponents() {
		menuBar = new JMenuBar();
		
		mnFile = new JMenu("File");
		mnFile.setMnemonic('f');
		
		mntmOpenSimulation = new JMenuItem("Open a simulation");
		mntmLoadLogicBlocks = new JMenuItem("Load logic blocks");
		mntmSaveSimulation = new JMenuItem("Save simulation");
		mntmNewSimulation = new JMenuItem("New Simulation...");

		mnFile.add(mntmOpenSimulation);
		mnFile.add(mntmLoadLogicBlocks);
		mnFile.add(mntmSaveSimulation);
		mnFile.add(mntmNewSimulation);
		
		mnProperties = new JMenu("Properties");
		mnProperties.setMnemonic('p');
		
		mntmSettings = new JMenuItem("Settings");
		
		mnProperties.add(mntmSettings);
		
		mntmAboutUs = new JMenu("About Us");
		mntmAboutUs.setMnemonic('a');
		
		mnItemLoad = new JMenuItem("New menu item");
		mntmAboutUs.add(mnItemLoad);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		simPanel = new JPanel();
		simPanel.setPreferredSize(new Dimension(1000,300));
		simPanel.setBackground(Color.WHITE);
		simPanel.setForeground(Color.LIGHT_GRAY);
		simPanel.setLayout(null);
	//	simPanel.setBounds(0, 0, 900, 900);
		
		//blocks = new ArrayList<JPanel>();

		block = new LogicBlock("C:\\Users\\Paulo Augusto\\Desktop\\image.jpg", "myblock");
		
//		SaveWorker.saveObject("C:\\Users\\Paulo Augusto\\Desktop\\block.ser",block);
//		
//		LogicBlock otherblock;
//		otherblock = (LogicBlock) SaveWorker.getObject("C:\\Users\\Paulo Augusto\\Desktop\\block.ser");
		simPanel.add(block);
		
		tabsPane = new JTabbedPane(JTabbedPane.TOP);
	
		scrollPane = new JScrollPane();		
		scrollPane.setPreferredSize(new Dimension(700,300));
		
		
		pnlLogicBlocks = new JScrollPane();
		
		JList lstLogicBlocks = new JList();
		lstLogicBlocks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(lstLogicBlocks.getSelectedIndex());
			}
		});
		lstLogicBlocks.setModel(new AbstractListModel() {
			String[] values = new String[] {"Paulo", "Axel", "Fran"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		pnlLogicBlocks.setViewportView(lstLogicBlocks);
		
		pnlOtherBlocks = new JScrollPane();
		
		JList lstOtherBlocks = new JList();
		pnlOtherBlocks.setViewportView(lstOtherBlocks);
		
		btnPause = new JButton("");
		btnPause.setIcon(new ImageIcon("C:\\Users\\Paulo Augusto\\eclipse-workspace\\Simulator_GUI\\resources\\play.png"));
		btnPause.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPause.setToolTipText("Pause simulation");
		transparentIcon(btnPause);

		
		btnStart = new JButton("");
		btnStart.setIcon(new ImageIcon("C:\\Users\\Paulo Augusto\\eclipse-workspace\\Simulator_GUI\\src\\resources\\play.png"));
		btnStart.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnStart.setToolTipText("Start simulation");
		transparentIcon(btnStart);
		
		btnStop = new JButton("");
		btnStop.setIcon(new ImageIcon("C:\\Users\\Paulo Augusto\\eclipse-workspace\\Simulator_GUI\\src\\resources\\stop.png"));
		btnStop.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnStop.setToolTipText("Stop Simulation");
		transparentIcon(btnStop);
		
		btnStep = new JButton("");
		btnStep.setIcon(new ImageIcon("C:\\Users\\Paulo Augusto\\eclipse-workspace\\Simulator_GUI\\src\\resources\\step.png"));
		btnStep.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnStep.setToolTipText("Advance a step in time");
		transparentIcon(btnStep);
		
		btnStopClock = new JButton("");
		btnStopClock.setIcon(new ImageIcon("C:\\Users\\Paulo Augusto\\eclipse-workspace\\Simulator_GUI\\src\\resources\\clock.png"));
		btnStopClock.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnStopClock.setToolTipText("Start/Stop clocks");
		transparentIcon(btnStopClock);
		
		
		pnlSimulationButtons = new JPanel();
		pnlSimulationButtons.setLayout(new GridLayout(0, 5, 0, 0));		
		pnlSimulationButtons.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	
	}
	private void initGroupLayouts() {
		
//		gl_simPanel = new GroupLayout(simPanel);
//		gl_simPanel.setHorizontalGroup(
//			gl_simPanel.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_simPanel.createSequentialGroup()
//					.addGap(25)
//					.addComponent(block, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
//					.addContainerGap(329, Short.MAX_VALUE))
//		);
//		gl_simPanel.setVerticalGroup(
//			gl_simPanel.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_simPanel.createSequentialGroup()
//					.addGap(30)
//					.addComponent(block, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
//					.addContainerGap(271, Short.MAX_VALUE))
//		);
//		simPanel.setLayout(gl_simPanel);
		

	
		
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlSimulationButtons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnlOtherBlocks, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
						.addComponent(pnlLogicBlocks))
					.addGap(18)
					.addComponent(tabsPane, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pnlSimulationButtons, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlLogicBlocks, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlOtherBlocks, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
				.addComponent(tabsPane, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
		);
		
			
	}
	
	private void transparentIcon(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
	
	private void initActions() {
		
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStopClock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		simPanel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				simPanel.remove(selectedBlock);
				
			}
		});
		
		simPanel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				selectedBlock = (LogicBlock) simPanel.getComponentAt(arg0.getX(),arg0.getY());
				if( selectedBlock == null || !(simPanel.getComponentAt(arg0.getX(),arg0.getY()) instanceof LogicBlock) ) {
					return;
				}
		
				if(arg0.getButton() != arg0.BUTTON1) {
					simPanel.remove(selectedBlock);
					simPanel.repaint();
					return;
					
				}
				
				if(selectedBlock.isSelected) {
					selectedBlock.select();
					simPanel.removeMouseMotionListener(simPanel.getMouseMotionListeners()[0]);
					return;
				}	
				
				selectedBlock.select();
								
				simPanel.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseMoved(MouseEvent arg0) {
						
						if(selectedBlock.isSelected) {
							System.out.println(selectedBlock.getWidth()+" "+selectedBlock.getHeight());
							//selectedBlock.setBounds(-selectedBlock.getWidth()/2+selectedBlock.getX()+arg0.getX()-10,-selectedBlock.getHeight()/2+selectedBlock.getY()+arg0.getY()-10, 121, 121);
							selectedBlock.setBounds(-selectedBlock.getWidth()/2+arg0.getX(),-selectedBlock.getHeight()/2+arg0.getY(), selectedBlock.getWidth(), selectedBlock.getHeight());
						}
					}
				});						
			}
		});
		
		
	}
}
