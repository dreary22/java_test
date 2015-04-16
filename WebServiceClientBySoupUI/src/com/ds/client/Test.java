package com.ds.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.wsdl.BindingOperation;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.soap.SoapMessageBuilder;
import com.eviware.soapui.impl.wsdl.support.wsdl.UrlWsdlLoader;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlContext;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlImporter;
import com.eviware.soapui.model.iface.Operation;
import com.eviware.soapui.support.SoapUIException;

public class Test {

	
	private static List getNode(NodeList childNodes,List list) {
		
		for(int x=0;x<childNodes.getLength();x++){
			Node item = childNodes.item(x);
			if(item.hasChildNodes()){
				getNode(item.getChildNodes(), list);
			}else{
				if("?".equals(item.getTextContent())){
					list.add(item.getParentNode().getNodeName());
				}
			}
		}
		return list;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			String url = "http://127.0.0.1:9090/ab?wsdl";
			UrlWsdlLoader uwl = new UrlWsdlLoader(url);
			WsdlProject project = new WsdlProject();
			WsdlInterface[] importWsdl = WsdlImporter.importWsdl(project, null,
					null, uwl);
			
			
			DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
			DocumentBuilder newDocumentBuilder = dbf.newDocumentBuilder();
			
			
			for(int i=0;i<importWsdl.length;i++){
				List<Operation> operationList = importWsdl[i].getOperationList();
				
				WsdlContext con = importWsdl[i].getDefinitionContext();
				
				//System.out.println(con.getDefinition().get);
				
				
				SoapMessageBuilder soapMsgBuilder = importWsdl[i].getMessageBuilder();
				if(operationList!=null && operationList.size()!=0){
					for(int j=0;j<operationList.size();j++){
						Operation operation = operationList.get(j);
						String servicename=operation.getName();
						System.out.println("方法："+servicename);
						
//						MessagePart[] requestPart = operation.getDefaultRequestParts();
//						if(requestPart[0] instanceof ParameterPart){
//							System.out.println("para");
//						}else if(requestPart[0] instanceof HeaderPart){
//							System.out.println("header");
//							HeaderPart hp = (HeaderPart)requestPart[0];
//							
//							System.out.println(hp.getPartType().name());
//						}
						
						WsdlOperation wsdlOperation = (WsdlOperation)operation;
						BindingOperation b= wsdlOperation.getBindingOperation();
						
						System.out.println(wsdlOperation.getChildren().size());
						
						String buildSoapMessageFromInput = soapMsgBuilder.buildSoapMessageFromInput(b, true);
						
						System.out.println(buildSoapMessageFromInput);
						
						
						Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(buildSoapMessageFromInput.getBytes()));
						Element documentElement = parse.getDocumentElement();
						NodeList childNodes = documentElement.getChildNodes();
						
						List list = new ArrayList();
						getNode(childNodes,list);
						
						System.out.println("输入参数："+list);
						
						System.out.println("======================================================");
						
					}
				}
			}
			
			
			
			
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SoapUIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
