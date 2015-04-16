package com.ds;

import java.util.Iterator;
import java.util.Vector;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t = new Thread(){
			public void run(){
				System.out.println("aa");
			}
		};
		t.start();
		
	}

}
