package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import org.w3c.dom.Document;

public class TestSoapXml {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String urlStr = "http://127.0.0.1:9090/ab?wsdl";
			String nameSpace = "http://ds.com/";
			String serviceName = "11";
			String portName = "22";
			String localPart = "getUsers";
			String inputParaName = "dept";
			String inputParaVal = "123";
			String prefix = "aa";

			URL url = new URL(urlStr);

			QName n = new QName(nameSpace, serviceName);

			Service service = Service.create(url, n);

			SOAPMessage msg = MessageFactory.newInstance().createMessage();

			SOAPBody body = msg.getSOAPPart().getEnvelope().getBody();

			//QName qn = new QName(nameSpace, localPart, prefix);
			QName qn = new QName(nameSpace, localPart);

			// body.addBodyElement(qn).setValue("11111");
			body.addBodyElement(qn).addChildElement(inputParaName)
					.setValue(inputParaVal);

			System.out.println("发送的soap:");
			msg.writeTo(System.out);

			QName pn = new QName(nameSpace, portName);

			Dispatch<SOAPMessage> dis = service.createDispatch(pn,
					SOAPMessage.class, Service.Mode.MESSAGE);

			SOAPMessage responseMsg = dis.invoke(msg);

			System.out.println();
			System.out.println("接收的soap:");
			responseMsg.writeTo(System.out);

			// 解析响应消息
			Document doc = responseMsg.getSOAPPart().getEnvelope().getBody()
					.extractContentAsDocument();
			System.out.println();
			System.out.println("解析响应消息");
			System.out.println(doc.getElementsByTagName("Users").item(0)
					.getTextContent());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
