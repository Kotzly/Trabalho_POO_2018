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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel pnlItems;
	private JTabbedPane tabsPane;
	private JPanel simPanel;
	private LogicBlock rect1;
	private LogicBlock rect2;
	private LogicBlock selectedBlock;

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
		setBounds(100, 100, 718, 487);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('f');
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenu mnProperties = new JMenu("Properties");
		mnProperties.setMnemonic('p');
		menuBar.add(mnProperties);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnProperties.add(mntmNewMenuItem_1);
		
		JMenu mnAbout = new JMenu("About");
		mnAbout.setMnemonic('a');
		menuBar.add(mnAbout);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnAbout.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		pnlItems = new JPanel();
		pnlItems.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		tabsPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pnlItems, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabsPane, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(tabsPane, Alignment.LEADING)
						.addComponent(pnlItems, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		tabsPane.addTab("New tab", null, scrollPane, null);
		
		simPanel = new JPanel();
		simPanel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				simPanel.remove(selectedBlock);
			}
		});
		

		
		simPanel.setBackground(Color.WHITE);
		simPanel.setForeground(Color.LIGHT_GRAY);
		
		scrollPane.setViewportView(simPanel);
		
		
		rect1 = new LogicBlock();
		System.out.print(rect1.myg);
		rect1.setBackground(Color.WHITE);
		
		GroupLayout gl_simPanel = new GroupLayout(simPanel);
		gl_simPanel.setHorizontalGroup(
			gl_simPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(rect1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
		);
		gl_simPanel.setVerticalGroup(
			gl_simPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_simPanel.createSequentialGroup()
					.addComponent(rect1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(165))
		);
		simPanel.setLayout(gl_simPanel);

		
		contentPane.setLayout(gl_contentPane);
		
		initActions();
		
	}
	
	private void initActions() {
		
		
		simPanel.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if( !(simPanel.getComponentAt(arg0.getX(),arg0.getY()) instanceof LogicBlock) ) {
					return;
				}
				
				selectedBlock = (LogicBlock) simPanel.getComponentAt(arg0.getX(),arg0.getY());
				if(selectedBlock == null) {
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
							selectedBlock.setBounds(-selectedBlock.getWidth()/2+arg0.getX()-10,-selectedBlock.getHeight()/2+arg0.getY()-10, 121, 121);
						}
						
					}
				});
				
								
			}
		});
		
		
		
	}
}
