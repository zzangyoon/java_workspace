//4
package day1117.db;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeApp2 extends JFrame{
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
	
	public TreeApp2() {
		//노드생성을 외부 메서드로부터 공수받자!
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("상품정보");
		for(int i=0; i<category.length; i++) {
			top.add(getCreatedNode(category[i], product[i]));
		}
		
		tree = new JTree(top);
		scroll = new JScrollPane(tree);
		
		add(scroll);
		
		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		//db연동 할때는 주석으로 막자!
		setLocationRelativeTo(null);
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
	
	public static void main(String[] args) {
		new TreeApp2();
	}
}
