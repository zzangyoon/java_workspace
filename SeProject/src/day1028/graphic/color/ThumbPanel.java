//12
package day1028.graphic.color;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

//나만의 패널 정의하기
public class ThumbPanel extends JPanel implements MouseListener{
	JPanel p_center;	//null
	Color color;
	
	//너비, 높이, 색상을 가진 패널로 태어나게!
	public ThumbPanel(JPanel p_center, Color color) {
		this.p_center = p_center;
		this.color=color;
		this.setPreferredSize(new Dimension(100, 100));
		this.setBackground(color);
		this.addMouseListener(this);//현재 패널과 리스너와의 연결
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("클릭했어?");
		//액션이벤트가 안먹음 > 마우스로 가자
	}

	
	public void mouseClicked(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("클릭했어?");
		//센터영역패널의 배경색을 나(현재패널)와 같은 색상으로 설정하자!
		p_center.setBackground(color);	
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}



	
}
