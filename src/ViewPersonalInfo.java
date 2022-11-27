import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewPersonalInfo {
	
	private static JFrame viewInfo;
	private static JButton returnMenu;
	
	ViewPersonalInfo(){
		createFrames();
		createMenuButton();
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
}

