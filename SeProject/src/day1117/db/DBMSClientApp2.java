/*	1
	day1116일차에 구현했던 데이터베이스 클라이언트 프로그램에서 JTable 생성자의 Vector 방식을 이용하면
	동적인 테이블 선택시 유지보수성이 거의 불가능한 수준이므로, 이를 개선해 본다
	즉, 유저가 어떤 테이블을 선택할지 알수 없으므로, 선택한 테이블의 컬럼수, 구성 등을 예측할 수 없는 상황에 대처해본다
*/
package day1117.db;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class DBMSClientApp2 extends JFrame{
	JPanel p_west;	//서쪽영역 패널
	Choice ch_users;	//유저명이 출력될 초이스 컴포넌트
	JPasswordField t_pass;	//비밀번호 텍스트 필드
	JButton bt_login;	//접속 버튼
	
	JPanel p_center;//그리드가 적용될 센터패널
	JPanel p_upper;	//테이블과 시퀀스를 포함할 패널 (그리드 레이아웃 예정)
	JPanel p_middle;	//SQL 편집기가 위치할 미들패널 (BorderLayout)
	JPanel p_footer;	//하단의 그리드(1,2)가 적용될 패널
	JTextArea area;		//쿼리 편집기
	JButton bt_execute;	//쿼리문 실행버튼
	JTable t_tables;	//유저의 테이블 정보를 출력할 JTable
	JTable t_seq;		//유저의 시퀀스 정보를 출력할 JTable
	JTable t_record;	//유저가 선택한 테이블의 레코드를 출력할 JTable
	JTable t_column;//유저가 선택한 테이블의 구조를 출력할 JTable
	
	JScrollPane s1, s2, s3, s4, s5;	//스크롤 4개 준비
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";	//모든 유저가 다 나오게 하려면 system계정을 이용해야함
	String password = "1234";
	Connection con;
	
	//테이블을 출력할 벡터 및 컬럼 (테이블모델로 가지 말고 이차원벡터로... 옛날기술이긴 하지만...)
	Vector tableList = new Vector();	//이 벡터안에는 추후 또다른 벡터가 들어갈 예정임... 즉 이차원배열과 동일함
													//단, 이차원배열보다는 크기가 자유로워서 유연함.. 코딩하기 편함
	Vector<String> tableColumn = new Vector<String>();	//컬럼명은 당연히 String 이므로..
	
	//시퀀스에 필요한 벡터들
	Vector seqList = new Vector();
	Vector<String> seqColumn = new Vector<String>();
	
	//테이블 컬럼정보에 필요한 벡터들
	Vector columnList = new Vector();
	Vector<String> columnType = new Vector<String>();
	
	//TableModel 보유
	MyTableModel model;
	
	public DBMSClientApp2() {
		p_west = new JPanel();
		ch_users = new Choice();
		t_pass = new JPasswordField();
		bt_login = new JButton("접속");
		
		p_center = new JPanel();
		p_upper = new JPanel();
		p_middle = new JPanel();
		p_footer = new JPanel();
		
		area = new JTextArea();
		bt_execute = new JButton("SQL문 실행");
		
		p_center.setLayout(new GridLayout(3,1));	//3층에 1호수
		p_upper.setLayout(new GridLayout(1,2));	//1층에 2호수
		p_middle.setLayout(new BorderLayout());
		p_footer.setLayout(new GridLayout(1,2));	//1층에 2호수
		
		//컬럼정보 초기화하기
		tableColumn.add("table_name");
		tableColumn.add("tablespace_name");
		t_tables = new JTable(tableList, tableColumn);	//여기서 초기벡터값을 넣어주자! 이 시점엔 아직 db연동을 안한 상태이므로 사이즈가 0이지만, 
																			//추후 메서드 호출시 벡터의 크기가 변경될 것이고, JTable을 새로고침하면 된다!
		
		//시퀀스의 생성자에 벡터 적용하기
		seqColumn.add("sequence_name");
		seqColumn.add("last_number");
		t_seq = new JTable(seqList, seqColumn);
		
		columnType.add("컬럼명");
		columnType.add("데이터타입");
		t_column = new JTable(columnList, columnType);
		
		s1 = new JScrollPane(t_tables);
		s2 = new JScrollPane(t_seq);
		s3 = new JScrollPane(area);
		s5 = new JScrollPane(t_column);
		
		//선택한 테이블의 레코드 보여줄 JTable 생성
		t_record = new JTable(null);	//MyTableModel을 대입할 예정
		s4 = new JScrollPane(t_record);
		
		//스타일
		p_west.setPreferredSize(new Dimension(150, 350));
		ch_users.setPreferredSize(new Dimension(145, 30));
		t_pass.setPreferredSize(new Dimension(145, 30));
		bt_login.setPreferredSize(new Dimension(145, 30));
		area.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		//조립
		p_west.add(ch_users);
		p_west.add(t_pass);
		p_west.add(bt_login);
		
		p_upper.add(s1);
		p_upper.add(s2);
		p_middle.add(s3);
		p_middle.add(bt_execute, BorderLayout.SOUTH);
		p_footer.add(s4);
		p_footer.add(s5);
		
		p_center.add(p_upper);	//그리드의 1층
		p_center.add(p_middle);//그리드의 2층
		p_center.add(p_footer);	//그리드의 3층
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		setVisible(true);
		setSize(900, 750);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); > 프로세스만 종료시키고 오라클, 스트림 닫는 처리를 할 기회를 잃어버린다
		//따라서 윈도우 어댑터 구현하여 닫을게 있다면 닫는 처리하자!!!
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disConnect();		//시스템 종료전에 닫을 자원이 있을때 먼저 닫으려고 호출함!
				System.exit(0);
			}
		});
		
		bt_login.addActionListener((e)->{
			login();	//선택한 유저로 로그인 시도하기!
		});
		
		//테이블과 리스너 연결
		t_tables.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				//선택한 좌표의 테이블명 얻기!
				
				int row = t_tables.getSelectedRow();		//선택한 row 구하기
				int col = t_tables.getSelectedColumn();	//선택한 col 구하기
				
				//System.out.println(t_tables.getValueAt(row, col));
				String tableName = (String)t_tables.getValueAt(row, col);
				tableName = tableName.toLowerCase();	//소문자로 변환
				System.out.println(tableName);
				
				//구해진 테이블명을 select()메서드의 인수로 넘기자!
				select(tableName);	
				t_record.updateUI(); 		//jtable 갱신
				//System.out.println("모델의 컬럼 카운트는 "+t_record.getColumnCount());	//null이므로 없애야함
			
			}
		});
		
		bt_execute.addActionListener((e)->{
			select(null);	//테이블명을 넘기지 않음
		});
		
		setLocationRelativeTo(null);
		
		connect();	//호출!
		getUserList();	//유저목록 구해오기
		
		
	}
	
	//오라클에 접속하기
	public void connect() {
		try {
			Class.forName(driver);	//드라이버 로드
			con = DriverManager.getConnection(url, user, password);	//접속시도
			if(con==null) {
				JOptionPane.showMessageDialog(this, user+"계정의 접속에 실패하였습니다");
			}else {
				this.setTitle(user+"계정으로 접속중...");	//프레임 제목에 성공 출력
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//유저목록 가져오기
	public void getUserList() {
		//pstmt와 result는 소모품이므로 매 쿼리문마다 1개씩 대응된다
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select username from dba_users order by username asc";
		
		try {
			pstmt = con.prepareStatement(sql);	//쿼리문 준비하기
			rs = pstmt.executeQuery();	//반환형을 먼저 적으면 이클립스가 알맞는 메서드를 찾아준다
			
			//이제 rs에 들어있는 유저정보를 Choice에 출력하자
			while(rs.next()) {
				ch_users.add(rs.getString("username"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//자원 닫기
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//현재 접속 유저의 테이블목록 가져오기 (현재 접속자 계정으로 로그인성공할때 하면 된다! 즉 접속하자마자 보유한 테이블이 나오게)
	public void getTableList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select table_name, tablespace_name from user_tables";
		
		try {
			pstmt = con.prepareStatement(sql);	//쿼리준비
			rs = pstmt.executeQuery();	//쿼리실행 및 결과집합 받기!
			//평소같았으면, 이차원배열 선언한 후 last(), getRow(), 스크롤옵션 등등 힘들었지만, 벡터를 이용하면 그런게 필요없다
			
			
			
			while(rs.next()) {
				Vector vec = new Vector();	//tableList 벡터에 담겨질 벡터
				vec.add(rs.getString("table_name"));
				vec.add(rs.getString("tablespace_name"));
				
				tableList.add(vec);	//멤버변수 벡터에 벡터를 담았으니, 이제 멤버변수 벡터는 이차원 벡터가 됨
			}
			//완성된 이차원벡터를 JTable에 반영해야 한다. 생성자의 인수로 넣어야함
			//컬럼정보는 어떻게 가져올까? 2개밖에 없으니 고정하자
			//t_tables = new JTable(tableList, columnList);	//여기서 new 하지말고 updateUI()를 하면 된다
			
			t_tables.updateUI();
			
			//테이블의 레코드와 컬럼개수 확인 (여전히 0인지 체크)
			//현재 테이블이 컬럼을 몇개로 인식하고있는지 조사
			System.out.println("컬럼 수는 : "+t_tables.getColumnCount());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//시퀀스 가져오기
	public void getSeqList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select sequence_name, last_number from user_sequences";
		
		try {
			pstmt = con.prepareStatement(sql);	//쿼리준비
			rs = pstmt.executeQuery();	//쿼리실행
			
			//rs의 내용을 벡터로 옮기자! 즉 이차원 벡터로 만들자
			while(rs.next()) {
				Vector vec = new Vector();	//레코드를 담을 벡터준비 (일차원)
				vec.add(rs.getString("sequence_name"));
				vec.add(rs.getString("last_number"));
				seqList.add(vec);	//기존 시퀀스 벡터에 추가해서 이차원벡터로 만들자
			}
			t_seq.updateUI();	//만들어진 벡터를 테이블에 반영한 결과를 업데이트하자
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//유저가 선택한 테이블의 레코드 가져오기
	//이 메서드를 호출하는 자는 select문의 매개변수로 테이블명을 넘겨야 한다!!!
	//매개변수가 넘어오면 테이블명만 사용하고, 안넘어오면 전체 SQL문 대체하자
	public void select(String tableName) {	//매개변수로 테이블명 받자!
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		if(tableName!=null) {	//테이블명을 매개변수로 넘기면 아래의 쿼리문을 사용
			sql = "select * from "+tableName;			
		}else {
			sql=area.getText();
		}
		
		System.out.println(sql);
		
		try {
			pstmt = con.prepareStatement(sql);	//쿼리문 준비
			rs = pstmt.executeQuery();	//쿼리문 실행
			
			/*---------------------------------------------------------
				컬럼정보 만들기 위한 코드
			-----------------------------------------------------------*/
			Vector column = new Vector();	//이 벡터는 새로운 TableModel 객체의 인스턴스가 가진 컬럼벡터에 대입될 예정
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();	//총 컬럼수
			
			System.out.println("당신이 선택한 "+tableName+" 테이블의 컬럼 수는 "+columnCount);
			
			//컬럼 정보 출력
			//출력만 확인하지 말고, MyTableModel이 보유한 컬럼용 벡터에 정보를 채워넣자!
			for(int i=1; i<=columnCount; i++) {
				//System.out.println(meta.getColumnName(i));
				column.add(meta.getColumnName(i));
			}
			//System.out.println("add 한 결과 : " +model.column.size());
			//이 rs를 어디에 담아야 할까? (힌트 : 생성자 벡터 방식이 아닌 TableModel 방식을 이용하고 있다)
			//TableModel인 MyTableModel 이 보유한 벡터에 담으면 된다
			Vector record = new Vector();
			while(rs.next()) {
				Vector vec = new Vector();	//비어있는 일차원 벡터(여기에 레코드 1건이 담겨질 예정)
				
				/*rs도 일종의 배열이므로, index로 컬럼을 접근할 수 있다! 주의 1부터 시작이다
				왜? 만든자가 그렇게 했으니...
				문제점) 1부터 몇까지 컬럼이 존재하는지 알 수가 없다
				그럼 어떻게 알 수 있을까?
				- 이럴땐 테이블에 대한 메타정보를 가져오면 된다
				*/
				//rs.getString(1);	//사실 모두 String 취급해도 된다... 그런데 정말로 정확히 하려면?
				for(int i=1; i<=meta.getColumnCount(); i++) {
					vec.add(rs.getString(i));	//데이터 채우기
				}
				record.add(vec);	//MyTableModel 보유한 벡터에 추가하자~	
			}
			//데이터를 담은 이차원 벡터와, 컬럼을 담은 일차원 벡터를 새로운 모델객체를 생성하면서 전달하자!
			model = new MyTableModel(record, column);	//이차원 레코드벡터, 일차원 컬럼벡터
			t_record.setModel(model);	//테이블에 모델을 생성자가 아닌, 메서드로 적용하자!
			
			getColumnType(meta);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
	
	//유저가 선택한 테이블의 구조 정보 가져오기
	public void getColumnType(ResultSetMetaData meta) {
		try {
			int total = meta.getColumnCount();	//총 컬럼수
			
			//멤버변수로 선언된 벡터에 버튼을 누를때마다 계속 누적이 되므로,
			//아래의 for문이 수행되기 전에 먼저 비워놓고 채우자!
			columnList.removeAll(columnList);
			for(int i=1; i<=total; i++) {
				System.out.println("컬럼명 "+meta.getColumnName(i)+"("+meta.getColumnTypeName(i)+")");
				Vector vec = new Vector();
				vec.add(meta.getColumnName(i));
				vec.add(meta.getColumnTypeName(i));
				columnList.add(vec);
			}
			t_column.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//로그인
	public void login() {
		//현재 유지되고 있는 접속 객체인 Connection을 끊고, 다른 유저로 접속을 시도한다!
		disConnect();	//접속끊기
		user = ch_users.getSelectedItem();	//현재 초이스컴포넌트에 선택된 아이템값!
		password = new String(t_pass.getPassword());	//비밀번호 설정
		connect();		//접속하기 (하지만 멤버변수가 현재 .system으로 되어 있으므로 멤버변수를 초이스 값으로 교체해야 한다) 
		
		getTableList();	//바로 이 시점에 로그인하자마자, 이 사람의 테이블정보를 보여준다!
		getSeqList();
		
		System.out.println("보유한 테이블"+tableList.size());
		t_tables.updateUI();
	}
	
	//오라클에 접속끊기
	public void disConnect() {
		if(con!=null) {	//아직 con이 선언된게 없으니 선언하자
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new DBMSClientApp2();
	}
}
