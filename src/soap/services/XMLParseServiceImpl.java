package soap.services;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParseServiceImpl {

	public int runValid() {
 		try {
 			// Get path to XML file
 			Path currentRelativePath = Paths.get("");
 			String path = currentRelativePath.toAbsolutePath().toString() + "\\data\\Valid.xml";
 			System.out.println(path);
 			File inputFile = new File(path);
 			
 			// Create a document builder
 			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 			
 			// Parsing XML file
 			Document doc = dBuilder.parse(inputFile);
 			
 			// Test XML file
 			return testXML(doc);
 		}
 		catch (Exception e) { // Catch exceptions
 			e.printStackTrace();
 			return 0;
	      	}
     }
	
	public int runInvalidCommand() {
 		try {
 			// Get path to XML file
 			Path currentRelativePath = Paths.get("");
 			String path = currentRelativePath.toAbsolutePath().toString() + "\\data\\InvalidCommand.xml";
 			System.out.println(path);
 			File inputFile = new File(path);
 			
 			// Create a document builder
 			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 			
 			// Parsing XML file
 			Document doc = dBuilder.parse(inputFile);
 			
 			// Test XML file
 			return testXML(doc);
 		}
 		catch (Exception e) { // Catch exceptions
 			e.printStackTrace();
 			return -1;
	      	}
     }
	
	public int runInvalidSiteID() {
 		try {
 			// Get path to XML file
 			Path currentRelativePath = Paths.get("");
 			String path = currentRelativePath.toAbsolutePath().toString() + "\\data\\InvalidSiteID.xml";
 			System.out.println(path);
 			File inputFile = new File(path);
 			
 			// Create a document builder
 			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 			
 			// Parsing XML file
 			Document doc = dBuilder.parse(inputFile);
 			
			// Test XML file
 			return testXML(doc);
 		}
 		catch (Exception e) { // Catch exceptions
 			e.printStackTrace();
 			return -2;
	      	}
     }
	
	public int testXML(Document doc) {
		// Create list of Declaration and SiteID node elements
		NodeList Declaration = doc.getElementsByTagName("Declaration");
		NodeList SiteID = doc.getElementsByTagName("SiteID");
		
		// Get node 0 info. Only one node for each element
		Node nNode1 = Declaration.item(0);
		Node nNode2 = SiteID.item(0);
		
        // Create elements for each node
		Element eElement1 = (Element) nNode1;
        Element eElement2 = (Element) nNode2;
        
        // Store values as string
        String Command = eElement1.getAttribute("Command");
        String SiteIDValue = eElement2.getTextContent();
        
        // Validate XML file and return appropriate response
        if (! Command.equals("DEFAULT")) {
        	return -1;
        }
        else if (! SiteIDValue.equals("DUB")) {
        	return -2;
        }
        else {
        	return 0;
        }
	}
}
