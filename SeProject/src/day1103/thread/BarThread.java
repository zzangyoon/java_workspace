//6
package day1103.thread;

import javax.swing.JProgressBar;

public class BarThread extends Thread{
	int n;
	int interval;
	JProgressBar bar;
	
	//이 쓰레드를 이용하고자 하는 자는, 바를 넘기시오~
	public BarThread(JProgressBar bar, int interval) {
		this.bar = bar;
		this.interval = interval;
	}
	
	public void run() {
		while(true) {
			n++;
			bar.setValue(n);
			try {
				Thread.sleep(interval);	//non-runnable에 빠져있다가 0.5초 뒤 복귀하라는 명령
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
