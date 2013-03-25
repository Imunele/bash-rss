package bash_rss;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Parser  {
	private final static String ITEM_TAG="item";
	private ArrayList<Item> doParse (URL url) throws  BashParserException{
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
					if (ITEM_TAG.equals(tag)) {
						Item item = new Item();	
						item = getItem(xpp);
						feeds.add(item);
					} 			
				}		
				eventType = xpp.next();
			}
		} catch (XmlPullParserException e) {
			throw new BashParserException("it can not parse");
		}
		  catch (IOException e) {
			  throw new BashParserException("incorrect stream");
		}
		return feeds;
		}

	private Item getItem (XmlPullParser xpp) throws BashParserException{
		Item item = new Item();	
		try {
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
		} catch (Exception e) {
			throw new BashParserException("cant get item");
		}
		return item;

	}

	public ArrayList<Item> fetchFeeds(String sUrl) throws   BashParserException{
		ArrayList<Item> feeds = new ArrayList<Item>();
		try {
			URL url = new URL (sUrl);
			feeds = doParse(url);
		} catch (MalformedURLException e) {
			throw new BashParserException("incorrect url");
		}
		return feeds;
	}


	}