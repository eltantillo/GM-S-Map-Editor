package javamapeditor;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;

import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSplitPane;
import java.awt.ScrollPane;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;

public class OtheClass {

//	private JFrame frame;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OtheClass window = new OtheClass();
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
//	public OtheClass() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		ScrollPane scrollPane = new ScrollPane();
//		scrollPane.setBackground(Color.RED);
//		scrollPane.setBounds(0, 0, 146, 261);
//		frame.getContentPane().add(scrollPane);
//		
//		ScrollPane scrollPane_1 = new ScrollPane();
//		scrollPane_1.setBackground(Color.DARK_GRAY);
//		scrollPane_1.setBounds(146, 0, 288, 261);
//		frame.getContentPane().add(scrollPane_1);
//		
//		ImageIcon ii = new javax.swing.ImageIcon(getClass().getResource("/car.png"));
//
//		for(int x=0; x < (ii.getIconHeight()/32); x++ ){
//			System.out.println(x + " < "+(ii.getIconHeight()/32));
//			for(int y=0; y< (ii.getIconWidth()/32); y++ ){
//				BufferedImage bi = new BufferedImage(
//				    ii.getIconWidth(),
//				    ii.getIconHeight(),
//				    BufferedImage.TYPE_INT_ARGB);
//				
//				Graphics g = bi.createGraphics();
//				// paint the Icon to the BufferedImage.
//				ii.paintIcon(null, g, 0,0);
//				g.dispose();
//				try{
//				Image i = (Image) bi.getSubimage(y*32, x*32, 32, 32);
//				
//				JLabel other = new JLabel();
//				other.setIcon(new ImageIcon(i));
//				other.setBounds(y*32, x*32, ii.getIconWidth(), ii.getIconHeight());
//				frame.getContentPane().add(other);
//				System.out.println("Listo " + x+","+y +" what H"+ii.getIconHeight()+" W"+ii.getIconWidth());
//				}
//				catch(Exception ex){
//					System.err.println(ex.toString());
//				}
//			}
//		}
//		frame.addWindowStateListener(new WindowStateListener() {
//			public void windowStateChanged(WindowEvent arg0) {
//				
//			}
//		});
//		//frame.getContentPane().add(cutImg);
//	}
}
