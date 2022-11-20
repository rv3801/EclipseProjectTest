
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

	
public class GUIInterface implements ActionListener{
	private static JFrame frame1;
	private static JButton loginSubmit;
	private static JPanel loginPanel;
	private static JTextField userName;
	private static JTextField password;
	private static JLabel userLabel;
	private static JLabel passwordLabel;
		
	
	GUIInterface(){
		createFrames();
		createButtons();
		activateButtons();
		//setPanels();
		setLabels();
		setTextInput();
		
	}
		

	public static void createFrames() {
//			loginPanel = new JPanel();
//			loginPanel.setBounds(250, 100, 300, 50);
		
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
		loginSubmit.addActionListener(new ActionListener () 
			{
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame1.setVisible(false);
				Frame2 frame2 = new Frame2();
				frame2.setVisible();
			}
			
		});
	}
	
	public static void setTextInput() {
		userName = new JTextField();
		password = new JTextField();
		
		userName.setBounds(270, 100, 250, 30);
		password.setBounds(270, 150, 250, 30);
		
//			loginPanel.add(userName);
//			loginPanel.add(password);
		
		frame1.add(userName);
		frame1.add(password);
		
		//frame1.add(loginPanel);
		
		userName.setVisible(true);
		password.setVisible(true);
		
		
		//will need to getText later
	}

	
	public static void setLabels() {
		userLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		
		
		userLabel.setBounds(170, 105, 250, 20);
		passwordLabel.setBounds(170, 155, 250,20);
		
		userLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		userLabel.setLayout(null);
		passwordLabel.setLayout(null);
		
		userLabel.setVisible(true);
		passwordLabel.setVisible(true);
		
		frame1.add(userLabel);
		frame1.add(passwordLabel);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}


