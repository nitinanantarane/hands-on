package com.nitin.quickstart.core.java.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchApp {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(4);
		
		new Worker(latch, 1000L, "Worker-1").start();
		new Worker(latch, 2000L, "Worker-2").start();
		new Worker(latch, 3000L, "Worker-3").start();
		new Worker(latch, 4000L, "Worker-4").start();
		
		latch.await();
		
		System.out.println(Thread.currentThread().getName() + " has finished");
	}
	
}

class Worker extends Thread {
	
	CountDownLatch latch;
	long delay;
	
	public Worker(CountDownLatch latch, long delay, String name) {
		super(name);
		this.delay = delay;
		this.latch = latch;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		latch.countDown();
		System.out.println(getName() + " has finished");
	}
}
