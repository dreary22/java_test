package com.ds;

public class BoundedGenericityClass<T extends Number> {

	private T t;
	
	
	
	public T getT() {
		return t;
	}



	public void setT(T t) {
		this.t = t;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BoundedGenericityClass bgc = new BoundedGenericityClass();
		bgc.setT(new Integer(6));
		System.out.println(bgc.getT());
		
	}

}
