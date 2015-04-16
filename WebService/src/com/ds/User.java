package com.ds;

public class User {

	private String name;
	private String age;
	private String sex;
	private String dept;
	
	public User() {
		super();
	}

	public User(String name,String age,String sex,String dept){
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
