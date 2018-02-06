import java.util.*;

public class WebLinks {
	String link;
	Integer linkNo;
	static Map<Integer,List<WebLinks>> linksGraph;
	
	//Static block of class
	static
	{
		linksGraph = new HashMap<Integer,List<WebLinks>>();;
		for(int i = 0; i < Crawler.MAX_PAGES_TO_SEARCH; i++)
			linksGraph.put(i, new LinkedList<WebLinks>());
	}
	
	public WebLinks(String link, int linkNo)
	{
		this.link = link;
		this.linkNo = linkNo;
	}
	
	public String getLink()
	{
		return this.link;
	}
	
	public int getLinkNo()
	{
		return this.linkNo;
	}
	
	public void setConnection(WebLinks parentLink, WebLinks childLink)
	{
		List<WebLinks> parent = linksGraph.get(parentLink.getLinkNo());
		parent.add(childLink);
	}
}
