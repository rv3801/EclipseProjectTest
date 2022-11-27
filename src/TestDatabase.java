import java.util.HashMap;

public class TestDatabase {

	public static void main(String[] args) {
		DatabaseController myDatabase = new DatabaseController();
		
//		myDatabase.getGuests();
		
//		System.out.println(myDatabase.userLogin("daveIsCool", "password123"));
		
//		myDatabase.getHotels();
		
//		HashMap<Integer, String> hotels = myDatabase.getHotels();
//		printMap(hotels);
		
//		HashMap<Integer, String> rooms = myDatabase.getRooms(1);
//		printMap(rooms);
		
		int checkIn = 1667808000;
		int checkOut = 1668067200;
		System.out.println(myDatabase.checkAvail(1, "king", checkIn, checkOut));
	}
	private static void printMap(HashMap<Integer, String> inputMap) {
		for(Integer key : inputMap.keySet()) {
			System.out.println("Key: " + key);
			System.out.println("\tValue: " + inputMap.get(key));
		}
	}

}
