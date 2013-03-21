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
	
	void doParse (URL url, ArrayList<Item> feeds) throws XmlPullParserException, IOException{

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
					getItem(xpp, item);
					feeds.add(item);
				} 			
			}		
			eventType = xpp.next();
			}
		fetchFeeds(feeds);
		}
	
	void getItem (XmlPullParser xpp, Item item) throws XmlPullParserException, IOException {
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
	
	void fetchFeeds(ArrayList<Item> feeds){
		for (int i = 0; i < feeds.size(); i++) {
			System.out.print(feeds.get(i));
		}	
	}
	
	public ArrayList<Item> fethFeedsByUrl(URL url) throws XmlPullParserException, IOException{
		ArrayList<Item> feeds = new ArrayList<Item>();
		doParse(url, feeds);
		return feeds;
	}
	
		
	}
