package BP;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Parser  {
	public final static String ITEM_TAG="item";
	
	public static void doParse (URL url, Feeds feeds) throws XmlPullParserException, IOException{
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();
		InputStream stream = url.openStream();
		xpp.setInput(stream, null);	
		int eventType = xpp.getEventType(); 
		while ( eventType != XmlPullParser.END_DOCUMENT){
			if (eventType == XmlPullParser.START_TAG){
				String tag = xpp.getName();
				if (ITEM_TAG.equals(tag)){
					Item item = new Item();	
					Parser.getItem(xpp, item);
					feeds.addItem(item);
				} 			
			}		
			eventType = xpp.next();
			}
		}
	
	public static void getItem (XmlPullParser xpp, Item item) throws XmlPullParserException, IOException {
		xpp.nextTag();
		item.setJokeGuid(xpp.nextText());
		xpp.nextTag();
		item.setJokeLink(xpp.nextText());
		xpp.nextTag();
		item.setJokeTittle(xpp.nextText());
		xpp.nextTag();
		item.setJokeDate(xpp.nextText());
		xpp.nextTag();
		item.setJoke(xpp.nextText());
		
	}
		
	}
