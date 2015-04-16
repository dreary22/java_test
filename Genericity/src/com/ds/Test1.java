package com.ds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Object> list = new ArrayList<Object>();
		printCollection1(list);
		
		printCollection2(list);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("22");
		printCollection2(list2);
		
	}
	
	public static void printCollection1(Collection c){
		Iterator itor = c.iterator();
		while(itor.hasNext()){
			System.out.println(itor.next());
		}
	}
	
	/**
	 * Í¨Åä·û
	 * @param c
	 */
	public static void printCollection2(Collection<?> c){
		
		for(Object o:c){
			System.out.println(o);
		}
		
	}
	
	public static void printttt(Collection c){
		Iterator itor = c.iterator();
		while(itor.hasNext()){
			System.out.println(itor.next());
		}
		
	}

}
