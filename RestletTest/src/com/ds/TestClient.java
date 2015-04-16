package com.ds;

import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			new ClientResource("http://www.baidu.com").get().write(System.out);
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
