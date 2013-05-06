package webInteraction;

import java.util.Iterator;
import java.util.TreeSet;
import org.jsoup.Jsoup;

public class WebCrawler {
	
	private String userUrl;
	private TreeSet <String> urlList;
	private int size;
	private final int MAXBUFFER = 200;
	
	public WebCrawler(String urlEntry){
		userUrl=urlEntry;
		urlList=new TreeSet<String>();
	}
	
	public TreeSet <String> getUrlList(){
		return urlList;
	}
	
	public int size(){
		return urlList.size();
	}
	
	public void crawl(){
		Boolean end=false;
		int sizeChange;
		parseAllLinks(getContent(userUrl));
		//iterator setup
		TreeSet<String> toCompare=new TreeSet<String>();
		toCompare.addAll(urlList);
		Iterator<String> urlIterator=toCompare.iterator();
		while (!end){
			size=size();
			while (urlIterator.hasNext()){
				String nextPage=getContent(urlIterator.next());
				parseAllLinks(nextPage);
			}//end iterator while
			sizeChange=size();
			if (sizeChange==size||size>MAXBUFFER){
				end=true;
			}
			//reset to check for changes
			toCompare.clear();
			toCompare.addAll(urlList);
			urlIterator=toCompare.iterator();
		}//end if no more changes were found
	}//end crawl

	public String getContent(){
		return getContent(userUrl);
	}
	
	private String getContent(String urlEntry){
		HtmlInput web = new HtmlInput(urlEntry);
		web.connect();
		return web.getData();
	}
	
	private TreeSet <String> parseAllLinks(String content){
		org.jsoup.nodes.Document document = Jsoup.parse(content);
		for (org.jsoup.nodes.Element element: document.getElementsByTag("a")){
			if (isCleanUrl(element.attr("href"))
					&&(!urlList.contains(element.attr("href")))){
				urlList.add(element.attr("href"));
				System.out.println(element.attr("href"));
			}
		}
		return urlList;
	}
	
	private Boolean isCleanUrl(String urlEntry){
		if (urlEntry.startsWith("http://")) return true;
		if (urlEntry.startsWith("http://www.")) return true;
		if (urlEntry.startsWith("https://")) return true;
		if (urlEntry.startsWith("https://www.")) return true;
		return false;
	}	
	
	
}//end class