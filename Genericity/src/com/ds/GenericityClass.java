package com.ds;

public class GenericityClass<T> {
	
	private T t;
	

	public GenericityClass(T t){
		this.t = t;
	}
	
	public T getXX(){
		System.out.println("∑∫–Õ¿‡≤‚ ‘");
		return t;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericityClass g = new GenericityClass(new String("aaa"));
		System.out.println(g.getXX().toString());
		
	}

}
