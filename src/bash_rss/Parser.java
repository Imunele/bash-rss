package bash_rss;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Parser  {
	private final static String ITEM_TAG="item";
	
	private ArrayList<Item> doParse (URL url) throws BashParserException{
		ArrayList<Item> feeds = new ArrayList<Item> ();
		try {
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
					item = getItem(xpp);
					feeds.add(item);
				} 			
			}		
			eventType = xpp.next();
			}
		} catch (Exception e) {
			throw new BashParserException ("wrong url");
		}
		return feeds;
		}
	
	private Item getItem (XmlPullParser xpp) throws XmlPullParserException, IOException {
		Item item = new Item();	
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
		return item;		
	}
	
	public ArrayList<Item> fetchFeeds(URL url) {
		ArrayList<Item> feeds = new ArrayList<Item>();
		try {
			feeds = doParse(url);
		} catch (BashParserException e) {
			e.printStackTrace();
		}
		return feeds;
	}
	
		
	}
