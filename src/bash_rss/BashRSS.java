package bash_rss;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

public class BashRSS {
	public static void main (String[] arg) throws XmlPullParserException, IOException, BashParserException  {
		URL url = new URL ("http://bash.im/rss/");
		Parser parser = new Parser();
		ArrayList<Item> feeds = parser.fethFeeds(url);
		for (Item item : feeds){
			System.out.println(item);
		}
	}
}


