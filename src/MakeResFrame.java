
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MakeResFrame {
	
	private static JFrame makeRes;
	private static JFrame pickDate;
	private static JLabel checkIn;
	private static JLabel checkOut;
	private static JLabel exampleDate;
	private static JLabel pickRoom;
	private static JTextField checkInDate;
	private static JTextField checkOutDate;
	private static JButton submitDate;
	private static JButton submitRoom;
	private static JButton returnMenu;
	private static JButton returnMenu2;
	private static JRadioButton king;
	private static JRadioButton queen;

	MakeResFrame(){
		createFrames();
		setRoomTypes();
		activateRoomType();
		checkInOutLabels();
		setTextFields();
	}
	
	public static void createFrames() {
		makeRes = new JFrame("Make a Reservation");
		makeRes.setSize(800,400);
		makeRes.getContentPane();
		makeRes.setVisible(true);
		makeRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeRes.setLayout(null);
		makeRes.setResizable(false);
		
		pickDate = new JFrame("Pick Dates");
		pickDate.setSize(800,400);
		pickDate.getContentPane();
		pickDate.setVisible(true);
		pickDate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pickDate.setLayout(null);
		pickDate.setResizable(false);
		
		returnMenu = new JButton("Return to Menu");
		returnMenu.setSize(150, 20);
		returnMenu.setLocation(620, 10);
		
		returnMenu2 = new JButton("Return to Menu");
		returnMenu2.setSize(150, 20);
		returnMenu2.setLocation(620, 10);
		
		
		makeRes.add(returnMenu);
		pickDate.add(returnMenu2);
		
	}
	
	public void setVisible() {
		makeRes.setVisible(true);
	}
	 
	public static void checkInOutLabels() {
		checkIn = new JLabel("Type Check In Date: ");
		checkOut = new JLabel("Type Check Out Date: ");
		exampleDate = new JLabel("ex. 01/01/2022");
		
		checkIn.setBounds(100, 105, 250, 20);
		checkOut.setBounds(100, 155, 250,20);
		exampleDate.setBounds(275, 170, 250,30);
		
		checkIn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		checkOut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		exampleDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		
		checkIn.setLayout(null);
		checkOut.setLayout(null);
		exampleDate.setLayout(null);
		
		checkIn.setVisible(true);
		checkOut.setVisible(true);
		exampleDate.setVisible(true);
		
		pickDate.add(checkIn);
		pickDate.add(checkOut);
		pickDate.add(exampleDate);

		
	}
	
	public static void setTextFields() {
		checkInDate = new JTextField();
		checkOutDate = new JTextField();
		submitDate = new JButton("Submit");
		
		checkInDate.setBounds(270, 100, 250, 30);
		checkOutDate.setBounds(270, 150, 250, 30);
		submitDate.setSize(100, 50);
		submitDate.setLocation(350, 300);
		
		pickDate.add(checkInDate);
		pickDate.add(checkOutDate);
		pickDate.add(submitDate);
		
		checkInDate.setVisible(true);
		checkOutDate.setVisible(true);
		
	}
	
	public static void setRoomTypes() {
		king = new JRadioButton("King");
		queen = new JRadioButton("Queen");
		pickRoom = new JLabel("Select Room Type: ");
		submitRoom = new JButton("Submit");
		
		king.setBounds(350, 100, 250, 30);
		queen.setBounds(350, 150, 250, 30);
		pickRoom.setBounds(330, 50, 250, 20);
		submitRoom.setSize(100, 50);
		submitRoom.setLocation(350, 300);
		
		pickRoom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pickRoom.setLayout(null);
		
		makeRes.add(king);
		makeRes.add(queen);
		makeRes.add(pickRoom);
		makeRes.add(submitRoom);

	
		king.setVisible(true);
		queen.setVisible(true);
		pickRoom.setVisible(true);
		
	}
	
	public static void activateRoomType() {
		submitRoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//this is where you would show basic room info
				// move to date picker after this
				pickRoom.setVisible(true);
				makeRes.setVisible(false);

			}
			
		});
	}
	
	public static void activateDatePicker() {
		//checkInDate.getText();
		int checkInTime; // checkInTime variable is unix time stamp
		int checkOutTime;
		
		try {
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(checkInDate.getText());
			checkInTime = (int)(date1.getTime()) / 1000;
			
			Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(checkOutDate.getText());
			checkOutTime = (int)(date2.getTime()) / 1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		submitDate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// enter checkInTime and checkOutTime into database?
				// exit to menu????
			}
			
		});
		
	}
	

	public static void returnToMenu() {
		returnMenu.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		returnMenu2.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	

}
