package com.chen;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * 使用BlockingQueue，即阻塞队列来实现生产者消费者问题
 * BlockingQueue自动管理了多线程之间的阻塞与唤醒
 * @author ChenQiang
 *
 */
public class Start {

	public static void main(String[] args) {
		
		BlockingQueue<Object> queue = new LinkedBlockingQueue<>(3);
		
		Thread product = new Thread(new Producer(queue));
		Thread consume = new Thread(new Consumer(queue, "consume"));
		Thread consume2 = new Thread(new Consumer(queue, "consume2"));
		
		product.start();
		consume.start();
		consume2.start();
	}
}