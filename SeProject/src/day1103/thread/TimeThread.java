/* 4.
	초를 실시간 출력할 쓰레드
*/
package day1103.thread;

import java.util.Calendar;

public class TimeThread extends Thread{
	
	public void run() {
		//run의 닫는브레이스(})를 만나면 쓰레드가 죽으므로 절대 죽지않게 하기위해 무한루프
		while(true) {
		//현재 시간을 구해서 1초마다 갱신해서 출력!
		Calendar cal = Calendar.getInstance();	//추상클래스이므로 자체 메서드로 인스턴스 얻자!
		
		//년,월,일,시,분,초
		System.out.println(cal.get(Calendar.YEAR)+"년 "
		+(cal.get(Calendar.MONTH)+1)+"월 "+ cal.get(Calendar.DATE)+"일 "
		+cal.get(Calendar.HOUR)+"시 " + cal.get(Calendar.MINUTE)+"분 "
		+cal.get(Calendar.SECOND)+"초");
		try {
			Thread.sleep(1000);	//1/1000초 까지 표현 가능
											//1초동안 non-runnable 상태로 있다가 다시 복귀하라는 명령			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		}
	}
}
