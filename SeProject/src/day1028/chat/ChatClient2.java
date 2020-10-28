//2.
package day1028.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient2 extends JFrame implements KeyListener{
									/* is a 					is a	*/
	//1
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	ChatClient ch;
	
	public ChatClient2(ChatClient ch) {
		this.ch = ch;
		//2.생성
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(15);
		bt = new JButton("send");
		
		//3.패널조립 (패널은 디폴트가 FlowLayout)
		p_south.add(t_input);
		p_south.add(bt);
		
		//4.
		add(scroll);	//센터에 스크롤 부착
		add(p_south, BorderLayout.SOUTH);	//남쪽에 패널부착
		
		//6. 스타일적용
		area.setBackground(Color.GREEN);
		t_input.setBackground(Color.BLUE);
		t_input.setForeground(Color.WHITE);
		bt.setBackground(Color.BLACK);
		bt.setForeground(Color.WHITE);
		
		t_input.setPreferredSize(new Dimension(285,30));
		
		//9. 보여주기 전에 미리 연결해놓자(컴포넌트와 리스너 연결)
		t_input.addKeyListener(this);		//11.내가 리스너다!!! (프레임)
		
		//5. 조립이 다 끝났고, 이젠 윈도우에 보여주기
		//setSize(300,400);
		setBounds(500, 150, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	//7. ChatClient 마우스 위에 놓으면 add 있음 > override 3개가 추가됨 > main 메서드 위로올리기
	@Override		//어노테이션이다... java5 부터 지원되는 일종의 주석.. 
						//일반적인 주석은 프로그램에 관여하지 않지만, 어노테이션은 프로그래밍에서 어떤 표시를 하기 위함이므로 자주 사용됨
	public void keyTyped(KeyEvent e) {
		//엔터키를 누르면, area에 입력데이터를 반영하자 (누적시키자) > 8.MyActionListener 만들기	
	}
	@Override
	public void keyPressed(KeyEvent e) {		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//10. 엔터키를 누르면, area에 입력데이터를 반영하자 (누적시키자)
		int key = e.getKeyCode();	//키코드 값 반환
		//System.out.println(key+" 눌렀어?");
		
		if(key == 10) {	//엔터 치면
			send();
		}
	}
	public void send() {
		//나에대한 처리
		String msg = t_input.getText();	//텍스트필드 값을 구하자!
		area.append(msg+"\n");	//api문서 찾아보기
		t_input.setText("");	//빈텍스트로 초기화
		
		//너에대한 처리
		ch.area.append(msg+"\n");	//api문서 찾아보기
		ch.t_input.setText("");	//빈텍스트로 초기화
	}
	//동생은 main이 필요없다
}
