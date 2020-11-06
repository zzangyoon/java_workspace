/*	1.
	JTable 더 자세히 알아보기
	JTable MVC(Model, View, Control) 패턴을 적용한 컴포넌트이다!
	
*/
package day1106.db;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableApp extends JFrame{
	JTable table;	//MVC에서 view 이다
	JScrollPane scroll;
	MyModel model;
	
	public JTableApp() {
		table = new JTable(model = new MyModel());	//JTable과 컨트롤러인 MyModel 연결
		scroll = new JScrollPane(table);
		add(scroll);
		
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableApp();

	}

}
