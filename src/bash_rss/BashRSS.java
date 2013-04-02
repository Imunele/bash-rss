package bash_rss;

import java.util.ArrayList;

public class BashRSS {
	public static void main (String[] arg) {
		final String sUrl = "http://bash.im/rss";
		Parser parser = new Parser();
		try {
			ArrayList<Item> feeds = parser.fetchFeeds(sUrl);
			for (Item item : feeds){
				System.out.println(item);
			}
		} catch (BashParserException e) {
			System.out.println(e.toString());
		}
	}
}