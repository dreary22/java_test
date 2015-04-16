package com.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 主程序
 * @author dongshuai
 *
 */
public class MainProgram {

	/**
	 * 主方法
	 * @param list
	 */
	public void run(List<Parameters> list){
		
		//1.建表
		System.out.println("1.建表");
		
		//2.开启多线程调用服务，并将获取的数据解析入库
		System.out.println("2.开启多线程调用服务，并将获取的数据解析入库");
		int threadSize = list.size();
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(threadSize);
		
		for(int i = 0;i < list.size();i++){
			Runnable thread = new InvokeWebServiceThread(list.get(i),startGate,endGate);
			Thread t = new Thread(thread);
			t.start();
		}
		
		long startTime = System.nanoTime();
		startGate.countDown();//开始阀门打开，所有线程开始执行
		try {
			endGate.await();//结束阀门等待所有线程结束之后，才能向下运行
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.解析对比
		System.out.println("3.解析对比");
		
		long endTime = System.nanoTime();
		System.out.println("总耗时(纳秒):"+(endTime-startTime));
		
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
