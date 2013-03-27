package bash_rss;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Parser {
	private final static String ITEM_TAG="item";
	private final static String GUID_TAG="guid";
	private final static String LINK_TAG="link";
	private final static String TITLE_TAG="title";
	private final static String DATE_TAG="pubDate";
	private final static String JOKE_TAG="description";
	private ArrayList<Item> doParse (URL url) throws  BashParserException {
		ArrayList<Item> feeds = new ArrayList<Item> ();
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			InputStream stream = url.openStream();
			xpp.setInput(stream, null);	
			int eventType = xpp.getEventType(); 
			String tag = new String();
			while ( eventType != XmlPullParser.END_DOCUMENT){
				if (eventType == XmlPullParser.START_TAG){
					tag = xpp.getName();
					if (ITEM_TAG.equals(tag)) {
						Item item = new Item();	
						item = getItem(xpp);
						feeds.add(item);
						System.out.println("-----------------------------------------------------------------------------");
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
			int eventType = xpp.getEventType(); 
			String tag = new String();
			while (eventType != XmlPullParser.END_TAG || !ITEM_TAG.equals(xpp.getName())){
				tag = xpp.getName();
				if (GUID_TAG.equals(tag)){
					String str = xpp.nextText();
					item.setJokeGuid(str);
					System.out.println(str);
				}
				if (LINK_TAG.equals(tag)){
					String str = xpp.nextText();
					item.setJokeGuid(str);
					System.out.println(str);
				}
				if (TITLE_TAG.equals(tag)){
					String str = xpp.nextText();
					item.setJokeGuid(str);
					System.out.println(str);
				}
				if (DATE_TAG.equals(tag)){
					String str = xpp.nextText();
					item.setJokeGuid(str);
					System.out.println(str);
				}
				if (JOKE_TAG.equals(tag)){
					String str = xpp.nextText();
					item.setJokeGuid(str);
					System.out.println(str);
				}
				eventType = xpp.next();
			}
			/*xpp.nextTag();
			item.setJokeGuid(xpp.nextText());
			xpp.nextTag();
			item.setJokeLink(xpp.nextText());
			xpp.nextTag();
			item.setJokeTittle(xpp.nextText());
			xpp.nextTag();
			item.setJokeDate(xpp.nextText());
			xpp.nextTag();
			item.setJoke(xpp.nextText());*/
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