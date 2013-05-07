package com.GS.Utility;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XmlFileUtil {
	//static final Logger logger = Logger.getLogger(XmlFileUtil.class);

	private static Document getDocument(File xmlfile) throws ParserConfigurationException, SAXException, IOException {
		//logger.debug("Creating an Object of the Document");
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(xmlfile);
		return doc;
	}

	private static Node getNodeObject(String xpathString, Document doc) throws XPathExpressionException {
		// Create a xptah object
		//logger.debug("Getting the node by using xpath " + xpathString);
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xpath = xpf.newXPath();
		XPathExpression expr = xpath.compile(xpathString);
		Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
		//logger.debug("Returning the Node object from xml file");
		return node;
	}

	private static void wirteXmlFile(Document doc, File file) throws TransformerException {
		// Write the content into xml file
		//logger.debug("Changes are done in xml file, Writing to the XML file");
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(file);
		transformer.transform(source, result);
	}

	// Method to ad d a Node in to the Xml. for Ex.
	// <systemUser password="sys123" username="system"/>
	// <Admin username="system"/>

	public static void addNewNode(File xmlfile, String nodeXpath, String elementName, String attributeName, String attributeValue) throws Exception {
		// Get the Document object.
		//logger.debug("Add node method, adding a new node in xml file " + xmlfile.toString());
		Document doc = getDocument(xmlfile);
		// get the Node Object for the xpath.
		Node node = getNodeObject(nodeXpath, doc);

		// Create a New Element
		Element element = doc.createElement(elementName);
		// Set the Attributes in to the Element
		element.setAttribute(attributeName, attributeValue);
		// Append The Element as a child in side the Parent Node
		node.appendChild(element);

		wirteXmlFile(doc, xmlfile);
		//logger.debug("New node is added to the xml file");
	}

	// Method to update the value of the Attribute based on the attribute
	// Name.For Ex.
	// <systemUser password="sys123" username="system"/>
	public static void updateAttribute(File xmlfile, String nodeXpath, String attributeName, String attributeValue) throws Exception {
		//logger.debug("update an attribute value in the xml file " + xmlfile.toString());
		// get the Document object.
		Document doc = getDocument(xmlfile);
		// get the Node Object for the xpath.
		Node node = getNodeObject(nodeXpath, doc);

		Element element = (Element) node;

		// set the attribute value for the particular attribute Name
		element.setAttribute(attributeName, attributeValue);

		wirteXmlFile(doc, xmlfile);
		//logger.debug("attribute value changed successfully in xml file " + xmlfile.toString());
	}

	// To get the Attribute Value for the Particular xpath Attribute. For Ex.
	// <systemUser password="sys123" username="system"/>
	public static String getAttributeValue(File xmlfile, String nodeXpath, String attributeName) throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		//logger.debug("Getting the attribute value from the xml file" + xmlfile.toString());
		// get the Document object.
		Document doc = getDocument(xmlfile);

		// get the Node Object for the xpath.
		Node node = getNodeObject(nodeXpath, doc);

		NamedNodeMap attr = node.getAttributes();
		// Get the Attribute Value returned as a String
		String attributeValue = attr.getNamedItem(attributeName).getNodeValue();
		//logger.debug("Attribute name " + attributeName + " and the value is " + attributeValue);
		//logger.debug("Returning attribute value as " + attributeValue);
		return attributeValue;
	}

	// To get the Text value of the Node.For Ex.
	// <applicationName>inaut02wl03</applicationName>
	public static String getNodeTextValue(File xmlfile, String nodeXpath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		//logger.debug("Getting the Text value of the node");

		// get the Document object.
		Document doc = getDocument(xmlfile);

		// get the Node Object for the xpath.
		Node node = getNodeObject(nodeXpath, doc);

		// Get the Attribute Value returned as a String
		String NodeTextValue = node.getTextContent();
		//logger.debug("Node name " + nodeXpath + " and the text contains is " + NodeTextValue);
		//logger.debug("Returning the node text value as " + NodeTextValue);

		return NodeTextValue;
	}
     
	// To Set the Text value of the Node.For Ex.
	// <applicationName>inaut02wl03</applicationName>
	public static void setNodeTextValue(File xmlfile, String nodeXpath,String textValue) throws Exception {
		//logger.debug("Setting the Text value of the node");

		// get the Document object.
		Document doc = getDocument(xmlfile);

		// get the Node Object for the xpath.
		Node node = getNodeObject(nodeXpath, doc);

		// Get the Attribute Value returned as a String
		node.setTextContent(textValue);
		//logger.debug("Node name " + nodeXpath + " and the text to Set is " + textValue);
		wirteXmlFile(doc, xmlfile);
		//logger.debug("Node value changed successfully in xml file " + xmlfile.toString());
	}

	/**
	 * method to check whether the NOde name with the XPATh is present or not.
	 * return true if node is present, or false
	 * 
	 * @param xmlfile
	 * @param nodeXpath
	 * @return
	 * @throws Exception
	 */
	public static Boolean checkNodeIsPresentOrNot(File xmlfile, String nodeXpath) throws Exception {
		boolean nodename = false;
		//logger.info("Checking whether Node is present or not in XML");
		//logger.debug("Checking Node with xpath in XML " + nodeXpath);
		// get the Document object.
		try {
			Document doc = getDocument(xmlfile);
			// get the Node Object for the xpath.
			Node node = getNodeObject(nodeXpath, doc);
			node.getNodeName().toString();
			//logger.info(nodeXpath + " is present in the xml file");
			nodename = true;
		} catch (NullPointerException t) {
			//logger.info("Returning FALSE as Node is not present in Xml file");
			nodename = false;
		}
		//logger.info("Returning True as NOde is present in Xml file");

		return nodename;
	}
}
