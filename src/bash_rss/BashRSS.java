package bash_rss;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class BashRSS {
	public static void main (String[] arg) throws MalformedURLException, BashParserException{
		URL url = new URL ("http://bash.im/rss/");
		Parser parser = new Parser();
		ArrayList<Item> feeds = parser.fetchFeeds(url);
		for (Item item : feeds){
			System.out.println(item);
		}
	}
}


