package bash_rss;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

public class BashRSS {
	public static void main (String[] arg) throws XmlPullParserException, IOException  {
		URL url = new URL ("http://bash.im/rss/");
		ArrayList<Item> feeds = new ArrayList<Item>();
		Parser parser = new Parser();
		parser.doParse(url, feeds);
		for (int i = 0; i < feeds.size(); i++) {
			System.out.print(feeds.get(i));
		}
	}
}


