package webInteraction;
import java.util.Scanner;

//ManualInput uses the terminal to input whatever data is typed
//and returns the concatenation of that data
public class ManualInput {

	//constructor
	public ManualInput(){
	}
	
	//use a scanner to accumulate whatever the user types in the terminal
	//returns the accumulated result
	//User can exit by typing 'exit'
	public String getData(){
		boolean exit=false;
		String currentInput;
		String result="";
		Scanner input=new Scanner(System.in);
		System.out.println("Manual Input\n(or type 'exit' to finish)");
		while (!exit){
			currentInput=input.nextLine();
			if (currentInput.equals("exit")){
				exit=true;
			}
			else{
				result=result+currentInput+" ";
			}
		}
		return result;
	}
	
}//end class