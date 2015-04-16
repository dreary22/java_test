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

		System.out.println(Thread.currentThread().getName()+"׼������!");
		
		try {
			startGate.await();//�ȴ����߳��������ʼִ��
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2.1ͨ�÷������
		System.out.println("2.1ͨ�÷������");
		
		//2.2���ݽ������
		System.out.println("2.2���ݽ������");
		
		//���߳�ִ�����
		endGate.countDown();
	}

}
