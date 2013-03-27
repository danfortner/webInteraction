package webInteraction;

import org.xml.sax.SAXException;

//MainApp calls for a command line interface to select an input source
//and then runs the Analyzer algorithm on the data and returns the results
public class MainApp {
	public static void main(String[] args) throws SAXException{
		
		CommandLine cli=new CommandLine();
		String externalData="";
		Analyzer results;
		HtmlInput web = new HtmlInput();
		//introduction screen
		System.out.println("\f");
		System.out.println("Welcome to Data Analizer");
		//add input methods to the CLI
		cli.addInput("Manual Entry");
		cli.addInput("Via Web Site");
		//cli.addInput("Via Web Site Viewer");
		
		//find which input method the user would like to use
		switch (cli.selectInput()){
		case 0:
			ManualInput manual=new ManualInput();
			externalData=manual.getData();
			break;
		case 1:
			web.manuallySetUserUrl();
			web.connect();
			externalData=web.getData();
			break;
		case 999:
			System.out.println("You did not select an input method!");
			break;
		}
		//run the Analyzer algorithm on the data and return results
		results= new Analyzer(externalData);
		System.out.println(results.tagWords());
	}
}//end class


//case 2:
//PageDisplay viewer=new PageDisplay();
//viewer.setup(web.manuallySetUserUrl());
//viewer.showLayout();