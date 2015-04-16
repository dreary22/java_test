package com.ds.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.ds.service.PersonService;
import com.ds.service.PersonServiceImpl;

public class Server {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws RemoteException, MalformedURLException {

		PersonService ps = new PersonServiceImpl();
		//×¢²áÍ¨ÐÅ¶Ë¿Ú
		LocateRegistry.createRegistry(7676);
		
		Naming.rebind("rmi://localhost:7676/PersonService", ps);
		
		System.out.println("PersonService start!");
	}

}
