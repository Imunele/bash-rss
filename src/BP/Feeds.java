package BP;

import java.util.ArrayList;

public class Feeds {

	private static ArrayList<Item> List = new ArrayList<Item>();

	public void addItem(Item item) {
			List.add(item);
		}
	
	public static void print(Feeds feeds) {
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i));
		}
	}
	
	public Feeds(){
	}
	
}
