package com.ds;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(endpointInterface="com.ds.IMyService",serviceName="serviceName11",portName="portName22")
public class MyServiceImp implements IMyService {

	private List<User> list = new ArrayList<User>();
	
	public MyServiceImp(){
		list.add(new User("����","26","��","�з�һ��"));
		list.add(new User("����","36","��","�з�һ��"));
		list.add(new User("С��","24","Ů","������"));
	}
	
	@Override
	public int add(int a, int b) {
		System.out.println("a+b="+(a+b));
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		System.out.println("a-b="+(a-b));
		return a-b;
	}

	@Override
	public List<User> getUsers(String dept) {
		return list;
	}

	@Override
	@WebResult(name = "addUser")
	public User addUser(@WebParam(name = "user") User user) {
		list.add(user);
		return user;
	}

}
