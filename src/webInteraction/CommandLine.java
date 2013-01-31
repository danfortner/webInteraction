package webInteraction;

import java.util.Scanner;

public class CommandLine {
	
	private Scanner input=new Scanner(System.in);
	private int numberOfInputSources;
	
	public CommandLine(int anEntry){
		numberOfInputSources=anEntry;
	}
	
	//command line interface for input choice
	//returns the selected data input choice or 0 to cancel
	public int selectInput(){
		int selection=-1;
		while (selection<0||selection>numberOfInputSources){
			System.out.println("Please select which type of data input you would like to use:");
			System.out.println("(or type '0' to exit)");
					try{
						selection=input.nextInt();
						if (selection==0){
							System.out.println("Exiting...");
							return 0;
						}
		            }
		            catch (Exception e)
		            {
		                input.nextLine();   
		                System.out.println("Please type a number.");
		            }		
		}	
		System.out.println("You have selected data input method: "+selection);
		return selection;
	}
}