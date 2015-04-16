package com.test;

public class TestThread extends Thread {

	@Override
	public void run() {
		System.out.println("Ïß³Ì£º"+Thread.currentThread().getName());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
