package com.ds;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class TestServerResource extends ServerResource{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Server(Protocol.HTTP, 8888, TestServerResource.class).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Get
	public String aa(){
		return "hello ... ÖÐÎÄ";
	}

}
