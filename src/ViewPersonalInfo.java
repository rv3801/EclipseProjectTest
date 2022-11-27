import javax.swing.JFrame;

public class ViewPersonalInfo {
	
	private static JFrame viewInfo;
	
	ViewPersonalInfo(){
		createFrames();
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
}
