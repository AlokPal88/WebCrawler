import java.io.IOException;
import java.io.*;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.HttpStatusException;
 
public class Crawler {
	static final int MAX_PAGES_TO_SEARCH = 300;
	private static Set<String> pagesVisited = new HashSet<String>();
	private static Queue<String> pagesToVisit = new LinkedList<String>();
	private static String userQuery;
	
	public static void main(String[] args) throws IOException {

		try (Scanner scan = new Scanner(System.in)){
			System.out.println("Please enter your search string: ");
			userQuery = scan.next();
			
			processPage("http://www.unt.edu");
		}
		catch (IOException e){}
	}
 
	public static void processPage(String URL) throws IOException {
		
		//get useful information
		pagesVisited.add(URL);
		pagesToVisit.add(URL);
 	
		while(pagesToVisit.size() != 0 && pagesVisited.size() != MAX_PAGES_TO_SEARCH)	
		{
			String nextURL = pagesToVisit.poll();
			try{
				Document doc = Jsoup.connect(nextURL).ignoreContentType(true).timeout(0).get();
				
				if (doc.text().contains(userQuery))
				{
					Elements webPages = doc.select("a[href]");
					
					for(Element link: webPages)
					{
						String urlNext = link.attr("href");
						if (urlNext.contains("unt.edu") && !urlNext.contains("mailto:"))
						{
							if(!pagesVisited.contains(urlNext))
							{
								pagesVisited.add(link.attr("abs:href"));
								pagesToVisit.add(link.attr("abs:href"));
								System.out.println(link.attr("abs:href") + ": Queue Size = " + pagesVisited.size());
								if(pagesVisited.size() == MAX_PAGES_TO_SEARCH)
									break;
							}
						}
					}
				}
				System.out.println("Out of For Loop!");
			}
			catch (HttpStatusException e)
			{
				System.out.println("~404 Page not found~");;
			}
		}
	}
}