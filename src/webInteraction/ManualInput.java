package webInteraction;
import java.util.Scanner;

//ManualInput uses the terminal to input whatever data is typed
//and returns the concatenation of that data
public class ManualInput {

	public ManualInput(){
	}
	
	//use a scanner to accumulate whatever the user types in the terminal
	//returns the accumulated result
	public String getData(){
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
		return rawInput;
	}
	
}//end class


//case 1:
//	//case 1 needs to be turned into its own manual input class
//	boolean exit=false;
//	String tempInput;
//	String rawInput="";
//	Scanner input=new Scanner(System.in);
//	System.out.println("Manual Input\n(or type 'exit' to finish)");
//	while (!exit){
//		tempInput=input.nextLine();
//		if (tempInput.equals("exit")){
//			exit=true;
//		}
//		else{
//			rawInput=rawInput+tempInput+" ";
//		}
//	}
//	System.out.println("Raw Input:\n"+rawInput);
//	break;