/* 5.
	진행상황을 직관적으로 알 수 있는 프로그래스바를 활용해보자
*/
package day1103.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class ProgressApp extends JFrame{
	JLabel la;
	JProgressBar bar1, bar2, bar3;
	//Thread barThread;	//바를 증가시킬 쓰레드 (내부익명으로)
	Thread t1, t2, t3;	//바를 증가시킬 쓰레드
	
	public ProgressApp() {
		la = new JLabel("0", SwingConstants.CENTER);
		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
		
		/*
		barThread = new Thread() {
			public void run() {
				while(true) {
					n++;
					setBarValue();
					try {
						Thread.sleep(50);	//non-runnable에 빠져있다가 0.5초 뒤 복귀하라는 명령
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		*/

		
		//스타일
		la.setPreferredSize(new Dimension(500, 180));
		la.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 90));
		//bar.setPreferredSize(new Dimension(500, 50));
		bar1.setPreferredSize(new Dimension(500, 50));
		bar2.setPreferredSize(new Dimension(500, 50));
		bar3.setPreferredSize(new Dimension(500, 50));
	
		setLayout(new FlowLayout());
		
		add(la);
		//add(bar);
		add(bar1);
		add(bar2);
		add(bar3);
		
		//쓰레드 3개 생성하여 runnable로 진입시키자!
		t1 = new BarThread(bar1, 500);
		t2 = new BarThread(bar2, 250);
		t3 = new BarThread(bar3, 10);
		t1.start();
		t2.start();
		t3.start();
		
		
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		//barThread.start();	//모든게 다 로드 후 쓰레드 동작!
	}
	/*
	//바의 값 제어
	public void setBarValue() {
		bar.setValue(n);	//20으로 하면 20퍼센트가 채워짐
	}
	*/
	
	public static void main(String[] args) {
		new ProgressApp();
	}
}
