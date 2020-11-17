//5
package day1117.db;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProductTree extends JFrame{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "user1104";
	String password = "user1104";
	Connection con;
	
	JTree tree;
	JScrollPane scroll;
	
	//배열만 있다면 트리생성은 메서드가 알아서 해주는 코드
	String[] category = {"상의", "하의", "액세서리", "신발"};	//상위카테고리 배열
	String[][] product = {
			{"티셔츠", "점퍼", "니트", "가디건"},
			{"청바지", "반바지", "면바지", "치마"},
			{"귀걸이", "목걸이", "반지", "팔찌"},
			{"구두", "운동화", "스니커즈", "샌들"}
	};
	
	//top, down, accessory, shoes
	ArrayList<String> topCategory = new ArrayList<String>();		//상위카테고리
	ArrayList<ArrayList> subCategory = new ArrayList<ArrayList>();	//하위카테고리
	
	public ProductTree() {
		connect();	//접속
		
		//DB연동하여 배열들의 데이터를 실제 DB데이터로 가져오자!
		getTopCategory();
		
		//서브카테고리 메서드를 상위카테고리 수만큼 호출하면서 2차원 ArrayList 구조를 생성하자!
		for(int i=0; i<topCategory.size(); i++) {
			String name = topCategory.get(i);	//top, down, accessory, shoes
			ArrayList subList = (ArrayList)getSubCategory(name);
			subCategory.add(subList);	//이차원 구조로 생성
		}
		
		//노드생성을 외부 메서드로부터 공수받자!
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("상품정보");
		/*
		for(int i=0; i<category.length; i++) {
			top.add(getCreatedNode(category[i], product[i]));
		}
		*/
		
		for(int i=0; i<topCategory.size(); i++) {
			String name = topCategory.get(i);
			top.add(getCreatedNode(name, subCategory.get(i)));
		}
		
		tree = new JTree(top);
		scroll = new JScrollPane(tree);
		
		add(scroll);
		
		//프레임과 리스너 연결
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disConnect();	//연결끊기
				System.exit(0);	//프로세스 종료
			}
		});
		
		setSize(400, 500);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);		//db연동 할때는 주석으로 막자!
		setLocationRelativeTo(null);
	}
	
	public void connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if(con==null) {
				JOptionPane.showMessageDialog(this, user+"로 접속에 실패하였습니다");
				System.exit(0);
			}else {
				this.setTitle(user + "로그인 중...");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disConnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//상위카테고리 가져오기
	public void getTopCategory() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from topcategory";
		
		try {
			pstmt = con.prepareStatement(sql);	//쿼리문 준비
			rs = pstmt.executeQuery();	//쿼리수행 및 결과담기
			
			//배열은 반드시 그 크기를 명시해야 한다.. 따라서 유연하지 못하다
			//String[] arr = new String[크기];
			//차라리 배열보다는 컬렉션 객체 중 List계열을 추천!
			//rs의 커서를 왔다갔다 하지 않아도 될것이다!
			while(rs.next()) {
				topCategory.add(rs.getString("name"));
			}
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
	
	//하위카테고리 가져오기
	public List getSubCategory(String name) {	//top, down, accessory, shoes
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList subList=new ArrayList();
		
		String sql = "select * from subcategory where topcategory_id=(select topcategory_id from topcategory where name=?)";
		//String sql = "select * from subcategory where topcategory_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				subList.add(rs.getString("name"));
			}
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
		return subList;	//호출하는 자가 하위카테고리 목록 가져갈 수 있도록...
	}
	
	//이 메서드를 호출하는 자가, 배열을 넘기면 배열의 길이만큼 노드를 구성하여 반환해줄 것임
	public DefaultMutableTreeNode getCreatedNode(String parentName, String[] childName) {//배열로 부모가 누군지, 자식은 누군지를 넘김
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName);	//부모생성
		//자식의 수만큼 노드 만들어 부모에 부착!
		if(childName!=null) {	//배열을 넘기지 않은 경우엔 실행을 막기 위해
			for(int i=0; i<childName.length; i++) {
				parent.add(new DefaultMutableTreeNode(childName[i]));
			}
		}
		return parent;
	}
	
	//위에꺼 오버로딩 (매개변수 다르게 하기)
	//위의 메서드는 배열을 처리하는 용이지만, 이 메서드는 이름은 같지만 List용으로 처리
	public DefaultMutableTreeNode getCreatedNode(String parentName, ArrayList childName) {//배열로 부모가 누군지, 자식은 누군지를 넘김
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName);	//부모생성
		//자식의 수만큼 노드 만들어 부모에 부착!
		if(childName!=null) {	//배열을 넘기지 않은 경우엔 실행을 막기 위해
			for(int i=0; i<childName.size(); i++) {
				parent.add(new DefaultMutableTreeNode(childName.get(i)));
			}
		}
		return parent;
	}
	
	public static void main(String[] args) {
		new ProductTree();
	}
}
