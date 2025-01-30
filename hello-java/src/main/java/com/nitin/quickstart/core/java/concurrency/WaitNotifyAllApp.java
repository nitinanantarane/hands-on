package com.nitin.quickstart.core.java.concurrency;

public class WaitNotifyAllApp {

	private static class Message {
		String text;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
		
	}

	private static class WaiterThread extends Thread {
		
		Message message;
		
		public WaiterThread(String name, Message message) {
			super(name);
			this.message = message;
		}
		
		@Override
		public void run() {
			System.out.println(getName() + " wating to get message at " + System.currentTimeMillis());
			
			synchronized(message) {
				try {
					message.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(getName() + " notified at " + System.currentTimeMillis());
				System.out.println(getName() + " processed message " + message.getText() );
			}
		}
	}
	
	private static class NotifierThread extends Thread {
		Message message;
		
		public NotifierThread(String name, Message message) {
			super(name);
			this.message = message;
		}
		
		@Override
		public void run() {
			// notify all after 1 second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized(message) {
				message.setText("Work is finished!");
				message.notifyAll();
			}
		}
	}
	
	public static void main(String[] args) {
		Message message = new Message();
		new WaiterThread("Waiter-1", message).start();
		new WaiterThread("Waiter-2", message).start();
		new NotifierThread("Notifier-1", message).start();
		
		System.out.println("All thread started");
		
	}

}
