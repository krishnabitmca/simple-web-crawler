package example.webcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Basic web crawler to show case how it works in one domain
 * 
 * @author Admin
 *
 */
public class SimpleWebcrawler {

	private static int MAX_DEPTH = 2;
	private List<String> links;
	private static String DOMAIN;
	private static boolean searchOtherDomain;

	public SimpleWebcrawler() {
		links = new ArrayList<String>();
	}

	/**
	 * This accepts URL and depth to start the crawling in given domain.
	 * 
	 * @param URL
	 *            <code>String</code> to crawl
	 * @param depth<code>String</code>
	 *            depth size for crawling
	 */
	public void getPageLinks(String URL, int depth) {
		if ((!links.contains(URL) && (depth <= MAX_DEPTH) && searchToGivenDomain(URL))) {

			try {
				Extracter.printWeb(URL);
				links.add(URL);

				Document document = Jsoup.connect(URL).get();
				Elements linksOnPage = document.select("a[href]");

				depth++;
				for (Element page : linksOnPage) {
					getPageLinks(page.attr("abs:href"), depth);
				}
			} catch (IOException e) {
				System.err.println("For '" + URL + "': " + e.getMessage());
			}
		}
	}

	private boolean searchToGivenDomain(String URL) {
		if (searchOtherDomain) {
			if (URL.startsWith(DOMAIN)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}

	}

	public static void main(String[] args) {
		isTrue(args.length == 3, "usage: supply url to fetch");
		DOMAIN = args[0];
		MAX_DEPTH = Integer.parseInt(args[1]);
		searchOtherDomain = Boolean.parseBoolean(args[2]);
		new SimpleWebcrawler().getPageLinks(DOMAIN, 1);
	}

	/**
	 * Validates that the value is true
	 * 
	 * @param val
	 *            <code>boolean</code> object to test
	 * @param msg
	 *            <code>Stirng</code> message to output if validation fails
	 */
	public static void isTrue(boolean val, String msg) {
		if (!val)
			throw new IllegalArgumentException(msg);
	}

}
