package com.ds;

import javax.xml.ws.Endpoint;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String address = "http://127.0.0.1:9090/ds";
		Endpoint.publish(address, new MyServiceImp());
		
	}

}
