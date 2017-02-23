package com.chen;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者类
 * @author ChenQiang
 *
 */
public class Consumer implements Runnable {

	private final BlockingQueue<Object> queue;
	private String threadName;

	public Consumer(BlockingQueue<Object> queue) {
		this.queue = queue;
	}

	public Consumer(BlockingQueue<Object> queue, String threadName) {
		this.queue = queue;
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(threadName + "消费：苹果" + queue.take());
				count ++;
				Thread.sleep(2 * 1000L);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(threadName + "共消费苹果" + count);
	}
}