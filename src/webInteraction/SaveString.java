package webInteraction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
public class SaveString {
 
	private String filePath;
	private String content;
	
	public SaveString(){
	}
	
	public SaveString(String filePath, String content){
		this.filePath=filePath;
		this.content=content;
	}
	
	public Boolean save(){
        FileWriter fileWriter = null;
        try {
            File newTextFile = new File(filePath);
            fileWriter = new FileWriter(newTextFile);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("IO Exception: "+ e);
            return false;
        }
		return true;
	}//end save
	
}//end class