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
			final XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			final InputStream stream = url.openStream();
			xpp.setInput(stream, null);	
			int eventType = xpp.getEventType(); 
			String tag;
			while ( eventType != XmlPullParser.END_DOCUMENT){
				if (eventType == XmlPullParser.START_TAG){
					tag = xpp.getName();
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
			int eventType = xpp.getEventType(); 
			String tag;
			while (eventType != XmlPullParser.END_TAG || !ITEM_TAG.equals(xpp.getName())){
				tag = xpp.getName();
				if (GUID_TAG.equals(tag)){
					item.setJokeGuid(parseGuid(xpp));
					eventType = xpp.next();
				}
				if (LINK_TAG.equals(tag)){
					item.setJokeLink(parseLink(xpp));
					eventType = xpp.next();
				}
				if (TITLE_TAG.equals(tag)){
					item.setJokeTittle(parseTitle(xpp));
					eventType = xpp.next();
				}
				if (DATE_TAG.equals(tag)){
					item.setJokeDate(parseDate(xpp));
					eventType = xpp.next();
				}
				if (JOKE_TAG.equals(tag)){
					item.setJoke(parseJoke(xpp));
					eventType = xpp.next();
				}
				eventType = xpp.next();
			}
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
	private String parseGuid (XmlPullParser xpp) throws BashParserException {
		final String guid;
		try {
			guid = xpp.nextText();
		} catch (XmlPullParserException e) {
			throw new BashParserException("cant get guid");
		} catch (IOException e) {
			throw new BashParserException("cant get guid");
		}
		return guid;
	}
	private String parseLink (XmlPullParser xpp) throws BashParserException {
		final String link;
		try {
			link = xpp.nextText();
		} catch (XmlPullParserException e) {
			throw new BashParserException("cant get link");
		} catch (IOException e) {
			throw new BashParserException("cant get link");
		}
		return link;
	}
	private String parseTitle (XmlPullParser xpp) throws BashParserException {
		final String title;
		try {
			title = xpp.nextText();
		} catch (XmlPullParserException e) {
			throw new BashParserException("cant get title");
		} catch (IOException e) {
			throw new BashParserException("cant get title");
		}
		return title;
	}
	private String parseDate (XmlPullParser xpp) throws BashParserException {
		final String date;
		try {
			date = xpp.nextText();
		} catch (XmlPullParserException e) {
			throw new BashParserException("cant get date");
		} catch (IOException e) {
			throw new BashParserException("cant get date");
		}
		return date;
	}
	private String parseJoke (XmlPullParser xpp) throws BashParserException {
		final String joke;
		try {
			joke = xpp.nextText();
		} catch (XmlPullParserException e) {
			throw new BashParserException("cant get joke");
		} catch (IOException e) {
			throw new BashParserException("cant get joke");
		}
		return joke;
	}
}