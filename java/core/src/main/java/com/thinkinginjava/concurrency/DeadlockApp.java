package com.thinkinginjava.concurrency;

public class DeadlockApp {

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	private static class ThreadLock1 extends Thread {
		@Override
		public void run() {
			synchronized(lock1) {
				System.out.println("ThreadLock1 acquire lock1");
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("ThreadLock1 trying to acquire lock2");
				synchronized(lock2) {
					System.out.println("ThreadLock1 acquired lock1 and lock2");
				}
			}
		}
	}
	
	private static class ThreadLock2 extends Thread {
		@Override
		public void run() {
			synchronized(lock2) {
				System.out.println("ThreadLock2 acquire lock2");
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("ThreadLock2 trying to acquire lock1");
				synchronized(lock1) {
					System.out.println("ThreadLock2 acquired lock2 and lock1");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadLock1().start();
		new ThreadLock2().start();
	}

}
