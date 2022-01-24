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
            //creo il percorso per il file
            String filePath = "classe.xml";
            File file = new File(filePath);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            //Creo i nodi
            NodeList nList = document.getElementsByTagName("studenti");
            NodeList nList2 = document.getElementsByTagName("aula");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Node nNode2 = nList2.item(temp);
               
                //Stampa del file xml
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Element eElement2 = (Element) nNode2;
                    System.out.println("La classe "+document.getElementsByTagName("classe").item(0).getTextContent()+ document.getElementsByTagName("specializzazione").item(0).getTextContent()+" si trova nell'aula "+eElement2.getElementsByTagName("nome").item(0).getTextContent()+" ed è composta dai seguenti studenti:");
                    for(int i=0; i<document.getElementsByTagName("cognome").getLength();i++){
                    System.out.println( "-"+eElement.getElementsByTagName("cognome").item(i).getTextContent());
                    }
                   
                    
                }
            }
        }
        catch(IOException e) {
            System.out.println(e);
        } 
    }

    }

