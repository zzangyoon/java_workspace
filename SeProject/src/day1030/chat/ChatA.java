//4
package day1030.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements KeyListener, ActionListener{
									/* is a 					is a	*/					
	
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	JButton bt_open;			//대화상대방을 띄우는 버튼		
	private ChatB chatB;
	private ChatC chatC;
	
	public ChatA() {
		//나보다 부모가 먼저 태어나야함. super() > JFrame("부모창") : 디폴트로 남기지 말고 정의하자
		super("Chat A");
		//생성
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(10);
		bt = new JButton("send");
		bt_open = new JButton("open");
		
		//패널조립 (패널은 디폴트가 FlowLayout)
		p_south.add(t_input);
		p_south.add(bt);
		p_south.add(bt_open);
		
		//
		add(scroll);	//센터에 스크롤 부착
		add(p_south, BorderLayout.SOUTH);	//남쪽에 패널부착
		
		//
		area.setBackground(Color.YELLOW);
		t_input.setBackground(Color.BLUE);
		t_input.setForeground(Color.WHITE);
		bt.setBackground(Color.BLACK);
		bt.setForeground(Color.WHITE);
		
		t_input.setPreferredSize(new Dimension(100,30));
		
		//보여주기 전에 미리 연결해놓자(컴포넌트와 리스너 연결)
		t_input.addKeyListener(this);		//내가 리스너다!!! (프레임)
		
		//send버튼에 리스너 연결
		bt.addActionListener(this);
		//open버튼에 리스너 연결
		bt_open.addActionListener(this);
		
		//조립이 다 끝났고, 이젠 윈도우에 보여주기
		//setSize(300,400);
		//두 창을 나란히 띄우기 위해 좌표설정
		setBounds(200, 150, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	//ChatClient 마우스 위에 놓으면 add 있음 > override 3개가 추가됨 > main 메서드 위로올리기
	
	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {		
	}
	public void keyReleased(KeyEvent e) {
		//엔터키를 누르면, area에 입력데이터를 반영하자 (누적시키자)
		int key = e.getKeyCode();	//키코드 값 반환

		if(key == 10) {	//엔터 치면
			send();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton btn = (JButton)obj;	//하위 자료형으로 변환 down casting
		
		//조건문...
		if(btn==bt) {	//누른버튼과 send버튼의 주소값이 같다면...
			System.out.println("send 버튼 눌렀어?");
			send();
		}else if(btn.equals(bt_open)) {	//누른버튼과 열기버튼이 같은 버튼이라면...
			System.out.println("open 버튼 눌렀어?");
			open();
		}
	}
	
	//메세지창에 대화내용 누적하기!
	public void send() {
		//나에대한 채팅처리...
		String msg = t_input.getText();	//텍스트필드 값을 구하자!
		area.append(msg+"\n");	//api문서 찾아보기
		t_input.setText("");	//빈텍스트로 초기화
		
		//너에대한 채팅처리
		chatB.area.append(msg+"\n");
		chatC.area.append(msg+"\n");
		
	}
	//대화할 상대방 윈도우 띄우기!
	public void open() {
		//@-1
		chatB = new ChatB();
		chatC = new ChatC();
		
		//ChatB한테 ChatA, ChatC를 넘겨주고
		chatB.setChatA(this);
		chatB.setChatC(chatC);
		
		//ChatC한테 ChatA, ChatB를 넘겨주자
		chatC.setChatA(this);
		chatC.setChatB(chatB);
	}
	

	
	public static void main(String[] args) {
		//new JFrame("부모창");
		new ChatA();
	}
}
