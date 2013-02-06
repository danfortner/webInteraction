package webInteraction;
import java.util.LinkedList;

//Analyzer is an algorithm to extract data from text
public class Analyzer{
	
	private String input;
	
	public Analyzer(String aString){
		input=aString;
	}
	
	//returns analysis of the input data
	//this algorithm is a work in progress, but currently it:
	//prints all words in the data without repeats
	//to-do - remove symbols and punctuation marks
	public String tagWords(){
		LinkedList<String> wordPile=new LinkedList<String>();
		String[] tempStringArray;
		
		input=input.toLowerCase().trim();
		tempStringArray=input.split(" ");
		for (int i=0;i<tempStringArray.length;i++){
			if(!wordPile.contains(tempStringArray[i])){
				wordPile.add(tempStringArray[i]);
			}
		}
		return "Unique, non-repeated words:"+" "+wordPile;
	}
	
}//end class