import javax.swing.JFrame;

public class ViewResFrame {

	private static JFrame viewRes;
	
	
	ViewResFrame(){
		createFrames();
		
	}
	
	public static void createFrames() {
		viewRes = new JFrame("View Reservations");
		viewRes.setSize(800,400);
		viewRes.getContentPane();
		viewRes.setVisible(true);
		viewRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewRes.setLayout(null);
		viewRes.setResizable(false);
	}
	
	public void setVisible() {
		viewRes.setVisible(true);
	}
	
	
	
}
