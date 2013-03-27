package webInteraction.Tests;

import java.net.MalformedURLException;
import java.net.URL;

import webInteraction.ImageFinder;
import junit.framework.TestCase;

public class ImageFinderTest extends TestCase{
	
	//before do
	ImageFinder finder=new ImageFinder();
	
	//should print screen resolution
	public void testInformation(){
		System.out.println("The screen resolution should be shown:");
		finder.printInformation();
	}
	
	//should open Yahoo.com in a web browser
	public void testOpenWebSite() throws MalformedURLException{
		URL website=new URL("http://www.yahoo.com");
		finder.openWebSite(website);
		System.out.println("A web browser with Yahoo should be open.");
	}
	
	public void testSetGoodURL() throws MalformedURLException{
		URL goodURL = new URL("http://www.google.com");
		assertEquals(finder.setURL(goodURL), true);
	}
	
	public void testShowBox() throws MalformedURLException{
		finder.openWebSite(new URL("https://code.google.com/"));
		finder.setTargetImage(new URL("https://code.google.com/images/gd-logo.png"));
		finder.findImage();
		finder.showFoundImage(4);
	}	

}//end class