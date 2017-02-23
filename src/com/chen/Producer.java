package com.chen;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者类
 * @author ChenQiang
 *
 */
public class Producer implements Runnable {

	private final BlockingQueue<Object> queue;

	public Producer(BlockingQueue<Object> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				System.out.println("生产出：苹果" + i);
				queue.put(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("生产苹果完成");
	}
}