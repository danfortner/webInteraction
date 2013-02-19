package webInteraction;
import java.util.TreeSet;

//Analyzer is an algorithm to extract data from text
//it removes duplicate words, punctuation, and sorts alphabetically
public class Analyzer{
	
	private String input;
	
	//constructor
	public Analyzer(String aString){
		input=aString;
	}
	
	//returns analysis of the input data, sorts and prints all words without 
	//duplicates or punctuation.  Uses a TreeSet for the efficiency of a tree;
	//add and remove functions are only O(log n)
	public String tagWords(){
		TreeSet<String> wordPile=new TreeSet<String>();
		String[] stringArray;
		String uniqueWord;
		input=input.toLowerCase();
		stringArray=input.split(" ");
		for (int i=0;i<stringArray.length;i++){ 
			if(!wordPile.contains(stringArray[i])){ //remove the duplicates
				uniqueWord=removePunctuation(stringArray[i]); //remove the punctuation
				if (uniqueWord.length()>0) //removes words that were made of punctuation only
					wordPile.add(uniqueWord);
			}
		}
		System.out.println("Unique, non-repeated tag words:");
		return wordPile.toString();
	}

	//takes a single string and removes unwanted punctuation
	public String removePunctuation(String anEntry){
		StringBuffer sb=new StringBuffer();
		for (int i=0;i<anEntry.length();i++){
			if ((anEntry.charAt(i) >= 64 && anEntry.charAt(i) <= 90) 	//UPPERCASE and @
				|| (anEntry.charAt(i) >= 97 &&anEntry.charAt(i) <= 122)	//lowercase
				|| (anEntry.charAt(i) >= 48 &&anEntry.charAt(i) <=57)	//numbers
				|| (anEntry.charAt(i)==95)  || (anEntry.charAt(i)==94)	//_ and ^
				)
			{
				sb = sb.append(anEntry.charAt(i));
			}
		}
		return sb.toString();
	}
	
	//to String method
	public String toString(){
		return input;
	}
	
}//end class