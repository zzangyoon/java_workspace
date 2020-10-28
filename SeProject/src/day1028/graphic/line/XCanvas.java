//6
package day1028.graphic.line;

import java.awt.Canvas;
import java.awt.Graphics;

public class XCanvas extends Canvas{
	//default 접근제한자는 같은 패키지에 존재하는 클래스만이 접근가능함
	LineMaker lineMaker;		//null
	int x1;
	int y1;
	int x2;
	int y2;

	//이 메서드를 호출하는 자는 LineMaker의 주소값을 넘기면 된다
	public void setLineMaker(LineMaker lineMaker) {
		this.lineMaker=lineMaker;
	}
	
	//캔버스는 개발자가 직접 그림을 그릴수 있는 빈 도화지이다!
	//따라서 paint() 메서드를 재정의하면 된다
	public void paint(Graphics g) {
		x1 = Integer.parseInt(lineMaker.t_x1.getText());	//js의 parseInt("2") > 2 정수로
		y1 = Integer.parseInt(lineMaker.t_y1.getText());
		x2 = Integer.parseInt(lineMaker.t_x2.getText());
		y2 = Integer.parseInt(lineMaker.t_y2.getText());
		
		g.drawLine(x1, y1, x2, y2);	//lineMaker.t_x1의값, lineMaker.t_y1의값,lineMaker.t_x2의값,lineMaker.t_y2의값
												//두 점을 연결한 선 그리기!
	}
	
	
}
