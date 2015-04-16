package com.ds;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(endpointInterface="com.ds.IMyService")
public class TestService123 implements IMyService {

	@Override
	public int add(int a, int b) {
		System.out.println("testservice123:add");
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		System.out.println("testservice123:minus");
		return 0;
	}

	@Override
	public List<User> getUsers(String dept) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "addUser")
	public User addUser(@WebParam(name = "user") User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
