import java.io.FileInputStream;
import java.io.InputStream;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileWriter;
import javax.xml.stream.*;

public class XMLReader{

	public static void main(String xmlFilePath) throws Exception {
        //input
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream xmlFile = new FileInputStream(xmlFilePath);
        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(xmlFile);

        //output
        BufferedWriter printer = new BufferedWriter( new FileWriter("./output.xml", true)); // set true to append

        while (streamReader.hasNext()) {
            if (streamReader.isStartElement()) {
                if (streamReader.getLocalName().equals("consumer")){
                    printer.write("Description:");
                    printer.newLine();
                }
                switch (streamReader.getLocalName()) {
                case "bankAccount": {
                    streamReader.nextTag(); // Advance to "accountNumber" element
                    String acctNum = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "amount" element
                    String amount = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "description" element
                    streamReader.nextTag(); // Advance to "accountType" element
                    String type = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "lenderName" element
                    String lender = (String) streamReader.getElementText();
                    String output = "bankAccount : bankAccountType: "+type+",bankName: "+lender+", amount: "+ amount;
                    printer.write(output);
                    printer.newLine();
                    break;
                }
                case "creditCardAccount": {
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
                    String output = "creditCardNumber: "+cardNumber+",expirationDate: "+date+", Issuer: "+ issuer+", amount: "+amount;
                    printer.write(output);
                    printer.newLine();
                    break;
                }
                case "mortgageAccount": {
                    streamReader.nextTag(); // Advance to "accountNumber" element
                    String acctNum = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "amount" element
                    String amount = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "description" element
                    streamReader.nextTag(); // Advance to "accountType" element
                    String type = (String) streamReader.getElementText();
                    streamReader.nextTag(); // Advance to "lenderName" element
                    String lender = (String) streamReader.getElementText();
                    String output = streamReader.getLocalName()+": "+lender+", accountType: "+type+", amount: "+ amount;
                    printer.write(output);
                    printer.newLine();
                    break;
                }
                }
            }
            streamReader.next();
        }
        printer.flush();
        printer.close();
    }
}
