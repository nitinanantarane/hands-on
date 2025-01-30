package com.nitin.quickstart.core.java.concurrency;

import java.util.concurrent.Semaphore;

public class MutexApp {

	private static final int MAX_PERMITS = 1;
	static Semaphore semaphore = new Semaphore(MAX_PERMITS);
	
	private static class BankLockerThread extends Thread {
		String name;

		public BankLockerThread(String name) {
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
		
		new BankLockerThread("A").start();
		new BankLockerThread("B").start();
		new BankLockerThread("C").start();
		new BankLockerThread("D").start();
		new BankLockerThread("E").start();
		new BankLockerThread("F").start();
	}
}
