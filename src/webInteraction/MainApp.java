package webInteraction;

import java.net.MalformedURLException;
import java.net.URL;

import org.xml.sax.SAXException;

//MainApp calls for a command line interface to select an input source
//and then runs the Analyzer algorithm on the data and returns the results
public class MainApp {
	public static void main(String[] args) throws SAXException, MalformedURLException{
		
		CommandLine cli=new CommandLine();
		String rawData="";
		Analyzer results;
		
		//introduction screen
		System.out.println("\f");
		System.out.println("Welcome to Data Analizer");
		
		//add input methods to the CLI
		cli.addInput("Manual Entry");
		cli.addInput("Via Web Site");
		cli.addInput("Image Finder");
		
		//find which input method the user would like to use
		int userChoice = cli.selectInput();
		switch (userChoice){
		
		case 0://Manual Entry
			ManualInput manual=new ManualInput();
			rawData=manual.getData();
			break;
		
		case 1://Via Web Site
			HtmlInput web = new HtmlInput();
			web.manuallySetUserUrl();
			web.connect();
			rawData=web.getData();
			break;
			
		case 2://Image Finder
			ImageFinder finder = new ImageFinder();
			finder.printInformation();
			cli.output("What is the location of the image to be found?");
			String input=cli.getInput();
			finder.setTargetImage(new URL (input));
			cli.output("What is the web site to be searched?");
			input=cli.getInput();
			finder.openWebSite(new URL(input));
			finder.findImage();
			finder.showFoundImage(5);
			
		case 999:
			System.out.println("You did not select an input method!");
			break;
		}
		//run the Analyzer algorithm on the data and return results
		results= new Analyzer(rawData);
		if(userChoice!=2)//if it is not Image Finder
			System.out.println(results.tagWords());
		
	}//end main
}//end class