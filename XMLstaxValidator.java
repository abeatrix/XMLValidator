import java.io.FileInputStream;
import java.io.File;
import javax.xml.stream.*;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.*;
import javax.xml.XMLConstants;

public class XMLstaxValidator{
    public static void main (String args[]) throws Exception {
        try {
            // declare XML & XSD file path
            String xmlFilePath = "consumer.xml";
            String singleFileSchema = "consumer.xsd";
            //String batchFileSchema = "consumers.xsd";

            XMLStreamReader xmlFile = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(xmlFilePath));
            SchemaFactory sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sFactory.newSchema(new File(singleFileSchema));

            Validator validator = schema.newValidator();
            validator.validate(new StAXSource(xmlFile));

            //when there is no error it will read and write the XML file
            XMLReader.main(xmlFilePath);

        } catch (Exception error) {
            error.printStackTrace();
        }
        System.out.println("Validation completed. Result printed.");
    }
}
