package com.ds;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface IMyService {

	@WebResult(name="add")
	public int add(@WebParam(name="a")int a,@WebParam(name="b")int b);
	
	@WebResult(name="minus")
	public int minus(@WebParam(name="a")int a,@WebParam(name="b")int b);
	
	@WebResult(name="Users")
	public List<User> getUsers(@WebParam(name="dept")String dept);
	
	@WebResult(name="addUser")
	public User addUser(@WebParam(name="user")User user);
	
}
