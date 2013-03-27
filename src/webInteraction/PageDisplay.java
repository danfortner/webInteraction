//package webInteraction;
//
//import java.io.IOException;
//
//import org.fit.cssbox.css.*;
//import org.fit.cssbox.io.DOMSource;
//import org.fit.cssbox.io.DefaultDOMSource;
//import org.fit.cssbox.io.DefaultDocumentSource;
//import org.fit.cssbox.io.DocumentSource;
//import org.fit.cssbox.layout.BrowserCanvas;
//import org.w3c.dom.Document;
//import org.xml.sax.SAXException;
//import java.net.*;
//import java.util.Scanner;
//
//public class PageDisplay extends javax.swing.JFrame{
//
//	private static final long serialVersionUID = 1L;
//	private DOMAnalyzer input;
//	private String userUrl;
//
//	public PageDisplay(){
//	}
//	
//	public boolean setup(String urlString) throws SAXException{
//		userUrl = urlString;
//		try {
//			DocumentSource docSource=new DefaultDocumentSource(userUrl);	//start network connection
//			DOMSource parser=new DefaultDOMSource(docSource);				//parse document
//			Document doc=parser.parse();									
//			input = new DOMAnalyzer(doc, docSource.getURL());			//start DOM tree
//			input.attributesToStyles();										//converts HTML to CSS
//			input.addStyleSheet(null, CSSNorm.stdStyleSheet(), DOMAnalyzer.Origin.AGENT);	//add stylesheets
//			input.addStyleSheet(null, CSSNorm.userStyleSheet(), DOMAnalyzer.Origin.AGENT);	//add additional CSS
//			input.getStyleSheets();											//load styles
//		} catch (IOException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
//	
//	public boolean showLayout(){
//		try {
//			URL urlEntry=new URL(userUrl);
//			BrowserCanvas browser = new BrowserCanvas(input.getRoot(), input, new java.awt.Dimension(1000,600), urlEntry);
//			browser.createLayout(new java.awt.Dimension(1000,600));
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
//	
//
//}
