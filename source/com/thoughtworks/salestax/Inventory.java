package com.thoughtworks.salestax;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.thoughtworks.salestax.exception.SalesTaxApplicationException;

/**
 * Inventory
 * 
 * Holds a list of Items available
 * 
 * @author codemaniac
 *
 */
public final class Inventory {
	private Hashtable<String, Item> inventory;

	// initialise
	{
		inventory = new Hashtable<String, Item>();
	}

	/**
	 * Creates inventory from XML file
	 * 
	 * @param inventoryXML
	 * @throws IOException
	 */
	public Inventory(File inventoryXML) throws IOException {
		populateInventoryFromXML(inventoryXML);
	}
	
	/**
	 * Populates inventory with data from XML
	 * 
	 * @param inventoryXML
	 * @throws IOException
	 */
	private void populateInventoryFromXML(File inventoryXML) throws IOException {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document inventoryXMLDoc = dBuilder.parse(inventoryXML);
			inventoryXMLDoc.getDocumentElement().normalize();
			NodeList itemsList = inventoryXMLDoc.getElementsByTagName("item");
			for (int idx = 0; idx < itemsList.getLength(); idx++) {
				Node itemNode = itemsList.item(idx);
				if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
					Element itemElement = (Element) itemNode;
					String itemName = getTagValue("name", itemElement);
					String itemCatagory = getTagValue("catagory", itemElement);			
					String itemType = getTagValue("type", itemElement);
					Item item = new Item(itemName, itemCatagory, itemType);
					inventory.put(itemName, item);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (SalesTaxApplicationException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * Gets contents of a tag 
	 * 
	 * @param tag
	 * @param element
	 * @return tag contents from XML element 
	 */
	private String getTagValue(String tag, Element element) {
		NodeList childrenList = element.getElementsByTagName(tag).item(0)
				.getChildNodes();
		Node node = (Node) childrenList.item(0);
		return node.getNodeValue();
	}

	/**
	 * Searches inventory for Item and returns
	 * 
	 * @param name
	 * @return Item
	 */
	public Item getItem(String name) {
		return inventory.get(name);
	}

}
