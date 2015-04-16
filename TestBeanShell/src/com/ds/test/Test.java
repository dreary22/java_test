package com.ds.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import bsh.EvalError;
import bsh.Interpreter;

public class Test {

	/**
	 * @param args
	 * @throws EvalError 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws EvalError, FileNotFoundException, IOException {
		Interpreter i = new Interpreter();  // Construct an interpreter
		i.set("foo", 5);                    // Set variables
		i.set("date", new Date() ); 

		Date date = (Date)i.get("date");    // retrieve a variable

		// Eval a statement and get the result
		i.eval("bar = foo*10");             
		System.out.println( i.get("bar") );

		// Source an external script file
		//i.source("somefile.bsh");

	}

}
