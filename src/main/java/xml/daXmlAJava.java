package xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class daXmlAJava 
{
    public static void main( String[] args ) throws ParserConfigurationException, SAXException 
    {
        try {
            File file = new File("classe.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            //System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("Studenti");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nElemento Attuale :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //System.out.println("Anno di inizio: " + eElement.getAttribute("Studenti"));
                    System.out.println(eElement.getAttribute("nome")+ eElement.getElementsByTagName("indirizzo").item(0).getTextContent());
                    System.out.println("Nome: " + eElement.getElementsByTagName("nome").item(0).getTextContent());
                    System.out.println("Cognome: " + eElement.getElementsByTagName("cognome").item(0).getTextContent());
                    
                }
            }
        }
        catch(IOException e) {
            System.out.println(e);
        } 
    }

    }

