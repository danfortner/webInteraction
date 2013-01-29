package webInteraction;

public class Analyze {
	
	private String input;
	
	public Analyze(String aString){
		input=aString;
	}
	
	public String tagWords(){
		return "Algorithm"+" "+input;
	}
	
}
