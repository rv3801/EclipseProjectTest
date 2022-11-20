import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseController {
	private String url = "jdbc:mysql://localhost:3306/HotelReservations";
	private String username = "root";
	private String password = "password123";
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
}
