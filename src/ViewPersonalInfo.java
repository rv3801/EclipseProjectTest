import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewPersonalInfo {
	
	private static JFrame viewInfo;
	private static JButton returnMenu;
	private static JLabel name;
	private static JLabel userId;
	private static JLabel email;
	private static JLabel rewards;

	ViewPersonalInfo(){
		createFrames();
		createMenuButton();
		createText();
	}
	
	public static void createFrames() {
		viewInfo = new JFrame("View Personal Info");
		viewInfo.setSize(800,400);
		viewInfo.getContentPane();
		viewInfo.setVisible(true);
		viewInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewInfo.setLayout(null);
		viewInfo.setResizable(false);
	}
	
	public void setVisible() {
		viewInfo.setVisible(true);
	}
	
	public static void createMenuButton() {
		returnMenu = new JButton("Return to Menu");
		returnMenu.setSize(150, 20);
		returnMenu.setLocation(620, 10);
		
		viewInfo.add(returnMenu);
	}
	
	public static void createText() {
		name = new JLabel("Name: ");
		userId = new JLabel("User ID: ");
		email = new JLabel("Email: ");
		rewards = new JLabel("Rewards Points: ");

		
		name.setBounds(250, 105, 250, 20);
		userId.setBounds(250, 135, 250, 20);
		email.setBounds(250, 165, 250, 20);
		rewards.setBounds(250, 195, 250, 20);

		
		name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		userId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		email.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		rewards.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		name.setLayout(null);
		userId.setLayout(null);
		email.setLayout(null);
		rewards.setLayout(null);

		name.setVisible(true);
		userId.setVisible(true);
		email.setVisible(true);
		rewards.setVisible(true);

		viewInfo.add(name);
		viewInfo.add(userId);
		viewInfo.add(email);
		viewInfo.add(rewards);

	}
}

