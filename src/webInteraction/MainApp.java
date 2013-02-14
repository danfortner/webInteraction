package webInteraction;

//MainApp calls for a command line interface to select an input source
//and then runs the Analyzer algorithm on the data and returns the results
public class MainApp {
	public static void main(String[] args){
		
		CommandLine cli=new CommandLine();
		String externalData="";
		Analyzer results;
		//introduction screen
		System.out.println("\f");
		System.out.println("Welcome to Data Analizer");
		//add input methods to the CLI
		cli.addInput("Manual Entry");
		cli.addInput("Via Web Site");
		
		//find which input method the user would like to use
		switch (cli.selectInput()){
		case 0:
			ManualInput manual=new ManualInput();
			externalData=manual.getData();
			break;
		case 1:
			HtmlInput web=new HtmlInput();
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