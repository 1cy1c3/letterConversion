package com.letter.xml;

import com.letter.form.Letter;

import java.io.File;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Controller for XSL-FO operations
 *
 * @author Rune Krauss
 */
public class XML {
	final static String basePath = "";
	
	/**
	 * Timestamp for creating file name of the pdf document
	 */
	String timestamp = "";
	
	/**
	 * Constructor to create the XML object
	 *
	 * @param String
	 *           timestamp Timestamp for creating file name of the pdf document
	 */
	public XML(String timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * Method to create XML for the letter
	 *
	 * @param Letter
	 *            bl Object regarding form fields
	 */
	public void createXML(Letter bl) {
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root element
			Document doc = docBuilder.newDocument();
			Element root = doc.createElement("letters");
			doc.appendChild(root);

			// letter elements
			Element letter = doc.createElement("letter");
			root.appendChild(letter);
			// set attribute to letter element
			Attr attr = doc.createAttribute("id");
			attr.setValue("1");
			letter.setAttributeNode(attr);

			// sender element
			Element sender = doc.createElement("sender");
			letter.appendChild(sender);
			// senderSurname element
			Element senderSurname = doc.createElement("surname");
			senderSurname
					.appendChild(doc.createTextNode(bl.getSenderSurname()));
			sender.appendChild(senderSurname);
			// senderName element
			Element senderName = doc.createElement("name");
			senderName.appendChild(doc.createTextNode(bl.getSenderName()));
			sender.appendChild(senderName);
			// senderStreet element
			Element senderStreet = doc.createElement("street");
			senderStreet.appendChild(doc.createTextNode(bl.getSenderStreet()));
			sender.appendChild(senderStreet);
			// senderNr element
			Element senderNr = doc.createElement("nr");
			senderNr.appendChild(doc.createTextNode(bl.getSenderNr()));
			sender.appendChild(senderNr);
			// senderPlz element
			Element senderPlz = doc.createElement("plz");
			senderPlz.appendChild(doc.createTextNode(bl.getSenderPLZ()));
			sender.appendChild(senderPlz);
			// senderPlace element
			Element senderPlace = doc.createElement("place");
			senderPlace.appendChild(doc.createTextNode(bl.getSenderPlace()));
			sender.appendChild(senderPlace);
			// senderPlace element
			Element phone = doc.createElement("phone");
			phone.appendChild(doc.createTextNode(bl.getSenderPhone()));
			sender.appendChild(phone);
			// senderPlace element
			Element email = doc.createElement("email");
			email.appendChild(doc.createTextNode(bl.getSenderEmail()));
			sender.appendChild(email);

			// recipient element
			Element recipient = doc.createElement("recipient");
			letter.appendChild(recipient);
			// recipientSurname element
			Element recipientSurname = doc.createElement("surname");
			recipientSurname.appendChild(doc.createTextNode(bl
					.getRecipientSurname()));
			recipient.appendChild(recipientSurname);
			// recipientName element
			Element recipientName = doc.createElement("name");
			recipientName
					.appendChild(doc.createTextNode(bl.getRecipientName()));
			recipient.appendChild(recipientName);
			// recipientStreet element
			Element recipientStreet = doc.createElement("street");
			recipientStreet.appendChild(doc.createTextNode(bl
					.getRecipientStreet()));
			recipient.appendChild(recipientStreet);
			// recipientNr element
			Element recipientNr = doc.createElement("nr");
			recipientNr.appendChild(doc.createTextNode(bl.getRecipientNr()));
			recipient.appendChild(recipientNr);
			// recipientPlz element
			Element recipientPlz = doc.createElement("plz");
			recipientPlz.appendChild(doc.createTextNode(bl.getRecipientPLZ()));
			recipient.appendChild(recipientPlz);
			// recipientPlace element
			Element recipientPlace = doc.createElement("place");
			recipientPlace.appendChild(doc.createTextNode(bl
					.getRecipientPlace()));
			recipient.appendChild(recipientPlace);

			// date element
			Element date = doc.createElement("date");
			date.appendChild(doc.createTextNode(bl.getDate()));
			letter.appendChild(date);

			// reference element
			Element reference = doc.createElement("reference");
			reference.appendChild(doc.createTextNode(bl.getReference()));
			letter.appendChild(reference);

			// regard element
			Element regard = doc.createElement("regard");
			regard.appendChild(doc.createTextNode(bl.getRegard()));
			letter.appendChild(regard);

			// salutation element
			Element salutation = doc.createElement("salutation");
			salutation.appendChild(doc.createTextNode(bl.getSalutation()));
			letter.appendChild(salutation);

			// text element
			Element text = doc.createElement("text");
			text.appendChild(doc.createTextNode(bl.getText()));
			letter.appendChild(text);

			// greeting element
			Element greeting = doc.createElement("greeting");
			greeting.appendChild(doc.createTextNode(bl.getGreeting()));
			letter.appendChild(greeting);

			// facilities element
			Element facilities = doc.createElement("facilities");
			facilities.appendChild(doc.createTextNode(bl.getFacilities()));
			letter.appendChild(facilities);

			// Add stylesheet
			// Node pi = doc.createProcessingInstruction("xml-stylesheet",
			// "type=\"text/xsl\" href=\"letter.xsl\"");
			// doc.insertBefore(pi, root);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(basePath + "xml/" + timestamp + "-letter.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

	/**
	 * Method to create PDF for the letter
	 */
	public void createPDF() {
		try {
			System.out.println("Preparing...");

			// Setup directories
			//File baseDir = new File(".");
			//File outDir = new File(baseDir, "out");
			//outDir.mkdirs();

			// Setup input and output files
			File xmlfile = new File(basePath + "xml/" + timestamp + "-letter.xml");
			File xsltfile = new File(basePath + "xsl/" + "letter.xsl");
			File pdffile = new File(basePath + "pdf/" + timestamp + "-letter.pdf");

			System.out.println("Input: XML (" + xmlfile + ")");
			System.out.println("Stylesheet: " + xsltfile);
			System.out.println("Output: PDF (" + pdffile + ")");
			System.out.println();
			System.out.println("Transforming...");

			// Configure FOP Factory as desired
			final FopFactory fopFactory = FopFactory.newInstance();

			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			// configure FO UserAgent as desired

			// Setup output
			OutputStream out = new java.io.FileOutputStream(pdffile);
			out = new java.io.BufferedOutputStream(out);

			try {
				// Construct FOP with desired output format
				Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF,
						foUserAgent, out);

				// Setup XSLT
				TransformerFactory factory = TransformerFactory.newInstance();
				Transformer transformer = factory
						.newTransformer(new StreamSource(xsltfile));

				// Set the value of a <param> in the stylesheet
				transformer.setParameter("versionParam", "2.0");

				// Setup input for XSLT transformation
				Source src = new StreamSource(xmlfile);

				// Resulting SAX events (the generated FO) must be piped through
				// to FOP
				Result res = new SAXResult(fop.getDefaultHandler());

				// Start XSLT transformation and FOP processing
				transformer.transform(src, res);
			} finally {
				out.close();
			}

			System.out.println("Success!");
		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
}
