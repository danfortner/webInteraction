package webInteraction;

public class WebChanger {
	public static void main(String[] args){
		
		String hardCodeUrl ="http://www.postimage.org";
		String hardCodePath="C:\\Users\\Admin\\Desktop\\Testy\\new.html";
		
		System.out.println("Starting...");
		
		HtmlInput web=new HtmlInput(hardCodeUrl);
		web.connect();
		String content=web.getData()+"\n<script src=\"changer.js\"></script>";
		SaveString save=new SaveString(hardCodePath, content);
		System.out.println(save.save());
		
	}//end main
}//end class