//3
package day1116.pubapi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MTMain extends JFrame{
	//서쪽영역
	JPanel p_west;
	JTextField t_name;
	JTextField t_op1;
	JTextField t_op2;
	JTextField t_op3;
	JButton bt;
	
	//센터영역
	Vector data = new Vector();	//이차원 벡터가 될 예정~
	//제너릭타입으로 알맞는 자료형이 뭘까? (우리는 지금 산을 가져와서 테이블에 출력할 예정이다) 그럼 산이 들어와야 한다
	//컬럼 제목 정보를 담는 벡터
	Vector<String> columnName = new Vector<String>();

	JTable table;
	MountainModel model;
	JScrollPane scroll;
	
	/*	JTable에서 데이터 연동시 지금까지는 이차원 배열만 써왔는데, 사실 이차원 배열은 생성시 크기를 정해야 하기 때문에 불편하다
	 	(불편한 예 : rs.last() 후 rs.getRow()로 데이터 총 수 구하고, 다시 커서를 원상복귀 시킴)
	 	따라서 컬렉션 프레임웍중 Vector를 지원하는 생성자를 이용해보자
	 	*/
	
	public MTMain() {
		init();	//데이터 채우기!
		
		//생성
		p_west = new JPanel();
		t_name = new JTextField();
		t_op1 = new JTextField();
		t_op2 = new JTextField();
		t_op3 = new JTextField();
		bt = new JButton("검색하기");
		//벡터를 사용할때는 TableModel 자체를 쓸 필요가 없을때 사용하는 건데 둘다 혼합해버렸다.. 테이블 모델이 필요가 없다
		//프로젝트 진행할때는 테이블모델을 쓰는 것이 좋다.. 벡터방식도 있다는 것만 알아두기
		//TableModel에 들어있는 벡터 2개 모두 현재 클래스로 끄집어내야 한다
		
		table = new JTable(data, columnName);	//매개변수로 벡터를 넣자
		scroll = new JScrollPane(table);
		
		//스타일 적용
		p_west.setPreferredSize(new Dimension(200,600));
		p_west.setBackground(Color.WHITE);
		t_name.setPreferredSize(new Dimension(190,30));
		t_op1.setPreferredSize(new Dimension(190,30));
		t_op2.setPreferredSize(new Dimension(190,30));
		t_op3.setPreferredSize(new Dimension(190,30));
		
		//부착
		p_west.add(t_name);
		p_west.add(t_op1);
		p_west.add(t_op2);
		p_west.add(t_op3);
		p_west.add(bt);
		
		add(p_west, BorderLayout.WEST);
		add(scroll);
		
		setVisible(true);
		setSize(900,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	//벡터값을 초기화 하자, 이 메서드를 생성자에서 호출하자
	public void init() {
		/*	데이터 1건 넣어보기
			JTable에 벡터를 매개변수로 넣는 방식은 객체지향적인 요즘 개발방식에 맞지 않음
			이유) 벡터안에 벡터를 넣어야 하므로, 이차원배열 방식과 다를게 없음
			따라서 아래와 같이 벡터안에 또 하나의 벡터를 추가해야 한다!		*/
		Vector v = new Vector();
		v.add("1");
		v.add("설악산");
		v.add("강원도");
		v.add("3000");
		data.add(v);		//벡터안의 벡터! 결국 이차원배열 모습을 그대로 유지함
								//사실 우리가 원했던 것은 Mountain VO를 넣어야 하지만, 벡터를 넣는것을 강제한다... 옛날방식
								//벡터의 제너릭에서 Mountain
		//컬럼정보 채우고
		columnName.add("ID");		//산 아이디
		columnName.add("산이름");	//산이름 
		columnName.add("소재지");	//산 소재지
		columnName.add("높이");	//산 높이
	}
	
	public static void main(String[] args) {
		new MTMain();
	}
}
