package com.ds.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.ds.service.PersonService;

public class Client {

	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		PersonService ps = (PersonService)Naming.lookup("rmi://localhost:7676/PersonService");
		
		System.out.println(ps.queryPersons());
		
	}

}
