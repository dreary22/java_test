package com.ds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ds.thread.ThreadDemo;

public class APP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ExecutorService pool = Executors.newFixedThreadPool(10);
		for(int i = 0;i < 10;i++){
			ThreadDemo td = new ThreadDemo(i+"");
			pool.execute(td);
		}
		
	}

}
