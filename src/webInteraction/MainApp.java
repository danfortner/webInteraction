package webInteraction;

//MainApp calls for a command line interface to select an input source
//and then runs the Analyzer algorithm on the data and returns the results
public class MainApp {
	public static void main(String[] args){
		
		CommandLine cli=new CommandLine();
		String externalData="";
		Analyzer results;
		
		System.out.println("\f");
		System.out.println("Welcome to Data Analizer");
		cli.addInput("Manual Entry");
		
		//find which input method the user would like to use
		switch (cli.selectInput()){
		case 0:
			ManualInput manual=new ManualInput();
			externalData=manual.getData();
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
		
		


////read file data.txt and creates a graph from those conversions
////uses a linked list to keep track of units available
//String fileName = "data.txt"; 
//System.out.print("\f");
//String firstItem;
//String lastItem;
//double unit;
//
//try
//{
//    Scanner data = new Scanner(new File(fileName));
//    while (data.hasNext())
//    {
//        firstItem = data.next().toLowerCase();
//        lastItem = data.next().toLowerCase();
//        unit = data.nextDouble();
//        if(!unitList.contains(firstItem)){
//            graph.addVertex(firstItem);
//            unitList.add(firstItem);
//        }
//        if(!unitList.contains(lastItem)){
//            graph.addVertex(lastItem);
//            unitList.add(lastItem);
//        }
//        graph.addEdge(firstItem,lastItem,unit);
//        System.out.println("Adding conversion: "+firstItem+" "+lastItem+" "+unit);
//    } 
//    data.close(); 
//}
//catch (IOException e)
//{
//    System.out.println("I/O error " + e.getMessage());
//}