package p2;

import java.util.*;

public class TimerTest {
	public static void main(String[] args) {
		Timer timer = new Timer("显示 n");
		TimerTask task = new MyTask();
		timer.schedule(task, 1000, 1000);
	}
}

class MyTask extends TimerTask {
	int n = 0;

	public void run() {
		n++;
		System.out.print(new Date());
		System.out.println("---" + n);
	}
}