package BP;

import java.io.IOException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParserException;

public class BP {
	public static void main (String[] arg) throws XmlPullParserException, IOException  {
		URL url = new URL ("http://bash.im/rss/");
		Feeds feeds = new Feeds();
		Parser.doParse(url, feeds);
		Feeds.print(feeds);
		
	}
}


