package com.ds.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import com.ds.module.Person;

public class PersonServiceImpl extends UnicastRemoteObject implements
		PersonService {

	public PersonServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	@Override
	public List<Person> queryPersons() throws RemoteException{
		List<Person> list = new ArrayList<Person>();
		
		Person p1 = new Person();
		p1.setId(11);
		p1.setName("aa");
		p1.setAge(20);
		
		Person p2 = new Person();
		p2.setId(11);
		p2.setName("aa");
		p2.setAge(20);
		
		list.add(p1);
		list.add(p2);
		
		return list;
	}

}
