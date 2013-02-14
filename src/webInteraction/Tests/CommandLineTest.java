package webInteraction.Tests;
import webInteraction.CommandLine;
import junit.framework.TestCase;

public class CommandLineTest extends TestCase{

	public void testAddInputSource(){
		CommandLine cli=new CommandLine();
		assertEquals(true,cli.addInput("Manual Input"));
	}
	
}//end class	