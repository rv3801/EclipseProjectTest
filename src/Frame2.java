import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame2 {

	private static JFrame frame2;
	private static JButton viewRes;
	private static JButton makeRes;
	private static JButton viewInfo;
	private static JButton logout;
			
			
	Frame2(){
		createFrames();
		createButtons();
	}
	
	
	public static void createFrames() {
		frame2 = new JFrame("MENU");
		frame2.setSize(800,400);
		frame2.getContentPane();
		frame2.setVisible(false);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(null);
		frame2.setResizable(false);
	}
	
	public static void createButtons() {
		viewRes = new JButton("View Reservation");
		viewRes.setSize(200, 50);
		frame2.add(viewRes);
		viewRes.setLocation(150, 100);
		
		makeRes = new JButton("Make a Reservation");
		makeRes.setSize(200, 50);
		frame2.add(makeRes);
		makeRes.setLocation(450, 100);
		
		viewInfo = new JButton("View Personal Information");
		viewInfo.setSize(200, 50);
		frame2.add(viewInfo);
		viewInfo.setLocation(150, 200);
		
		logout = new JButton("Logout");
		logout.setSize(200, 50);
		frame2.add(logout);
		logout.setLocation(450, 200);
		
	}
	
	public void setVisible() {
		frame2.setVisible(true);
	}
	
	public static void activateButtons() {
		viewRes.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		makeRes.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		viewInfo.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		logout.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

}
