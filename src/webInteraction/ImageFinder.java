package webInteraction;

import java.net.URL;
import org.sikuli.api.*;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;
import static org.sikuli.api.API.*;

public class ImageFinder {
	
	private Target targetToFind;
	private URL userURL;
	private ScreenRegion defaultScreen;
	private ScreenRegion foundImage;
	
	public ImageFinder(){
		defaultScreen=new DesktopScreenRegion();
	}
	
	//launch a browser window on the default monitor & browser
	public boolean openWebSite(URL aUrlEntry){
		browse(aUrlEntry);
		return aUrlEntry instanceof URL;
	}
	
	//set the URL to be searched
	public boolean setURL(URL aUrlEntry){
		userURL=aUrlEntry;
		return userURL instanceof URL;
	}
	
	//set the image you are searching for
	public Target setTargetImage(URL targetImage){
		targetToFind=new ImageTarget(targetImage);
		return targetToFind;
	}
	
	//execute the image search
	public ScreenRegion findImage(){
		foundImage = defaultScreen.find(targetToFind);
		return foundImage;
	}
	
	//graphically display any found image
	public void showFoundImage(int numberSeconds){
		Canvas canvas = new DesktopCanvas();
		canvas.addBox(foundImage);
		canvas.addLabel(foundImage, "Found Image");
		canvas.display(numberSeconds);
	}
	
	//output X,Y information about the screen position
	public void printInformation(){
		System.out.println(defaultScreen.getBounds());
	}
	
	public ScreenRegion getDefaultScreen(){
		return defaultScreen;
	}
	
	public Target getTarget(){
		return targetToFind;
	}

}//end class