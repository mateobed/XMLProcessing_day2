import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidation {
    public static void main(String[] args) {
        String xmlPath = "C:\\Users\\Mateusz\\IdeaProjects\\XMLProcessing_day2\\target\\classes\\club.xml";
        String xsdPath = "C:\\Users\\Mateusz\\IdeaProjects\\XMLProcessing_day2\\target\\classes\\club.xsd";
        //System.out.println("EmployeeRequest.xml validates against Employee.xsd? "+validateXMLSchema("Employee.xsd", "EmployeeRequest.xml"));
        //System.out.println("EmployeeResponse.xml validates against Employee.xsd? "+validateXMLSchema("Employee.xsd", "EmployeeResponse.xml"));
        //System.out.println("employee.xml validates against Employee.xsd? "+validateXMLSchema("Employee.xsd", "employee.xml"));
        System.out.println("club.xml validates against club.xsd? "+validateXMLSchema(xsdPath, xmlPath));

    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath){

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }


}
