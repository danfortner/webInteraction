package webInteraction.Tests;
import webInteraction.WebCrawler;
import junit.framework.TestCase;

public class WebCrawlerTest extends TestCase{
	
	//before do
	WebCrawler test=new WebCrawler("http://www.engadget.com/");
	
	
	public void testGoogLocalUrl(){
		assertTrue(test.isLocalUrl("engadget.com"));
	}
	
	public void testBadLocalUrl(){
		assertFalse(test.isLocalUrl("yahoo.com"));
	}
	
	public void testFindBaseUrl(){
		assertEquals("engadget", test.findBaseUrl());
	}
	/*
	 * Only one test may be enabled at a time due to too many web site
	 * connections being made simultaneously.
	 */
	
//	public void testConnection(){
//		test.crawl();
//		assertTrue(test.getContent()!=null);
//	}
	
	public void testNumberOfLinks(){
		test.crawl();
		assertEquals(107,test.size());
	}
	
//	public void testLinkDataVisually(){
//		test.crawl();
//		//System.out.println(test.getUrlList());
//	}
	
//	public void testRemovedTags(){
//		test.crawl();
//		String badUrl="javascript:void(0)";
//		assertFalse(test.getUrlList().contains(badUrl));
//	}
	
//	public void testSiteLocallity(){
//		test.crawl();
//		String testUrl="http://www.googleadservices.com";
//		assertFalse(test.getUrlList().contains(testUrl));
//	}
	
	

}//end class