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
			if (cleanUrl(element.attr("href"))
					&&(!urlList.contains(element.attr("href")))){
				urlList.add(element.attr("href"));
				System.out.println(element.attr("href"));
			}
		}
		return urlList;
	}
	
	private Boolean cleanUrl(String urlEntry){
		String[] stringRegex = new String[4];
		stringRegex[0]=userUrl.substring(0, 14);
		stringRegex[1]=userUrl.replace("http://", "https://");
		stringRegex[2]=userUrl.replace("http://www.", "http://");
		stringRegex[3]=userUrl.replace("http://www.", "https://");		
		if(urlEntry.startsWith(stringRegex[0])
				||urlEntry.startsWith(stringRegex[1])
				||urlEntry.startsWith(stringRegex[2])
				||urlEntry.startsWith(stringRegex[3])){
			return true;
		}//else
		return false;
	}
	
}//end class