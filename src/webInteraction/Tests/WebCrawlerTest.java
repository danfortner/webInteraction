package webInteraction.Tests;
import webInteraction.WebCrawler;
import junit.framework.TestCase;

public class WebCrawlerTest extends TestCase{
	
	//before do
	WebCrawler test=new WebCrawler("http://www.postimage.org");
	
	/*
	 * Only one test may be enabled at a time due to too many web site
	 * connections being made simultaneously.
	 */
	
	//test web site connection
//	public void testConnection(){
//		test.crawl();
//		assertTrue(test.getContent()!=null);
//	}
	
//	public void testNumberOfLinks(){
//		test.crawl();
//		assertEquals(67,test.size());
//	}
	
//	public void testLinkDataVisually(){
//		test.crawl();
//		//System.out.println(test.getUrlList());
//	}
	
	public void testRemovedTags(){
	test.crawl();
	String badUrl="javascript:void(0)";
	assertFalse(test.getUrlList().contains(badUrl));
}
	
//	public void testSiteLocallity(){
//		test.crawl();
//		String testUrl="http://www.googleadservices.com";
//		assertFalse(test.getUrlList().contains(testUrl));
//	}

}//end class