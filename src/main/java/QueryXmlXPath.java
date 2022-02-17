
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QueryXmlXPath {

    public static void main(String... args) throws JDOMException, IOException {

        // parse and load file into memory
        InputStream in = QueryXmlXPath.class.getResourceAsStream("/example.xml");
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(in);

        // create xpath factory
        XPathFactory xpath = XPathFactory.instance();

        System.out.println("1. select all elements");
        XPathExpression<Element> expr = xpath.compile("//course/name", Filters.element());
        List<Element> courses = expr.evaluate(document);
        for (Element course : courses) {
            System.out.println("   " + course.getValue().trim());
        }

        System.out.println("\n2. select all id attributes of elements");
        XPathExpression<Attribute> attrExpr = xpath.compile("//course/@id", Filters.attribute());
        List<Attribute> ids = attrExpr.evaluate(document);
        for (Attribute id : ids) {
            System.out.println("   " + id.getValue());
        }

        System.out.println("\n3. select the second element");
        expr = xpath.compile("//course[2]/name", Filters.element());
        Element name = expr.evaluateFirst(document);
        System.out.println("   " + name.getValue());

        System.out.println("\n4. select element by xpath with attribute");
        expr = xpath.compile("//course[@id='1']/name", Filters.element());
        Element child = expr.evaluateFirst(document);
        System.out.println("   " + child.getValue());

        /* task 0
            add a few courses to the example.xml input file and select the courses with a price greater than 10
            and print their names
         */

        /* task 2
            print all course element names with price =0.0 or an attribute named id="3"
        */

        /* Optional homework
            query your own XML document and train XPath
        */

    }
}