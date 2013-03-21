package bash_rss;

import java.io.IOException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParserException;

public class Bash_rss {
	public static void main (String[] arg) throws XmlPullParserException, IOException  {
		URL url = new URL ("http://bash.im/rss/");
		Feeds feeds = new Feeds();
		Parser parser = new Parser();
		parser.doParse(url, feeds);
		feeds.print(feeds);
		
	}
}


