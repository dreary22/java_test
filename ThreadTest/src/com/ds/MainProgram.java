package com.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * ������
 * @author dongshuai
 *
 */
public class MainProgram {

	/**
	 * ������
	 * @param list
	 */
	public void run(List<Parameters> list){
		
		//1.����
		System.out.println("1.����");
		
		//2.�������̵߳��÷��񣬲�����ȡ�����ݽ������
		System.out.println("2.�������̵߳��÷��񣬲�����ȡ�����ݽ������");
		int threadSize = list.size();
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(threadSize);
		
		for(int i = 0;i < list.size();i++){
			Runnable thread = new InvokeWebServiceThread(list.get(i),startGate,endGate);
			Thread t = new Thread(thread);
			t.start();
		}
		
		long startTime = System.nanoTime();
		startGate.countDown();//��ʼ���Ŵ򿪣������߳̿�ʼִ��
		try {
			endGate.await();//�������ŵȴ������߳̽���֮�󣬲�����������
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.�����Ա�
		System.out.println("3.�����Ա�");
		
		long endTime = System.nanoTime();
		System.out.println("�ܺ�ʱ(����):"+(endTime-startTime));
		
	}
	
	public static void main(String[] args) {
		MainProgram mp = new MainProgram();
		List<Parameters> list = new ArrayList<Parameters>();
		Parameters para1 = new Parameters();
		Parameters para2 = new Parameters();
		list.add(para1);
		list.add(para2);
		mp.run(list);
	}
	
}
