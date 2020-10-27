/* 3.
 멀티라인 주석 : ctrl + shift + /(슬래시)
 멀티라인 해제 : ctrl + shift + \(역슬래시)
 싱글라인 주석 : ctrl + /(슬래시)
 싱글라인 해제 : ctrl + \(역슬래시)
 
AWT는 플랫폼에 따라 디자인이 다르게 표현되는 문제가 있기에, AWT를 개선한 API인 Swing을 사용해본다
Swing은 새롭게 배울 필요가 없으며, 기존 우리가 사용해오던 AWT컴포넌트에 대부분 J 접두어가 붙는다
주의)	AWT가 완전히 불필요한 패키지가 아니다
		awt 패키지의 event와 배치관리자는 여전히 AWT를 이용한다
*/
package day1027.gui;

import java.awt.Checkbox;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class SwingTest extends JFrame{
	JCheckBox ch;
	JButton bt;
	
	public SwingTest() {
		ch = new JCheckBox("영화");
		bt = new JButton("나버튼");
		setLayout(new FlowLayout());
		add(ch);
		add(bt);
		
		setVisible(true);
		setSize(300, 400);
		
		//swing의 프레임은 닫기버튼을 누르면, 화면에서 안보이게 되는데,
		//이때 프로그램이 종료된 것이 아니라 단지 setVisible() 메서드가 false로 전환된 것이다
		//따라서 완전히 프로그램을 종료시키려면 콘솔 종료버튼을 누르던가, 아래의 코드를 작성하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//윈도우창 닫으면 프로세스도 함꼐 종료시킴
	}
	public static void main(String[] args) {
		new SwingTest();
	}
}
