package com.ds;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Executor threadPool = Executors.newFixedThreadPool(10);
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("111");
				}

			}

		});
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("222");
				}
			}

		});
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("333");
				}
			}

		});

	}

}
