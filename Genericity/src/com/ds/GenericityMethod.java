package com.ds;

public class GenericityMethod {

	
	public <A>void aa(A t){
		String b = t.getClass().getCanonicalName();
		System.out.println(b);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		GenericityMethod gm = new GenericityMethod();
		gm.aa(new String());
		
	}

}
