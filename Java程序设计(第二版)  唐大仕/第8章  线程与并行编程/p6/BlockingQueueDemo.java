package p6;

import java.util.concurrent.*;

class Producer implements Runnable {
	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i <= 10; ++i) {
			try {
				Thread.sleep((int) (Math.random() * 10));
				queue.put(i); // 产生
				System.out.print("生产" + i + ".");
			} catch (InterruptedException ex) {
			}
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i <= 10; ++i) {
			try {
				Thread.sleep((int) (Math.random() * 10));
				Integer product = queue.take(); // 消费
				System.out.print("消费" + product + ".");
			} catch (InterruptedException ex) {
			}
		}
	}
}

public class BlockingQueueDemo {
	public static void main(String[] args) {
		BlockingQueue queue = new ArrayBlockingQueue<Integer>(1); // 容量为1
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}
}