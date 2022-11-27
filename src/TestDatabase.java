import java.util.HashMap;

public class TestDatabase {

	public static void main(String[] args) {
		DatabaseController myDatabase = new DatabaseController();
		
		myDatabase.getGuests();
		
//		System.out.println(myDatabase.userLogin("daveIsCool", "password123"));
		
//		myDatabase.getHotels();
		
//		HashMap<Integer, String> hotels = myDatabase.getHotels();
//		printMap(hotels);
		
		System.out.println("Check 1");
		HashMap<Integer, String> rooms = myDatabase.getRooms(1);
		printMap(rooms);
	}
	private static void printMap(HashMap<Integer, String> inputMap) {
		for(Integer key : inputMap.keySet()) {
			System.out.println("Key: " + key);
			System.out.println("\tValue: " + inputMap.get(key));
		}
	}

}
