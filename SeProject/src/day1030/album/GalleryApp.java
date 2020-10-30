//1
package day1030.album;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class GalleryApp extends JFrame implements ActionListener{

	JPanel p_west;
	JPanel p_center;
	JScrollPane scroll;
	JLabel la_name;	//제목 나올 라벨
	XCanvas can;	//센터에 크게 나올 이미지를 그릴 캔버스
	JPanel p_south;
	JButton bt_prev, bt_next;
	
	//1. 기본 조립까지 마치고, 2)thumb정의한 후 다시오기
	ArrayList<Thumb> list = new ArrayList<Thumb>();	//썸네일 배열선언 [][][][][][][][][][]
	String dir = "C:/workspace/java_workspace/SeProject/res/travel2/";
	String[] src = {		
			"aa.jpg", "ab.jpg", "ax.jpg", "bm.jpg", "et.jpg", "kg.jpg", "mx.jpg", "pk.jpg", "ub.jpg", "ya.jpg"	
	};
	
	int n=0;	//배열의 index
	
	
	public GalleryApp() {
		super("자바 갤러리");	//윈도우 이름
		
		//생성
		p_west = new JPanel();
		p_center = new JPanel();
		scroll = new JScrollPane(p_west);	//스크롤이 west를 잡아먹은 것
		la_name = new JLabel(src[n], SwingConstants.CENTER);	//가운데정렬
		can = new XCanvas(dir+src[n]);
		p_south = new JPanel();
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");

		
		//2. 썸네일 생성
		for(int i=0; i<src.length; i++) {
			Thumb thumb = null;
			list.add(thumb = new Thumb(dir+src[i], this));	//this = galleryApp @-5
			p_west.add(thumb);
		}
		
		//스타일
		
		la_name.setPreferredSize(new Dimension(700,50));
		la_name.setBackground(Color.BLUE);
		la_name.setFont(new Font("Verdana", Font.BOLD, 25));
		
		p_west.setPreferredSize(new Dimension(100,600));
		p_center.setPreferredSize(new Dimension(700,600));
		//p_west.setBackground(Color.YELLOW);
		//p_center.setBackground(Color.PINK);
		
		//조립
		p_south.add(bt_prev);
		p_south.add(bt_next);
		p_center.add(la_name);
		p_center.add(can);
		p_center.add(p_south);
		
		add(scroll, BorderLayout.WEST);	//스크롤이 west를 잡아먹었으므로 scroll을 프레임에 붙여야함
		add(p_center);
		
		bt_prev.addActionListener(this);		//버튼과 리스너 연결!
		bt_next.addActionListener(this);		//버튼과 리스너 연결!
		
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);	//윈도우를 화면 중앙에 띄우는 법
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		updateData();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();	//이벤트 일으킨 컴포넌트
		if(obj == bt_prev) {
			prev();
		}else if(obj == bt_next) {
			next();
		}
		updateData();
	}
	
	public void updateData() {	//prev, next 코드중복은 따로 빼준다!
		//그림은 XCanvas가 담당하므로, 그려질 img를 변경시켜주고, 다시 그리라고 하면 됨...
		can.setSrc(dir+src[n]);
		can.repaint();	//update() --> paint();
		//제목 변경
		la_name.setText(src[n]+" ("+(n+1)+"/"+src.length+")");	//이름변경
	}
	
	
	public void prev() {
		if(n>=1) {
			n--;
		}else {
			JOptionPane.showMessageDialog(this, "첫번째 이미지입니다");
		}
	}
	
	public void next() {		
		if(n<src.length-1) {
			//배열을 넘어서지 않는 범위내에서 ++허용
			n++;
		}else {
			//넘어서면 욕!
			JOptionPane.showMessageDialog(this, "마지막 이미지입니다");
		}
	}
	
	public static void main(String[] args) {
		new GalleryApp();
	}
}
