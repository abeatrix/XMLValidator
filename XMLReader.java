import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.stream.*;
import javax.xml.xpath.*;

public class XMLReader{

	public static void main(String argv[]) throws Exception {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream in = new FileInputStream("./consumer.xml");

        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(in);
        streamReader.nextTag(); // Advance to "consumer" element
        streamReader.nextTag(); // Advance to "consumerId" element
        streamReader.nextTag(); // Advance to "consumerName" element

        System.out.println("Description:");
        while (streamReader.hasNext()) {
            if (streamReader.isStartElement()) {
                switch (streamReader.getLocalName()) {
                case "bankAccount": {
                    System.out.print(streamReader.getLocalName()+": ");
                    streamReader.nextTag();
                    String acctNum = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    String amount = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    streamReader.nextTag();
                    String type = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    String lender = (String) streamReader.getElementText();
                    System.out.println("bankAccount : bankAccountType: "+type+",bankName: "+lender+", amount: "+ amount);
                    break;
                }
                case "creditCardAccount": {
                    System.out.print(streamReader.getLocalName()+": ");
                    streamReader.nextTag();
                    String acctNum = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    String amount = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    streamReader.nextTag();
                    String type = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    String cardNumber = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    String date = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    String issuer = (String) streamReader.getElementText();
                    System.out.println("creditCardNumber: "+cardNumber+",expirationDate: "+date+", Issuer: "+ issuer+", amount: "+amount);
                    break;
                }
                case "mortgageAccount": {
                    System.out.print(streamReader.getLocalName()+": ");
                    streamReader.nextTag();
                    String acctNum = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    String amount = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    streamReader.nextTag();
                    String type = (String) streamReader.getElementText();
                    streamReader.nextTag();
                    String lender = (String) streamReader.getElementText();
                    System.out.println(streamReader.getLocalName()+": "+lender+", accountType: "+type+", amount: "+ amount);
                    break;
                }
                }
            }
            streamReader.next();
        }
    }
}
