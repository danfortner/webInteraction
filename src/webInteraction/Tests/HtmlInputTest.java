package webInteraction.Tests;
import webInteraction.HtmlInput;
import junit.framework.TestCase;

public class HtmlInputTest extends TestCase{

	public void testGoodConnection(){
		HtmlInput web=new HtmlInput("http://www.google.com");
		assertEquals(true, web.connect());
	}
	
	public void testBadConnection(){
		HtmlInput web=new HtmlInput("http://http://www.badurl7894.com/");
		System.out.println("There should be an open connection error:");
		assertEquals(false, web.connect());
	}
	
	public void testSetUrl(){
		HtmlInput web=new HtmlInput();
		web.setUserUrl("http://www.yahoo.com");
		assertEquals(true, web.connect());
	}
	
	public void testGetDataIsString(){
		HtmlInput web=new HtmlInput("http://www.yahoo.com");
		web.connect();
		assertEquals(true, web.getData() instanceof String);
	}
	
	public void testGetData(){
		HtmlInput web=new HtmlInput("http://www.cafeaulait.org/course/week2/15.html");
		web.connect();
		//-112974033 is the hash code for the "cafeaulait" site
		assertEquals(-112974033, web.getData().hashCode());
		}

}//end class