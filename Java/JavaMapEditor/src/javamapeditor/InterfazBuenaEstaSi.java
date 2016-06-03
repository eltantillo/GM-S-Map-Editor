package javamapeditor;

import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InterfazBuenaEstaSi {
//
//	private JFrame frame;
//	
//	private BackgroundTile bt;
//	private SimpleRoom sr;
//	
//	private int mousePosX,mousePosFinX;
//	private int mousePosY,mousePosFinY;
//	
//	private boolean dragClick;
//	private boolean rectangle;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InterfazBuenaEstaSi window = new InterfazBuenaEstaSi();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public InterfazBuenaEstaSi() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		dragClick = false;
//		frame = new JFrame();
//
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		MenuBar mb = new MenuBar();
//		Menu submenu=new Menu("Capas");
//	    
//	    // Create MenuItems
//		MenuItem m1=new MenuItem("Capa 1");
//		m1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				sr.changeLayer(0);
//			}
//		});
//		MenuItem m2=new MenuItem("Capa 2");
//		m2.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				sr.changeLayer(1);
//			}
//		});
//		MenuItem m3=new MenuItem("Capa 3");
//		m3.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				sr.changeLayer(2);
//			}
//		});
//		MenuItem m4=new MenuItem("Capa 4");
//		m4.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				sr.changeLayer(3);
//			}
//		});
//		MenuItem m5=new MenuItem("Capa 5");
//		m5.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				sr.changeLayer(4);
//			}
//		});
//		
//		submenu.add(m1);
//		submenu.add(m3);
//		submenu.add(m2);
//		submenu.add(m4);
//		submenu.add(m5);
//		
//		mb.add(submenu);
//		
//		Menu submenu2=new Menu("Editar");
//		MenuItem m20 = new MenuItem("Normal");
//		m20.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				rectangle = false;
//			}
//		});
//		MenuItem m21 = new MenuItem("Rectangulo");
//		m21.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				rectangle = true;
//			}
//		});
//		submenu2.add(m20);
//		submenu2.add(m21);
//		mb.add(submenu2);
//		
//		JSplitPane splitPane = new JSplitPane();
//		splitPane.setContinuousLayout(true);
//		splitPane.setBounds(0, 0, 434, 261);
//		
//		frame.getContentPane().add(splitPane);
//		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				if(!rectangle){
//					sr.click(lblNewLabel, bt.toGrid(arg0.getX(),1), bt.toGrid(arg0.getY(),0), bt.getSelectedImage());
//				}
//			}
//		});
//		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
//		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent arg0) {
//				sr.update(lblNewLabel, bt.toGrid(arg0.getX(),1), bt.toGrid(arg0.getY(),0));
//			}
//		});
//		splitPane.setRightComponent(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("");
//		
//		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
//		
//		splitPane.setLeftComponent(lblNewLabel_1);
//		
//		frame.addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentResized(ComponentEvent arg0) {
//				splitPane.setBounds(0, 0, frame.getWidth(),frame.getHeight());
//			}
//		});
//		frame.addWindowStateListener(new WindowStateListener() {
//			public void windowStateChanged(WindowEvent arg0) {
//				splitPane.setBounds(0, 0, frame.getWidth(),frame.getHeight());
//			}
//		});
//		lblNewLabel_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				dragClick = !dragClick;
//				if(dragClick){
//					mousePosX = bt.toGrid(e.getX(), 1);
//					mousePosY = bt.toGrid(e.getY(), 0);
//				}
//				lblNewLabel.setText("clicked = "+ dragClick);
//			}
//		});
//		
//		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				if(dragClick){
//					mousePosFinX = bt.toGrid(e.getX(), 1);
//					mousePosFinY = bt.toGrid(e.getY(), 0);
//					bt.setSelection(new Point(mousePosX,mousePosY), new Point(mousePosFinX,mousePosFinY));
//					bt.drawBackgroundTile(lblNewLabel_1, lblNewLabel);
//					lblNewLabel.setText("activate = "+ dragClick);	
//					sr.updateSelected(bt.getSelectedImage());
//				}
//			}
//		});
//		JFileChooser jfc = new JFileChooser("C:\\Users\\MarcoM\\Documents\\RPGXP\\Remeber School\\Graphics\\Tilesets");
//		jfc.showOpenDialog(null);
//		try{
//			bt = new BackgroundTile(ImageIO.read(jfc.getSelectedFile()),"potato",32,32);
//			bt.drawBackgroundTile(lblNewLabel_1,lblNewLabel);
//			sr = new SimpleRoom(34, 34, 32, 32);
//			sr.update(lblNewLabel, 0, 0);
//			sr.updateSelected(bt.getSelectedImage());
//		}
//		catch(Exception ex){}
//		frame.setMenuBar(mb);
//	}
}
