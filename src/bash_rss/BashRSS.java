package bash_rss;

import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlPullParserException;

public class BashRSS {
	public static void main (String[] arg) throws XmlPullParserException, IOException  {
		URL url = new URL ("http://bash.im/rss/");
		Parser parser = new Parser();
		parser.fethFeedsByUrl(url);

	}
}


