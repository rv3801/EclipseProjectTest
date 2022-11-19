import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

	
public class GUIInterface implements ActionListener{
		private static JFrame frame1;
		private static JFrame frame2;
		private static JButton loginSubmit;
		
		
		GUIInterface(){
			createFrames();
			createButtons();
			activateButtons();
		}
		

		private static void createFrames() {
			frame1 = new JFrame("LOGIN");
			frame1.setSize(800,400);
			frame1.getContentPane().setBackground(Color.green);
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setLayout(null);
			
			frame2 = new JFrame("MENU");
			frame2.setSize(800,400);
			frame2.getContentPane().setBackground(Color.yellow);
			frame2.setVisible(false);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setLayout(null);
			
		}
		
		private static void createButtons() {
			loginSubmit = new JButton("Submit");
			loginSubmit.setSize(100, 50);
			frame1.add(loginSubmit);
			loginSubmit.setLocation(360, 300);
			
		}
		
		public static void activateButtons() {
			loginSubmit.addActionListener((ActionEvent e) ->{
				frame1.setVisible(false);
				frame2.setVisible(true);
			});
		}
		
		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}


