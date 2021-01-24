import java.io.FileInputStream;
import java.io.File;
import javax.xml.stream.*;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.*;
import javax.xml.XMLConstants;

public class XMLstaxValidator{
    public static void main (String args[]) throws Exception {
        try {

            XMLStreamReader xmlFile = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream("consumer.xml"));

            SchemaFactory sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sFactory.newSchema(new File("consumer.xsd"));

            Validator validator = schema.newValidator();
            validator.validate(new StAXSource(xmlFile));

            //when there is no error it will read and write the XML file
            XMLReader.main(new String[0]);

        } catch (Exception error) {
            error.printStackTrace();
        }

    }
}
