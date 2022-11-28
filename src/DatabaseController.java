import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseController {
	private String url = "jdbc:mysql://134.69.195.86:3306/HotelReservations";
	private String username = "newuser";
	private String password = "password";
	private Connection connection;
	
	public DatabaseController(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			this.connection = DriverManager.getConnection(url, username, password);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	public void getGuests() {
		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from guest");
			
			while(resultset.next()) {
				System.out.println(resultset.getString(1) + " " + resultset.getString(2));
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	public boolean userLogin(String user, String password) {
		try {
			Statement statement = this.connection.createStatement();
			String queryString = "select guest_id, guest_password, guest_fname from Guest "
					+ "where guest_id = \"" + user + "\"";
			ResultSet resultSet = statement.executeQuery(queryString);
			
			if(resultSet.isBeforeFirst()) {
				resultSet.next();
				System.out.println("Check 1");
				
				if(user.equals(resultSet.getString(1)) && password.equals(resultSet.getString(2))) {
					System.out.println("Check 2");
					return true;
				}
			}
			System.out.println("No such username");
			return false;
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public HashMap<Integer, String> getHotels(){
		try {
			ResultSet resultSet = runQuery("select hotel_id, hotel_name, hotel_location from Hotel");
			HashMap<Integer, String> returnMap = new HashMap<Integer, String>();
			
			while(resultSet.next()) {
				returnMap.put(resultSet.getInt(1), resultSet.getString(2) + " (" + resultSet.getString(3) + ")");
			}
			return returnMap;
		}
		catch (Exception e){
			System.out.println(e);
			return null;
		}
	}
	private ResultSet runQuery(String query) {
		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			return resultSet;
		}
		catch (Exception e){
			System.out.println(e);
			return null;
		}
	}
	public HashMap<Integer, String> getRooms(Integer hotel_id) {
		try {
			System.out.println("Check 2");
			ResultSet resultSet = runQuery("select room_id, room_type from Room "
					+ "where hotel_id = " + hotel_id);
			HashMap<Integer, String> returnMap = new HashMap<Integer, String>();
			
			while(resultSet.next()) {
				returnMap.put(resultSet.getInt(1), resultSet.getString(2));
			}
			System.out.println("Check 3");
			return returnMap;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public boolean makeReservation(int hotel_id, int room_id, int check_in, int check_out, int guest_id) {
		try {
			//TODO
			return false;
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	// TODO Fix mySQL syntax error
	public int checkAvail(int hotel_id, String room_type, int check_in, int check_out) {
		try {
			ResultSet resultSet = runQuery("select room_id from Room "
					+ "where hotel_id = " + hotel_id + " "
					+ "and room_type = \"" + room_type + "\" "
					+ "and room_id NOT IN "
						+ "(select room_id from reservation "
						+ "where hotel_id = " + hotel_id + " "
						+ "and "
							+ "(check_out > " + check_in + " and check_out < " + check_out + ") "
						+ "or "
							+ "(check_in > " + check_in + " and check_in < " + check_out + ") "
						+ "or "
							+ "(check_in < " + check_in + " and check_out > " + check_out + ") "
						+ ")");
			if(resultSet.isBeforeFirst()) {
				resultSet.next();
				return resultSet.getInt(1);
			}
			else {
				return -1;
			}
//			while(resultSet.next()) {
//				System.out.println(resultSet.getInt(1));
//			}
//			return -1;
		}
		catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	public void getReservations(String user) {
		
		String resultString = "";
		String[] reservations;
		String finalString = "<html>";
		
		try {
			ResultSet resultSet = runQuery("select reservation.check_in, reservation.check_out, hotel.hotel_name, reservation.room_id, reservation.rewards_points from reservation, hotel "
					+ "where reservation.hotel_id = hotel.hotel_id "
					+ " and reservation.guest_id = " + user + ";");
			
			if (resultSet.next() == false) {
				System.out.println("You have no upcoming reservations.");
			}
			else {
				do {
//					resultString += resultSet.getInt(1) + " ";
					
					finalString += "(" + resultSet.getInt(1) + " - " + resultSet.getInt(2) + ")"
							+ " " + resultSet.getString(3) + " - " + resultSet.getInt(4)
							+ "<br/>" + "(" + resultSet.getInt(5) + ")" + "<br/>";

			        } while (resultSet.next());
				
			}
					
			
//			reservations = resultString.split(" ");
//			
//			for (int i = 0; i < reservations.length; i++) {
//				
//				finalString += getReservationInfo(reservations[i]);
//			}
//			
//			
			System.out.println(finalString);
		}
		catch (Exception e) {
			System.out.println(e);
			return;
		}
		
		
		// reservation id, check-in, check-out, hotel id, room id, rewards points
		
		// TODO
	}
	
}
