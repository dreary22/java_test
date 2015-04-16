package com.ds.thread;

public class ThreadDemo implements Runnable {

	private String id;
	
	public ThreadDemo(String id){
		this.id = id;
	}
	
	@Override
	public void run() {
		int i = 0;
		while(i<1000){
			System.out.println("线程id"+this.id+",线程名:"+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
