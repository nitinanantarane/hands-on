package com.nitin.quickstart.core.java.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockApp {
	
	private static class Resource {
		public void doSomething() {
			System.out.println(Thread.currentThread().getName() + " => DB operation finished");
		}
		
		public void doSomethingElse() {
			System.out.println(Thread.currentThread().getName() + " => Logging operation finished");
		}
	}
	
	private static class Task implements Runnable {
		Resource resource;
		ReentrantLock lock = new ReentrantLock();

		public Task(Resource resource) {
			this.resource = resource;
		}

		public void run() {
			try {
				lock.tryLock();
				if (lock.isHeldByCurrentThread()) {
					System.out.println(Thread.currentThread().getName() + " acquired lock");
					resource.doSomething();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (lock.isHeldByCurrentThread()) {
					lock.unlock();
					System.out.println(Thread.currentThread().getName() + " release lock");
				}
			}
			
			resource.doSomethingElse();
		}
		
	}

	public static void main(String[] args) {
		Resource resource = new Resource();
		Task task = new Task(resource);
		for (int i = 0; i < 2; i++) {
			new Thread(task).start();
		}
	}

}
