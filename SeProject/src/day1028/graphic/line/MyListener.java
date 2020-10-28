//8.
package day1028.graphic.line;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener{
	XCanvas can;	//null
	
	//캔버스의 주소값을 넘겨받을 메서드가 필요하다, 이번에는 생성자로 가자
	public MyListener(XCanvas can) {
		this.can = can;
	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		//LineMaker의 캔버스에 선을 그리되, LineMaker의 JTextField의 값을 이용하여 그리기
		//paint() 메서드는 개발자가 직접 호출할 수도 없고, 호출해서도 안된다!!
		//paint() 메서드는 그림이 그려질 준비가 되었을때, 시스템 즉 .JVM에 의해 호출된다
		//따라서 개발자가 원하는 타임에, 그림을 갱신하게 하려면 paint() 메서드를 직접 호출해서는 안되고
		//갱신할 것을 시스템에 요청! repaint() 다시 그려주세요~ -> update() 화면 지우기 -> paint()
		//캔버스가 보유한.repaint();
		can.repaint();
	}
}
