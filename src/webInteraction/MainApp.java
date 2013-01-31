package webInteraction;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args){
		
		CommandLine cli=new CommandLine(1);
		
		System.out.println("\f");
		System.out.println("Welcome to Data Analizer");
		
		switch (cli.selectInput()){
		case 1:
			//case 1 needs to be turned into its own manual input class
			boolean exit=false;
			String tempInput;
			String rawInput="";
			Scanner input=new Scanner(System.in);
			System.out.println("Manual Input\n(or type 'exit' to finish)");
			while (!exit){
				tempInput=input.nextLine();
				if (tempInput.equals("exit")){
					exit=true;
				}
				else{
					rawInput=rawInput+tempInput+" ";
				}
			}
			System.out.println("Raw Input:\n"+rawInput);
			break;
			
		}
	}
}
		
		
//		//CLI for input choice
//		while (selection!=0){
//			System.out.println("Please select which type of input you would like to use:");
//			System.out.println("(or type '0' to exit)");
//					try{
//						selection=input.nextInt();
//	                }
//	                catch (Exception e)
//	                {
//	                    input.nextLine();   
//	                    System.out.println("Please type a number.");
//	                }
//					exit = false;
//					
//					switch (selection){
//					//manual input
//					case 1:
//						String tempInput;
//						System.out.println("Manual Input\n(or type 'exit' to finish)");
//						while (!exit){
//							tempInput=input.nextLine();
//							if (tempInput.equals("exit"))
//								exit=true;
//							else{
//								rawInput=rawInput+tempInput+" ";
//							}
//						}
//						System.out.println("Raw Input:\n"+rawInput);
//						break;
//					case 2:
//						System.out.println("2");
//						break;
//					}
//					//runs the tagWords algorithm if there is an input
//					if (!rawInput.equals("")){
//						results=new Analyze(rawInput);
//						System.out.println("Analysis:\n"+results.tagWords());
//						selection=0;
//					}
//					
//					
//		}
//		System.out.println("Goodbye!");
		
	

//String fileName = "data.txt"; 
//System.out.print("\f");
//String firstItem;
//String lastItem;
//double unit;
//
////read file data.txt and creates a graph from those conversions
////uses a linked list to keep track of units available
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