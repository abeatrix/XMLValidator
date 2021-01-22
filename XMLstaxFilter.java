import java.io.FileInputStream;
import java.io.File;
import javax.xml.stream.*;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.*;
import javax.xml.XMLConstants;

public class XMLstaxFilter{
    public static void main (String args[]) throws Exception {

        XMLStreamReader xmlFile = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream("consumer.xml"));

        SchemaFactory sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sFactory.newSchema(new File("consumer2.xsd"));

        Validator validator = schema.newValidator();
        validator.validate(new StAXSource(xmlFile));

    }
}
