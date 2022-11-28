import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewResFrame {

	private static JFrame viewRes;
	private static JTextArea textArea;
	private static JScrollPane scrollPane;
	private static JButton returnMenu;
	
	ViewResFrame(){
		createFrames();
		createScrollPane();
		createMenuButton();
	}
	
	public static void createFrames() {
		viewRes = new JFrame("View Reservations");
		viewRes.setSize(800,400);
		viewRes.getContentPane();
		viewRes.setVisible(true);
		viewRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewRes.setLayout(new FlowLayout());
		viewRes.setResizable(false);
	}
	
	public void setVisible() {
		viewRes.setVisible(true);
	}
	
	public static void createScrollPane() {
		textArea = new JTextArea(20,40);
		scrollPane = new JScrollPane(textArea);
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		viewRes.getContentPane().add(scrollPane); 
	}
	
	public static void createText() {
		
	}
	
	public static void createMenuButton() {
		returnMenu = new JButton("Return to Menu");
		returnMenu.setSize(150, 20);
		returnMenu.setLocation(650, 10);
		
		viewRes.add(returnMenu);
	}
	
	
}
