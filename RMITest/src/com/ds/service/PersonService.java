package com.ds.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.ds.module.Person;

public interface PersonService extends Remote {
	public List<Person> queryPersons() throws RemoteException;
}
