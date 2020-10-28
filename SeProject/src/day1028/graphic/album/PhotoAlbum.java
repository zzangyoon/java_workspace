//9
package day1028.graphic.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.PageAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoAlbum extends JFrame implements ActionListener{
																//AlbumPanel 작성 후 
	AlbumPanel p;	//paint 메서드를 재정의하려면, 클래스로 정의해야 한다..(일반 패널 쓰면 안됨)
	
	JPanel p_south;	//버튼 2개를 얹힐 패널
	JButton bt_prev, bt_next;	//이전, 다음 버튼
	

	public PhotoAlbum() {
		//생성
		p = new AlbumPanel();
		p.setBackground(Color.YELLOW);
		p_south = new JPanel();
		bt_prev = new JButton("이전 사진");
		bt_next = new JButton("다음 사진");
		
		//조립
		add(p);	//center에 앨범패널 넣기
		p_south.add(bt_prev);	//패널에 이전버튼 넣기
		p_south.add(bt_next);	//패널에 다음버튼 넣기
		add(p_south, BorderLayout.SOUTH);	//남쪽에 버튼패널 넣기
		

		bt_prev.addActionListener(this);	//이전버튼과 리스너 연결
		bt_next.addActionListener(this);	//다음버튼과 리스너 연결

		
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//젤 마지막
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();	//이벤트를 일으킨 이벤트소스 구하기
		//이벤트소스란? 이벤트를 일으킨 컴포넌트를 의미!

		if(obj == bt_prev) {
			//이전버튼이면 AlbumPanel.n을 감소
			p.n--;
		}else if(obj == bt_next) {
			//다음버튼이면 AlbumPanel.n을 증가
			p.n++;
		}
		//화면 갱신 (직접 AlbumPanel의 paint() 호출 불가)
		//갱신하도록 요청!
		p.repaint();	//다시 그려주세요 update() -> paint()
		
	}
	public static void main(String[] args) {
		new PhotoAlbum();
	}
	
}
