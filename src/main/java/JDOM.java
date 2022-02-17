import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.*;


public class JDOM {

    public static void main(String[] args){
        try{
            //File input = new File("policyList.xml");
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();


            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<?xml version=\"1.0\"?> <example rootAttr=\"rootAttrVal\"><child childAttr1=\"child1attr1Value\" childAttr2=\"child1attr2Value\"><grandChild grandChildatr1=\"grandchild1atr1Value\" grandChildatr2=\"grandchild1atr2Value\">grandChild1TextVal<gg>gg</gg></grandChild><grandChild grandChildatr1=\"grandchildatr1Value\" grandChildatr2=\"grandchild2atr2Value\">grandChild2TextVal<elToFind>elToFindVal</elToFind></grandChild></child> <child2></child2></example>");
            ByteArrayInputStream input = new ByteArrayInputStream(
                    stringBuilder.toString().getBytes("UTF-8"));


            Document doc = builder.parse(input);
            doc.getDocumentElement().normalize(); // removes empty text nodes and combines adjacent text nodes
            Element root = doc.getDocumentElement();
            System.out.println("root node name:" + root.getNodeName());

            NodeList nodeList = root.getChildNodes().item(1).getChildNodes();
            for (int i = 0; i< nodeList.getLength(); i++){
                Node node = nodeList.item(i);

                System.out.println("\nnodePosition:" + i + "  node name:" + node.getNodeName() + "  textNodeValue:"+ node.getTextContent());
                System.out.println("Attributes print:");
                NamedNodeMap attributes = node.getAttributes();
                if( attributes != null) {
                    for (int j = 0; j < attributes.getLength(); j++) {
                        Node atr = attributes.item(j);
                        if (atr != null)
                            System.out.println("attributeName:"+ atr.getNodeName() + " attributeTextValue:" + atr.getTextContent());
                    }
                }
            }

            // task 0 Use your own XML document - paste your XML String in code

            // task 1. Use your own XML document - read your XML String from file in your project directory

            /* task 2 paste an element:
                    <elToFind>Value Found!</elToFind>
               inside your XML file at the nesting(depth) level at least 2
               then find elToFind element in your root tree, do it by assigning
                Element elToFind = YOUR CODE GOES HERE
                and print its text node's value with System.out.println
             */

            // task 3 create a <gg>gg</gg> element at depth level 2


            // task 4 append the <gg2>gg2</gg2> node at depth level2 to be a sibling of the <gg> node


            // task 5 change the position of the <gg2> node to appear before the <gg> node
            // <gg>gg</gg><gg2>gg2</gg2> and we want <gg2>gg2</gg2><gg>gg</gg>


            // task 6 - write the resulting XML into a newly created xml file




        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
