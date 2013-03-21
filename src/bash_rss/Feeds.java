package bash_rss;

import java.util.ArrayList;

public class Feeds {
	
	private ArrayList<Item> list = new ArrayList<Item>();

	public void addItem(Item item) {
			list.add(item);
		}
	
	public void print(Feeds feeds) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
	
	public Feeds(){
	}
	
}
