
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIInterface{
	private static JFrame frame1;
	private static JButton loginSubmit;
	private static JTextField userNameT;
	private static JTextField passwordT;
	private static JLabel userLabel;
	private static JLabel passwordLabel;
	private static JLabel loginInvalidLabel;
	private static JLabel loginMismatchLabel;
	private static Frame2 frame2;
	private static String userName;
		
	
	GUIInterface(){
		createFrames();
		createButtons();
		activateButtons();
		//setPanels();
		setLabels();
		setTextInput();
		
	}
		

	public static void createFrames() {

			
		frame1 = new JFrame("Welcome to your Hotel Account!");
		frame1.setSize(800,400);
		frame1.getContentPane();
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(null);
		frame1.setResizable(false);
			
			
	}
		

	public static void createButtons() {
		loginSubmit = new JButton("Submit");
		loginSubmit.setSize(100, 50);
		frame1.add(loginSubmit);
		loginSubmit.setLocation(350, 300);
		
	}
	
	public static void activateButtons() {
		loginSubmit.addActionListener(new ActionListener (){
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
//				boolean login_success = false;
//				String guest_username = userNameT.getText();
//				String guest_password = passwordT.getText();
//
//				
//				if (guest_username == "" || guest_password == "") {
//					loginInvalidLabel.setVisible(true);
//					return;
//					
//				}
//
//				//login_success = myDatabase.checkLogin(guest_username, guest_password);
//				
//				if (!(login_success)) {
//					loginMismatchLabel.setVisible(true);
//					return;
//				}
				
				//userName = guest_username; 
				frame1.setVisible(false);
				frame2 = new Frame2();
				frame2.setVisible();
			}
			
		});
	}
	
	public static void setTextInput() {
		userNameT = new JTextField();
		passwordT = new JTextField();
		
		userNameT.setBounds(270, 100, 250, 30);
		passwordT.setBounds(270, 150, 250, 30);
		
		frame1.add(userNameT);
		frame1.add(passwordT);
		
		userNameT.setVisible(true);
		passwordT.setVisible(true);
		
		
		//will need to getText later
	}

	
	public static void setLabels() {
		userLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		loginInvalidLabel = new JLabel("Please enter a valid username/password.");
		loginMismatchLabel = new JLabel("We couldn't find an account with that username/password.");
		
		userLabel.setBounds(170, 105, 250, 20);
		passwordLabel.setBounds(170, 155, 250,20);
		loginInvalidLabel.setBounds(250, 50, 250, 30);
		loginMismatchLabel.setBounds(250, 50, 250, 30);
		
		userLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		loginInvalidLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		loginMismatchLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		userLabel.setLayout(null);
		passwordLabel.setLayout(null);
		loginInvalidLabel.setLayout(null);		
		loginMismatchLabel.setLayout(null);
		
		userLabel.setVisible(true);
		passwordLabel.setVisible(true);
		loginInvalidLabel.setVisible(true);
		loginMismatchLabel.setVisible(true);
		
		frame1.add(userLabel);
		frame1.add(passwordLabel);
		frame1.add(loginInvalidLabel);
		frame1.add(loginMismatchLabel);
	}
	

	
}



