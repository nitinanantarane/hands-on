package com.thinkinginjava.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConstructThreadApp {
    public static void main( String[] args ) throws InterruptedException, ExecutionException {
        
        new Thread() {
        	public void run() {
        		System.out.println(Thread.currentThread());
        	};
        }.start();
        
        new Thread(new Runnable() {
        	public void run() {
        		System.out.println(Thread.currentThread());
        	}
        }).start();
        
        Callable<Integer> callableTask = new Callable<Integer>() {

			public Integer call() throws Exception {
				Random random = new Random();
				return random.nextInt(50);
			}
		};
		
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> callResult = executorService.submit(callableTask);
        executorService.shutdown();
        
        System.out.println("Call Result => " + callResult.get());
        
        System.out.println("Exiting..." + Thread.currentThread());        
    }
    
    class Task implements Runnable {
    	public void run() {
    		// TODO Auto-generated method stub
    		
    	}
    }
}
