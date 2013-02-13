package webInteraction;
import java.util.Iterator;
import java.util.TreeSet;

//Analyzer is an algorithm to extract data from text
public class Analyzer{
	
	private String input;
	
	public Analyzer(String aString){
		input=aString;
	}
	
	//returns analysis of the input data
	//this algorithm is a work in progress, but currently it:
	//sorts and prints all words without duplicates
	public String tagWords(){
		TreeSet<String> wordPile=new TreeSet<String>();
		String[] tempStringArray;
		
		input=input.toLowerCase().trim();
		tempStringArray=input.split(" ");
		for (int i=0;i<tempStringArray.length;i++){
			if(!wordPile.contains(tempStringArray[i])){
				wordPile.add(tempStringArray[i]);
			}
		}
		wordPile=removeAllPunctuation(wordPile);
		return "Unique, non-repeated tag words:"+" "+wordPile;
	}

	//takes an TreeSet and removes all unwanted punctuation
	//for efficiency an iterator is used and add and remove functions
	//in a TreeSet are only O(log n)
	public TreeSet<String> removeAllPunctuation(TreeSet<String> anEntry){
		String cleanWord;
		String originalWord;
		TreeSet<String> cleanWords=new TreeSet<String>(anEntry);
		Iterator<String> wordIterator = anEntry.iterator();
		while (wordIterator.hasNext())
		{
			originalWord=wordIterator.next();
			cleanWord=removePunctuation(originalWord);
			if (!cleanWord.equals(originalWord)){
				cleanWords.remove(originalWord);
				if (cleanWord.length()>0)
					cleanWords.add(cleanWord);
			}
		}
		return cleanWords;
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
	
}//end class