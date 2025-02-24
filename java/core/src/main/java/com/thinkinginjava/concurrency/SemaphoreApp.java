package com.thinkinginjava.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreApp {

	private static final int MAX_PERMITS = 4;
	static Semaphore semaphore = new Semaphore(MAX_PERMITS);
	
	private static class AtmThread extends Thread {
		String name;

		public AtmThread(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			try {
				System.out.println(name + " acquiring lock");
				System.out.println(name + " available permits " + semaphore.availablePermits());
				semaphore.acquire();
				System.out.println(name + " got the permit!");
				
				try {
					for (int i = 1; i <= 5; i++) {
						System.out.println(name + " doing operation " + i);
						Thread.sleep(1000);
					}
				} finally {
					System.out.println(name + " releasing the lock");
					semaphore.release();
					System.out.println(name + " available permits " + semaphore.availablePermits());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Total available pemits " + semaphore.availablePermits());
		
		new AtmThread("A").start();
		new AtmThread("B").start();
		new AtmThread("C").start();
		new AtmThread("D").start();
		new AtmThread("E").start();
		new AtmThread("F").start();
	}
}
