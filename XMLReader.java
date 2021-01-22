import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.stream.*;

public class XMLReader{

	public static void main(String argv[]) throws Exception {
        //
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream xmlFile = new FileInputStream("./consumer.xml");

        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(xmlFile);

        System.out.println("Description:");
        while (streamReader.hasNext()) {
            if (streamReader.isStartElement()) {
                switch (streamReader.getLocalName()) {
                case "bankAccount": {
                    System.out.print(streamReader.getLocalName()+": ");
                    streamReader.nextTag(); // Advance to "accountNumber" element
                    String acctNum = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "amount" element
                    String amount = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "description" element
                    streamReader.nextTag(); // Advance to "accountType" element
                    String type = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "lenderName" element
                    String lender = (String) streamReader.getElementText();
                    System.out.println("bankAccount : bankAccountType: "+type+",bankName: "+lender+", amount: "+ amount);
                    break;
                }
                case "creditCardAccount": {
                    System.out.print(streamReader.getLocalName()+": ");
                    streamReader.nextTag(); // Advance to "accountNumber" element
                    String acctNum = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "amount" element
                    String amount = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "description" element
                    streamReader.nextTag(); // Advance to "accountType" element
                    String type = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "creditCardNumber" element
                    String cardNumber = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "expirationDate" element
                    String date = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "issuer" element
                    String issuer = (String) streamReader.getElementText();
                    System.out.println("creditCardNumber: "+cardNumber+",expirationDate: "+date+", Issuer: "+ issuer+", amount: "+amount);
                    break;
                }
                case "mortgageAccount": {
                    System.out.print(streamReader.getLocalName()+": ");
                    streamReader.nextTag(); // Advance to "accountNumber" element
                    String acctNum = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "amount" element
                    String amount = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "description" element
                    streamReader.nextTag(); // Advance to "accountType" element
                    String type = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "lenderName" element
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
