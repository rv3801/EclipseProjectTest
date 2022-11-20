
public class TestDatabase {

	public static void main(String[] args) {
		DatabaseController myDatabase = new DatabaseController();
		//myDatabase.getGuests();
		System.out.println(myDatabase.guestLogin("4", "password"));
	}

}
