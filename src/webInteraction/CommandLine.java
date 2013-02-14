package webInteraction;
import java.util.List;
import java.util.Scanner;

//CommandLine executes a text-based command line interface (CLI) in the terminal
//it uses a list to keep track of available input sources
public class CommandLine {
	
	private Scanner input=new Scanner(System.in);
	private List<String> inputSources;
	
	//constructor
	public CommandLine(){
		inputSources= new java.util.LinkedList<String>();
	}
	
	//CLI for input choice, returns the selected data input choice or 999 to cancel
	public int selectInput(){
		int selection=-1;
		//while loop keeps them from selecting a bad input
		while (selection<0||selection>inputSources.size()-1){ 
			System.out.println("Please select which type of data input you would like to use:");
			for (int x=0; x<inputSources.size();x++){
				System.out.println(x+" = "+inputSources.get(x));
			}
			System.out.println("(or type '999' to exit)");
					try{
						selection=input.nextInt();
						if (selection==999){
							System.out.println("Exiting...");
							return 999;
						}
		            }
		            catch (Exception e)
		            {
		                input.nextLine();   
		                System.out.println("Please type a number.");
		            }		
		}	
		System.out.println("You have selected data input method: "+inputSources.get(selection));
		return selection;
	}
	
	//add the input method to the available choices
	//return true if added successfully or false if not added
	public boolean addInput(String anEntry){
		try
		{
			inputSources.add(anEntry);
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
}//end class