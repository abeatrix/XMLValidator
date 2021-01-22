import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class XMLDomReader {

    public static void main(String argv[]) throws Exception {
        try {

            //read xml file
            File xmlFile = new File("./consumer.xml");
            BufferedWriter printer = new BufferedWriter( new FileWriter("./output.xml", true)); // set true to append
            DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
            xmlFactory.setIgnoringElementContentWhitespace(true);
            xmlFactory.setNamespaceAware(true);
            DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();
            Document doc = xmlBuilder.parse(xmlFile);

            //gain access to document nodes
            doc.getDocumentElement().normalize();

            NodeList debts = doc.getElementsByTagName("debts");
            //NodeList bank = ((Element)debts.item(0)).getElementsByTagName("bankAccount");
            NodeList accounts = ((Element)debts.item(0)).getChildNodes();
            printer.write("Description:");
            printer.newLine();
            //loop through a list of debts-accounts
            for( int i = 0; i < accounts.getLength(); i++ ) {
                Node type = accounts.item(i); // get debt account name
                if(type.getNodeType() == Node.ELEMENT_NODE){
                    Element info = (Element) type;
                    String name = info.getNodeName(); // debt account name
                    String amount = info.getElementsByTagName("amount").item(0).getTextContent();
                    NodeList description = info.getElementsByTagName("description");
                    if(name=="creditCardAccount"){
                        Element des = (Element)description.item(0);
                        String creditCardNumber = des.getElementsByTagName("creditCardNumber").item(0).getTextContent();
                        String expirationDate = des.getElementsByTagName("expirationDate").item(0).getTextContent();
                        String issuer = des.getElementsByTagName("issuer").item(0).getTextContent();
                        String output = "\n"+name+": "+"creditCardNumber: "+creditCardNumber+", expirationDate: "+expirationDate+", Issuer: "+issuer+", amount: "+amount;
                        printer.write(output);
                    } else if(name=="bankAccount"){
                        Element des = (Element)description.item(0);
                        String accountType = des.getElementsByTagName("accountType").item(0).getTextContent();
                        String lenderName = des.getElementsByTagName("lenderName").item(0).getTextContent();
                        String output = name+": bankAccountType: "+accountType+", lenderName: "+lenderName+", amount: "+amount;
                        printer.write(output);
                    } else {
                        Element des = (Element)description.item(0);
                        String accountType = des.getElementsByTagName("accountType").item(0).getTextContent();
                        String lenderName = des.getElementsByTagName("lenderName").item(0).getTextContent();
                        String output = name+": lenderName: "+lenderName+", accountType: "+accountType+", amount: "+amount;
                        printer.write(output);
                    }
                }
            }
            printer.flush();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

}
