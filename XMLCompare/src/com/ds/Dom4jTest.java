package com.ds;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.xml.sax.SAXException;

public class Dom4jTest {

	@Test
	public void test01() {
		// TODO Auto-generated method stub

		try {
			SAXReader reader = new SAXReader();
			URL url = new URL("http://127.0.0.1:9090/ab?wsdl");
			Document doc = reader.read(url);
			//Êä³öxml×Ö·û´®
			//System.out.println(doc.asXML());
			Element root = doc.getRootElement();
			for(Iterator itor = root.elementIterator();itor.hasNext();){
				Element ele = (Element)itor.next();
				System.out.println(ele.getName());
				System.out.println(ele.asXML());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test02(){
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("user");
		for(int i=0;i<10;i++){
			Element ele = root.addElement("dong_"+i);
			ele.addAttribute("name", "ds"+i);
			
		}
		
		System.out.println(doc.asXML());
	}

	@Test
	public void test03(){
		
		org.w3c.dom.Document d;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			d = db.parse(new File(""));
			DOMReader reader = new DOMReader();
			Document doc = reader.read(d);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test04(){
		try {
			SAXReader reader = new SAXReader();
			URL url = new URL("http://127.0.0.1:9090/ab?wsdl");
			Document doc = reader.read(url);
			Element root = doc.getRootElement();
			System.out.println(root.getNamespaceURI());
			System.out.println(root.getNamespacePrefix());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
