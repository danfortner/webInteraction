package webInteraction.Tests;
import java.util.TreeSet;

import webInteraction.Analyzer;
import junit.framework.TestCase;

public class AnalyzerTest extends TestCase{

	public void testConstructor(){
		Analyzer algorithm = new Analyzer("hello world");
		assertEquals("hello world", algorithm.toString());
	}
	
	public void testTagWordsSorting(){
		Analyzer algorithm = new Analyzer("world hello");
		TreeSet<String> answer=new TreeSet<String>();
		answer.add("hello"); answer.add("world"); 
		assertEquals(answer.toString(), algorithm.tagWords());
	}
	
	public void testTagWordsPunctuationRemoval(){
		Analyzer algorithm = new Analyzer("johnny!!!! &*()+mel:on");
		TreeSet<String> answer=new TreeSet<String>();
		answer.add("johnny"); answer.add("melon"); 
		assertEquals(answer.toString(), algorithm.tagWords());
	}
	
	public void testTagWordsGoodPunctuation(){
		Analyzer algorithm = new Analyzer("laugh@dan ::welcome_home //i^2");
		TreeSet<String> answer=new TreeSet<String>();
		answer.add("laugh@dan"); answer.add("welcome_home"); 
		answer.add("i^2"); 
		assertEquals(answer.toString(), algorithm.tagWords());
	}
	
	public void testTagWordsToLowercase(){
		Analyzer algorithm = new Analyzer("HELLO EVERYBODY");
		TreeSet<String> answer=new TreeSet<String>();
		answer.add("hello"); answer.add("everybody"); 
		assertEquals(answer.toString(), algorithm.tagWords());
	}
	
	public void testTagWordsNumbers(){
		Analyzer algorithm = new Analyzer("123 456");
		TreeSet<String> answer=new TreeSet<String>();
		answer.add("123"); answer.add("456"); 
		assertEquals(answer.toString(), algorithm.tagWords());
	}	
	
	public void testTagWordsRemoveEntirePunctuation(){
		Analyzer algorithm = new Analyzer("hello <<>?//:");
		TreeSet<String> answer=new TreeSet<String>();
		answer.add("hello"); 
		assertEquals(answer.toString(), algorithm.tagWords());
	}
	
	public void testTagWordsRemoveDuplicateWords(){
		Analyzer algorithm = new Analyzer("and and and the the the");
		TreeSet<String> answer=new TreeSet<String>();
		answer.add("and"); answer.add("the"); 
		assertEquals(answer.toString(), algorithm.tagWords());
	}

}//end class