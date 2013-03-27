package webInteraction;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.sikuli.api.*;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import static org.sikuli.api.API.*;

public class ImageFinder {
	
	public static void main(String[] args) throws MalformedURLException {
		
		ScreenRegion defaultRegion = new DesktopScreenRegion();
		browse(new URL("https://code.google.com/p/sikuli-api/wiki/BasicUsage"));
		Target toFind = new ImageTarget(new URL("https://dl.dropbox.com/u/5104407/SikuliAPIWikiImages/pictures_icon.png"));
		
		ScreenRegion targetLocation = defaultRegion.find(toFind);
		System.out.println(targetLocation.getBounds());

		Canvas canvas = new DesktopCanvas();
		canvas.addLabel(targetLocation, "Right here");
		canvas.addBox(targetLocation);
		canvas.display(3);
		
		
	}//end main

}//end class