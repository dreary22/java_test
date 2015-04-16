package main;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import test.IMyService;
import test.MyServiceImpService;

public class Test {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {

		URL url = new URL("http://127.0.0.1:9090/ab?wsdl");
		
		QName n = new  QName("http://ds.com/","MyServiceImpService");
		
		MyServiceImpService msis = new MyServiceImpService(url,n);
		
		IMyService ms = msis.getMyServiceImpPort();
		
		ms.add(1, 3);
		
	}

}
