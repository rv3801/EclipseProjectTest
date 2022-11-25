import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseController {
	private String url = "jdbc:mysql://192.168.1.241:3306/HotelReservations";
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
				if(resultSet.getString(1) == user && resultSet.getString(2) == password) {
					System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
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
}
