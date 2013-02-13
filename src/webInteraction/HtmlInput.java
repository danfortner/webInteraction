package webInteraction;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class HtmlInput {

	private String userUrl;
	private URL websiteUrl;
	private URLConnection websiteConnection;
	
	//Constructor and overloaded constructor
	public HtmlInput(){
	}
		
	public HtmlInput(String anEntry){
		userUrl=anEntry;
	}
	
	//manually set URL through the command line
	public void manuallySetUserUrl(){
		System.out.println("Connect to which web site?");
		Scanner input=new Scanner(System.in);
		userUrl=input.next();
	}
	
	//start the connection and return true if connected
	//return false in unable to connect and throw an exception.
	public boolean connect(){

		try {
		    websiteUrl = new URL(userUrl);
		    websiteConnection = websiteUrl.openConnection();
		    websiteConnection.connect();
		} 
		catch (MalformedURLException e) { 
		    System.out.println("Malformed URL error: "+e);
		    return false;
		} 
		catch (IOException e) {   
			System.out.println("Open connection error: "+e);
		    return false;
		}
		return true;
	}
	
	//retrieves data from the web site and returns it as a string
	//to-do - add scale-ability of this method
	//to-do - possibly add in HTML interpretation
	public String getData(){
		BufferedReader input;
		String data = null;
		try	{
			input=new BufferedReader(new InputStreamReader(websiteConnection.getInputStream()));	
			String inputLine;
			while ((inputLine=input.readLine())!=null){
				data=data+" "+inputLine;
			}
			input.close();
		}
		catch (IOException e) {
			System.out.println("Error retrieving data" + e);
		}
		return data;
	}
	
	//basic getter and setter methods below
	public void setUserUrl(String anEntry){
		userUrl=anEntry;
	}
	
}//end class