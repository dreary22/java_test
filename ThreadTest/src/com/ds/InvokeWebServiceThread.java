package com.ds;

import java.util.concurrent.CountDownLatch;

public class InvokeWebServiceThread implements Runnable {

	private Parameters para;
	
	private CountDownLatch startGate;
	
	private CountDownLatch endGate;
	
	public InvokeWebServiceThread(Parameters para,CountDownLatch startGate,CountDownLatch endGate){
		this.para = para;
		this.startGate = startGate;
		this.endGate = endGate;
	}
	
	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName()+"准备就绪!");
		
		try {
			startGate.await();//等待主线程下命令，开始执行
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2.1通用服务调用
		System.out.println("2.1通用服务调用");
		
		//2.2数据解析入库
		System.out.println("2.2数据解析入库");
		
		//本线程执行完毕
		endGate.countDown();
	}

}
