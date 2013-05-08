package webInteraction;

import java.util.TreeSet;
import org.jsoup.Jsoup;

public class WebCrawler {
	
	private String userUrl;
	private TreeSet <String> urlList;
	private final int MAXBUFFER = 200;
	private String baseUrl;
	
	public WebCrawler(String urlEntry){
		userUrl=urlEntry;
		urlList=new TreeSet<String>();
		baseUrl=findBaseUrl();
	}
	
	public TreeSet <String> getUrlList(){
		return urlList;
	}
	
	public int size(){
		return urlList.size();
	}
	
	public String getContent(){
		return getContent(userUrl);
	}
	
	private String getContent(String urlEntry){
		HtmlInput web = new HtmlInput(urlEntry);
		web.connect();
		return web.getData();
	}
	
	public void crawl(){
		TreeSet<String> toBeCrawled=new TreeSet<String>();
		//initially fill the to-do list using the base url
		toBeCrawled.addAll(findNewLinks(getContent(userUrl)));
		//continue making a pile of new links & crawling them
		while (toBeCrawled.size()!=0){
			String element=toBeCrawled.first();
			toBeCrawled.addAll(findNewLinks(element));
			urlList.add(element);
			toBeCrawled.remove(element);
			if (toBeCrawled.size()>MAXBUFFER){
				break;
			}
		}//end while
	}//end crawl
	
	private TreeSet <String> findNewLinks(String content){
		TreeSet <String> newLinks = new TreeSet<String>();
		org.jsoup.nodes.Document document = Jsoup.parse(content);
		//for every piece of the document, search for links
		for (org.jsoup.nodes.Element element: document.getElementsByTag("a")){
			//if it is a local Url && is unique - add to the list
			if (isLocalUrl(element.attr("href"))&&!urlList.contains(element.attr("href"))){
				newLinks.add(element.attr("href"));
				System.out.println(element.attr("href"));
			}
		}
		return newLinks;
	}
	
	//finds the base for the domain name
	public String findBaseUrl(){
		String urlBase=userUrl;
		int firstDot, secondDot = 0;
		int slashPosition=0;
		firstDot=urlBase.indexOf('.');
		if(firstDot<12){//contains 'www'
			//System.out.println(firstDot+" "+urlBase+" "+secondDot);
			secondDot=urlBase.indexOf(".", 12);
			urlBase=(String) urlBase.subSequence(firstDot+1, secondDot);
		} else { //does not contain 'www'
			slashPosition=urlBase.indexOf('/');
			urlBase=(String) urlBase.subSequence(slashPosition+2, firstDot);
		}
		return urlBase;
	}
	
	public Boolean isLocalUrl(String urlEntry){
		return urlEntry.contains(baseUrl);
	}
	
	
}//end class